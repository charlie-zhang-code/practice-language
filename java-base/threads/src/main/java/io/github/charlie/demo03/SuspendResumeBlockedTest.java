package io.github.charlie.demo03;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 线程被 suspend 挂起（已过时，容易发生死锁）
 */
public class SuspendResumeBlockedTest {

    @Test
    public void testSuspendResumeBlocked() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程正在运行");
            try {
                Thread.sleep(2000); // 线程休眠2秒
                System.out.println("线程完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        Thread.sleep(1000); // 确保线程开始运行
        System.out.println("挂起线程");
        thread.suspend(); // 挂起线程（已过时）
        Thread.sleep(1000); // 主线程休眠1秒
        System.out.println("恢复线程");
        thread.resume(); // 恢复线程（已过时）
        thread.join(); // 等待线程结束
    }
}