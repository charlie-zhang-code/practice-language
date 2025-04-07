package io.github.charlie.demo03;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 线程执行过程中，同步监视器调用了 wait，让它等待某个 notify
 */
public class WaitNotifyBlockedTest {

    private final Object lock = new Object();
    private boolean notified = false;

    @Test
    public void testWaitNotifyBlocked() throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("线程正在等待");
                    lock.wait(); // 线程进入等待状态
                    System.out.println("通知线程");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Thread.sleep(1000); // 确保线程进入等待状态
        synchronized (lock) {
            System.out.println("通知等待线程");
            lock.notify(); // 唤醒等待的线程
        }
        thread.join(); // 等待线程结束
    }
}