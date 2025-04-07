package io.github.charlie.demo03;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 线程执行过程中，同步监视器调用了 wait(time)
 */
public class WaitTimeBlockedTest {

    private final Object lock = new Object();

    @Test
    public void testWaitTimeBlocked() throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("线程正在等待2秒");
                    lock.wait(2000); // 线程等待2秒
                    System.out.println("线程从等待中醒来");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Thread.sleep(1000); // 确保线程进入等待状态
        assertFalse(thread.isAlive()); // 线程仍在运行，因为等待未结束
        thread.join(); // 等待线程结束
        assertTrue(thread.isAlive()); // 线程已经结束
    }
}