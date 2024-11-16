package trythis.vote;

import java.util.function.Supplier;

public class VoteManager {
    public static final int TOTAL_VOTERS = 10;
    private int ballots = 0;//용지 수
    private int process = 0;//진행률

    public static void main(String[] args) throws InterruptedException {
        VoteManager vm = new VoteManager();

        VoteSupplier supplier1 = new VoteSupplier(vm);
        VoteSupplier supplier2 = new VoteSupplier(vm);
        VoteCounter counter = new VoteCounter(vm);

        supplier1.start();
        supplier2.start();
        counter.start();
        supplier1.join();//이렇게 걸어주면 공급이 끝나기 전엔 프로그램이 종료되지 않음.
        supplier2.join();
    }

    public synchronized void supply() {//[todo]thread가 사용하는 method들은 기본적으로 synchronized 걸어줌.
        this.ballots++;
        notifyAll();//꼭 synchronized 걸려있어야함.
        System.out.println("Supply--" + this.ballots);
    }

    public synchronized void count() throws InterruptedException {
        while (this.ballots <= 0) {
            wait();
        }
        this.ballots--;
        process += 100 / TOTAL_VOTERS;
        System.out.println("Count:" + process + "%");
        //개표할 것 없는데 -할 수 없다.
    }

}
