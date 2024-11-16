package thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread Started...");
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
