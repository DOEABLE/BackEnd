package thread;

public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        System.out.println("MyThread Started...");
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("MyThread = " + i);
        }
        System.out.println("MyThread end.");
    }
}
