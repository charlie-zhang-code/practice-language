package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class MyThread6 extends Thread {
    private static int count = 100;

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
        MyThread6 thread1 = new MyThread6();
        thread1.start();

        MyThread6 thread2 = new MyThread6();
        thread2.start();

        MyThread6 thread3 = new MyThread6();
        thread3.start();
    }
}
