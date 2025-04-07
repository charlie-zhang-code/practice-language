package io.github.charlie.demo01;

/**
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
    }
}