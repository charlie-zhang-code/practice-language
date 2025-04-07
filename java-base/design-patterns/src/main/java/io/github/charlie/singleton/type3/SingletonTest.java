package io.github.charlie.singleton.type3;

/**
 * 懒汉式(线程不安全)
 */
class Singleton {
    // 创建一个静态的对象
    private static Singleton instance;

    // 私有化构造器
    private Singleton() {
    }

    // 创建一个公共的访问方法
    public static Singleton getInstance() {
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
