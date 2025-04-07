package io.github.charlie.threads.single;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class LazyOne {
    private static LazyOne instance;

    private LazyOne() {
    }

    // 方式一
    public synchronized static LazyOne getInstance1() {
        if (instance == null) {
            instance = new LazyOne();
        }
        return instance;
    }

    // 方式二
    public static LazyOne getInstance2() {
        synchronized (LazyOne.class) {
            if (instance == null) {
                instance = new LazyOne();
            }
        }
        return instance;
    }

    // 方式三
    // 有指令重排的问题
    public static LazyOne getInstance3() {
        if (instance == null) {
            synchronized (LazyOne.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (instance == null) {
                    instance = new LazyOne();
                }
            }
        }

        return instance;
    }
}
