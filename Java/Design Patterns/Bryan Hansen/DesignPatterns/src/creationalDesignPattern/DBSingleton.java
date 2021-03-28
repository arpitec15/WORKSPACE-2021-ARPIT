package creationalDesignPattern;

public class DBSingleton {

	private static volatile DBSingleton instance = new DBSingleton();

	private DBSingleton() {

		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create");
		}

	}

	public static DBSingleton getInstance() {

//		for making it lazy loaded
		if (instance == null) {
			synchronized (DBSingleton.class) {
				if (instance == null) {
					instance = new DBSingleton();
				}
			}
		}

		return instance;
	}

	public static void main(String[] args) {

		DBSingleton instance1 = DBSingleton.getInstance();
		System.out.println(instance1);

		DBSingleton instance2 = DBSingleton.getInstance();
		System.out.println(instance2);

	}

}
