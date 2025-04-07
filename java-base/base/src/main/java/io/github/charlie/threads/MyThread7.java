package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class MyThread7 implements Runnable {
    private int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread7 thread1 = new MyThread7();
        Thread t1 = new Thread(thread1, "线程1");
        Thread t2 = new Thread(thread1, "线程2");
        Thread t3 = new Thread(thread1, "线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}
