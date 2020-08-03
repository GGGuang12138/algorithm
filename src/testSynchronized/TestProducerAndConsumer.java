package testSynchronized;

/**
 * 生产者消费者问题案例
 * 只有两个线程交叉进行不会出现线程安全问题
 * 多个线程进行需将wait()放在while循环中以解决虚假唤醒情况
 * Creat by GG
 * Date on 2020/8/3  4:43 下午
 */
public class TestProducerAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Consumer consumer = new Consumer(clerk);
        Producer producer = new Producer(clerk);
        new Thread(consumer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(producer).start();
    }

}

