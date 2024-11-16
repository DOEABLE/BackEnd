package thread;

public class YourThread implements Runnable {

    @Override
    public void run() {
        System.out.println("YourThread Started...");
        for (int i = 0; i < 5; i++) {
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
