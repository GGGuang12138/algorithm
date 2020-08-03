package testSynchronized;

/**
 * 生产者，循环调用add
 * Creat by GG
 * Date on 2020/8/3  5:24 下午
 */
public class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.add();

        }
    }
}
