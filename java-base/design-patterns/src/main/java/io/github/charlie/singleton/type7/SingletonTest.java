package io.github.charlie.singleton.type7;

/**
 * 静态内部类
 */
class Singleton {
    // 创建一个静态的对象，volatile 保证了可见性
    private static volatile Singleton instance;

    // 私有化构造器
    private Singleton() {
    }

    // 静态内部类
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 获取实例
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton.getInstance().hashCode())).start();
        }
    }
}
