package thread;

public class YourThread implements Runnable {

    @Override
    public void run() {
        System.out.println("YourThread Started...");
        System.out.println(Thread.currentThread().getName());
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("YourThread = " + i);
        }
        System.out.println("YourThread end.");
    }
}
