package testSynchronized;

/**
 * 消费者循环调用delete
 * Creat by GG
 * Date on 2020/8/3  5:24 下午
 */
public class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
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
            clerk.delete();

        }
    }
}
