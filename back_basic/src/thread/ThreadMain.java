package thread;

/**
 * 수업(MyThread, YourThread)
 */
public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        //demon은 시작전에 시켜놔야함.(자식이 죽으면 Daemon자신도 죽음.)
        Thread thread = new Thread();//아무것도 start안돼. 상속받아서 매소드 정의 해줘야 출력됨.
        MyThread myThread = new MyThread();//1번 방식
        Thread yourThread = new Thread(new YourThread());//2. thread화 - YourThread 내의 run 메소드만 실행


        //익명 inner 방식
        Thread thread3 = new Thread(new Runnable() {//Thread객체에서 start 돌리면 run메소드 내의 출력문밖에 안나와.
            @Override
            public void run() {
                System.out.println("Thread3 started...");
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread4 started!");
            }
        });


        //가장 많이 쓰이는 람다를 이용한 생성.
        MyThread thread5 = new MyThread(() -> {
            System.out.println("Thread5 start...");
        });

        Thread useLambdaThread = new Thread(() ->
                new YourThread().run()
        );

        myThread.start();//1

        //한 thread가 끝나야 yourThread가 실행됨! 여기선 2000을 부여하면서 MyStart 후 2초후 YourStart실행됨
        yourThread.start();
        yourThread.join();
        //thread3.start();
        //thread4.start();
        //thread4.join();
        System.out.println(Thread.currentThread().getName());
        thread5.start();
        thread5.join();
        useLambdaThread.start();


        myThread.setPriority(Thread.MAX_PRIORITY);
        yourThread.setPriority(Thread.MIN_PRIORITY);
//
//        myThread.setDaemon(true);//start되기 전에 Daemon화 시켜야한다.(MyThread Daemon화)
//        myThread.start();//myThread에 있는 run함수를 실행해준다.(JVM에 의해 스케쥴되기 시작.)-> 주의: 내가 직접 .run()하는거 아님!
//        //yourThread.start();
//        System.out.println(1 / 0);

    }
}
