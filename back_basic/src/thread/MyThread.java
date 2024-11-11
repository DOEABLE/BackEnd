package thread;

public class MyThread extends Thread {

		@Override
		public void run() {
				System.out.println("MyThread Started...");
				for (int i = 1; i <= 5; i++) {
						try {
								Thread.sleep(500);
								if (i > 1) {
										System.out.println(1 / 0);
								}

						} catch (InterruptedException e) {
								throw new RuntimeException(e);
						}

				}
		}
}
