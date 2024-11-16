package trythis.vote;

public class VoteSupplier extends Thread {
    private VoteManager vm;

    public VoteSupplier(VoteManager vm) {
        this.vm = vm;

    }


    @Override
    public void run() {
        for (int i = 0; i < VoteManager.TOTAL_VOTERS; i++) {
            try {
                Thread.sleep(200);
                vm.supply();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
