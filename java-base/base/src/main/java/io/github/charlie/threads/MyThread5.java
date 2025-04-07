package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class MyThread5 extends Thread {
    private int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + count);
            count--;
        }
    }

    public static void main(String[] args) {
        MyThread5 thread1 = new MyThread5();
        thread1.start();

        MyThread5 thread2 = new MyThread5();
        thread2.start();

        MyThread5 thread3 = new MyThread5();
        thread3.start();
    }
}
