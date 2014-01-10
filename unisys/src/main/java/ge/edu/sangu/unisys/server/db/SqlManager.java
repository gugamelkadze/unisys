package ge.edu.sangu.unisys.server.db;

import ge.edu.sangu.unisys.server.models.Group;
import ge.edu.sangu.unisys.server.models.User;
import ge.edu.sangu.unisys.shared.exceptions.dbexceptions.InvalidUsernameOrPasswordException;
import ge.edu.sangu.unisys.shared.exceptions.dbexceptions.UserNotFoundException;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

enum SqlManager {
	INSTANCE;

	// query strings

	private static final String getUserByUsernameSql = "select u from User u "
			+ "where u.firstname = ?0 and u.lastname = ?1";

	// other variables

	private EntityManagerFactory emf;

	private Logger LOG = Logger.getLogger(SqlManager.class);

	private SqlManager() {
		emf = Persistence.createEntityManagerFactory("UniSys");
		LOG.info("Entity manager factory created.");
	}

	public void createGroup(Group group) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(group);
			et.commit();

		} catch (Exception ex) {
			LOG.error(ex.getMessage(), ex);
			et.rollback();

		} finally {

			em.close();
		}
	}

	private static final String getUserByUsernamePasswordSql = "select u from User u "
			+ " where u.firstName = ?0 and u.lastName = ?1 and u.password = ?2";

	public User getUserByUsernamePassword(String firstName, String lastName,
			String password) {
		EntityManager em = emf.createEntityManager();

		User user;

		try {
			List<User> users = em
					.createQuery(getUserByUsernamePasswordSql, User.class)
					.setParameter(0, firstName).setParameter(1, lastName)
					.setParameter(2, password).getResultList();

			if (users.size() != 1) {
				throw new InvalidUsernameOrPasswordException();
			}
			user = users.get(0);
		} finally {
			em.close();
		}

		return user;
	}

	private User getUserByUsername(User user) throws UserNotFoundException {
		EntityManager em = emf.createEntityManager();

		try {
			List<User> users = em.createQuery(getUserByUsernameSql, User.class)
					.setParameter(0, user.getFirstName())
					.setParameter(1, user.getLastName()).getResultList();

			if (users.size() != 1) {
				throw new UserNotFoundException(user);
			}

			user = users.get(0);

		} finally {
			em.close();
		}

		return user;
	}

	public void addUserToGroup(Group group, User user)
			throws UserNotFoundException {
		EntityManager em = emf.createEntityManager();

		User user1 = getUserByUsername(user);

		user = user1;

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			Set<User> users = group.getUsers();

			users.add(user);

			group.setUsers(users);

			Set<Group> groups = user.getGroups();

			groups.add(group);

			user.setGroups(groups);

			group = em.merge(group);

			user = em.merge(user);

			et.commit();
		} catch (Exception ex) {
			LOG.error(ex.getMessage(), ex);

			et.rollback();
		}

	}

	public static void main(String[] args) {
		String firstName = "dato";
		String lastName = "bula";
		String password = "datobula";

		User user = new RepositoryFactory().createRepository().authenticate(
				firstName, lastName, password);

		System.out.println(user.geteMail());
	}
}