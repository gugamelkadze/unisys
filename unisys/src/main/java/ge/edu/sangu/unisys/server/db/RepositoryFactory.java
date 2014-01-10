package ge.edu.sangu.unisys.server.db;

public class RepositoryFactory {

	public Repository createRepository() {

		return new DataBaseManager();
	}

}