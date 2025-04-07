package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class SaleThread2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            sale();
        }
    }

    public synchronized void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票");
            ticket--;
        }
    }

    public static void main(String[] args) {
        SaleThread2 saleThread2 = new SaleThread2();
        new Thread(saleThread2, "张三").start();
        new Thread(saleThread2, "李四").start();
        new Thread(saleThread2, "王五").start();
    }
}
