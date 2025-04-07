package io.github.charlie.threads.single;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class LazySingle {
    private LazySingle() {
    }

    private static LazySingle getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        protected static final LazySingle instance = new LazySingle();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LazySingle instance = LazySingle.getInstance();
            System.out.println(instance);
        });
        Thread t2 = new Thread(() -> {
            LazySingle instance = LazySingle.getInstance();
            System.out.println(instance);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
