package testSynchronized;

/**
 * 共享资源，需要提供给消费者和生产者，消费和生产的方法
 * Creat by GG
 * Date on 2020/8/3  5:15 下午
 */

public class Clerk {
    private int product = 0;

    //进货
    public synchronized void add(){
        while (product >= 1){
            System.out.println("有货不用进");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //进货
        product ++;
        System.out.println(Thread.currentThread().getName() + "::" + product);
        //唤醒其他线程
        this.notifyAll();
    }
    //出货
    public synchronized void delete(){
        while (product <= 0){
            System.out.println("没货不能出");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //出货
        product --;
        System.out.println(Thread.currentThread().getName() + "::" + product);
        //唤醒其他线程
        this.notifyAll();
    }
}
