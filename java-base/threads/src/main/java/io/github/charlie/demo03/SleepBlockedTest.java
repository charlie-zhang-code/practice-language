package io.github.charlie.demo03;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 线程调用了 sleep 方法
 */
public class SleepBlockedTest {

    @Test
    public void testSleepBlocked() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("线程将进入睡眠状态");
                Thread.sleep(2000); // 线程休眠2秒
                System.out.println("线程从睡梦中醒来");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        Thread.sleep(1000); // 主线程休眠1秒，确保子线程进入休眠状态
        assertFalse(thread.isAlive()); // 线程仍在运行，因为休眠未结束
        thread.join(); // 等待线程结束
        assertTrue(thread.isAlive()); // 线程已经结束
    }
}