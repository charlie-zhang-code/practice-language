package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class MyThread3 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        myThread3.setDaemon(true);
        myThread3.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main thread");
        }
    }
}
