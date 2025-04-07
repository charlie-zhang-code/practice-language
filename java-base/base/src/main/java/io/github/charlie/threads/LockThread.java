package io.github.charlie.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class LockThread implements Runnable {
    int ticket = 100;

    // 创建锁对象,确保多个线程共享同一个锁对象
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockThread lockThread = new LockThread();
        new Thread(lockThread, "A").start();
        new Thread(lockThread, "B").start();
    }
}
