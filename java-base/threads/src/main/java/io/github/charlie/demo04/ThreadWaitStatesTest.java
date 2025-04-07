package io.github.charlie.demo04;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.assertEquals;

public class ThreadWaitStatesTest {

    @Test
    public void testThreadJoin() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(100); // 模拟线程执行一些任务
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        Thread.State stateBeforeJoin = thread.getState();
        thread.join(); // 当前线程进入 WAITING 状态，直到 thread 结束
        Thread.State stateAfterJoin = thread.getState();

        assertEquals(Thread.State.TIMED_WAITING, stateBeforeJoin); // thread.start() 后进入 TIMED_WAITING
        assertEquals(Thread.State.TERMINATED, stateAfterJoin); // thread 结束后进入 TERMINATED
    }

    @Test
    public void testObjectWait() throws InterruptedException {
        Object lock = new Object();
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(); // 线程进入 WAITING 状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Thread.sleep(100); // 确保线程进入 wait 状态
        Thread.State state = thread.getState();
        assertEquals(Thread.State.WAITING, state);

        synchronized (lock) {
            lock.notify(); // 唤醒线程
        }

        Thread.sleep(100); // 确保线程被唤醒并结束
        state = thread.getState();
        assertEquals(Thread.State.TERMINATED, state);
    }

    @Test
    public void testConditionAwait() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                condition.await(); // 线程进入 WAITING 状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        thread.start();
        Thread.sleep(100); // 确保线程进入 await 状态
        Thread.State state = thread.getState();
        assertEquals(Thread.State.WAITING, state);

        lock.lock();
        try {
            condition.signal(); // 唤醒线程
        } finally {
            lock.unlock();
        }

        Thread.sleep(100); // 确保线程被唤醒并结束
        state = thread.getState();
        assertEquals(Thread.State.TERMINATED, state);
    }

    @Test
    public void testLockSupportPark() throws InterruptedException {
        Thread thread = new Thread(() -> {
            LockSupport.park(); // 线程进入 WAITING 状态
        });

        thread.start();
        Thread.sleep(100); // 确保线程进入 park 状态
        Thread.State state = thread.getState();
        assertEquals(Thread.State.WAITING, state);

        LockSupport.unpark(thread); // 唤醒线程

        Thread.sleep(100); // 确保线程被唤醒并结束
        state = thread.getState();
        assertEquals(Thread.State.TERMINATED, state);
    }
}