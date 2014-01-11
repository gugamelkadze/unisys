package ge.edu.sangu.unisys.db;

public class RepositoryFactory {

	public Repository createRepository() {

		return new DataBaseManager();
	}

}