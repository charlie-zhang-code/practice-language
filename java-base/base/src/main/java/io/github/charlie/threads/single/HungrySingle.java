package io.github.charlie.threads.single;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class HungrySingle {
    private static HungrySingle instance = new HungrySingle();

    private HungrySingle() {
    }

    public static HungrySingle getInstance() {
        return instance;
    }
}

class Test {
    static HungrySingle hs1 = null;
    static HungrySingle hs2 = null;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> hs1 = HungrySingle.getInstance());
        Thread t2 = new Thread(() -> hs2 = HungrySingle.getInstance());
        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(hs1); // io.github.charlie.threads.single.HungrySingle@448139f0
        System.out.println(hs2); // io.github.charlie.threads.single.HungrySingle@448139f0
        System.out.println(hs1 == hs2); // true
    }
}
