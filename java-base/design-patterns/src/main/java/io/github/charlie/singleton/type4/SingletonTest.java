package io.github.charlie.singleton.type4;

/**
 * 懒汉式(线程安全，同步方法)
 */
class Singleton {
    // 创建一个静态的对象
    private static Singleton instance;

    // 私有化构造器
    private Singleton() {
    }

    // 创建一个公共的静态方法，用于获取实例，synchronized 保证线程安全
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
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
