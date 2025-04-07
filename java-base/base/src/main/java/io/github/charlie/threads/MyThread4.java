package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class MyThread4 extends Thread {
    @Override
    public void run() {
        int i = 100;

        while (i > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            i--;
        }
    }

    public static void main(String[] args) {
        MyThread4 thread1 = new MyThread4();
        thread1.start();

        MyThread4 thread2 = new MyThread4();
        thread2.start();

        MyThread4 thread3 = new MyThread4();
        thread3.start();
    }
}
