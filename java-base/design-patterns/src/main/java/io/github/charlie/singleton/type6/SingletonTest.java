package io.github.charlie.singleton.type6;

/**
 * 双重检查
 */
class Singleton {
    // 创建一个静态的对象，volatile 保证了可见性
    private static volatile Singleton instance;

    // 私有化构造器
    private Singleton() {
    }

    // 创建一个静态的公共方法，同时增加双重检查，保证线程安全
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance1.hashCode=" + instance1.hashCode());
    }
}
