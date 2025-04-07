package io.github.charlie.singleton.type1;

/**
 * 饿汉式(静态变量)
 */
class Singleton {
    // 私有的构造方法，防止外部创建实例
    private Singleton() {
    }

    // 创建一个静态变量，保存唯一实例
    private static final Singleton instance = new Singleton();

    // 获取唯一实例的方法
    public static Singleton getInstance() {
        return instance;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
