package demo3;

public class App {

	public static void main(String[] args) {

		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);

			for (int i = 0; i < 10; i++) {
				System.out.println("hello " + i);

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		};

		Thread t1 = new Thread(task);

		t1.start();

	}

}
