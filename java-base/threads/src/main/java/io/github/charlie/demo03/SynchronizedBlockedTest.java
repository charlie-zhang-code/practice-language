package io.github.charlie.demo03;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 线程试图获取一个同步监视器，但该同步监视器正被其他线程持有
 */
public class SynchronizedBlockedTest {

    private final Object lock = new Object();

    @Test
    public void testSynchronizedBlocked() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("线程1持有锁");
                    Thread.sleep(2000); // 线程1持有锁并休眠2秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("线程2正在尝试获取锁");
            synchronized (lock) {
                System.out.println("线程2获得了锁");
            }
        });

        thread1.start();
        Thread.sleep(100); // 确保线程1先获取锁
        thread2.start();
        Thread.sleep(3000); // 等待线程2获取锁
    }
}