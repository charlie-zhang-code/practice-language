package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class SaleThread1 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            sale();
        }
    }

    public synchronized static void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + ticket);
            ticket--;
        }
    }

    public static void main(String[] args) {
        SaleThread1 thread1 = new SaleThread1();
        SaleThread1 thread2 = new SaleThread1();
        SaleThread1 thread3 = new SaleThread1();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
