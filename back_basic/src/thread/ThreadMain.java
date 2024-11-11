package thread;

/**
 * 수업(MyThread, YourThread)
 */
public class ThreadMain {
		public static void main(String[] args) throws InterruptedException {

				//demon은 시작전에 시켜놔야함.(자식이 죽으면 Daemon자신도 죽음.)
				MyThread myThread = new MyThread();
				//Thread yourThread = new Thread(new YourThread());
				Thread thread3 = new Thread(new Runnable() {
						@Override
						public void run() {
								System.out.println("Thread3 start");
						}
				});

				//얘가 많이 쓰이는 람다를 이용한 생성.
				Thread thread4 = new Thread(() -> {
						System.out.println("Thread4 start...");
				});

				myThread.setPriority(Thread.MIN_PRIORITY);
				//yourThread.setPriority(Thread.MAX_PRIORITY);

				myThread.setDaemon(true);//start되기 전에 Daemon화 시켜야한다.(MyThread Daemon화)
				myThread.start();//myThread에 있는 run함수를 실행해준다.(JVM에 의해 스케쥴되기 시작.)
				myThread.join(2000);//한 thread가 끝나야 yourThread가 실행됨!
				//yourThread.start();
				thread4.start();
				System.out.println(1 / 0);

		}
}
