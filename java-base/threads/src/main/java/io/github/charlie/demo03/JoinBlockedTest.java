package io.github.charlie.demo03;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 线程执行过程中，遇到了其他线程对象的 join
 */
public class JoinBlockedTest {

    @Test
    public void testJoinBlocked() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("线程1正在运行");
                Thread.sleep(2000); // 线程1休眠2秒
                System.out.println("线程1完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("线程2正在等待线程1完成");
                thread1.join(); // 线程2等待线程1结束
                System.out.println("线程2恢复");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread2.join(); // 主线程等待线程2结束
    }
}