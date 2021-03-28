package demo4;

public class DemoSync {

	private int count = 0;

	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) throws InterruptedException {

		DemoSync ds = new DemoSync();

		ds.doWork();

	}

	public void doWork() throws InterruptedException {

		Runnable task = () -> {
			for (int i = 0; i < 10; i++) {
				increment();
			}
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count is " + count);
	}

}
