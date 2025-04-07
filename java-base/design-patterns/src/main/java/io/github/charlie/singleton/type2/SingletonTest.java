package io.github.charlie.singleton.type2;

/**
 * 饿汉式（静态代码块）
 */
class Singleton {
    // 构造器私有化
    private Singleton() {
    }

    // 创建一个静态的对象
    private static final Singleton instance;

    // 静态代码块，在类加载的时候创建对象
    static {
        instance = new Singleton();
    }

    // 提供一个公共的静态方法，返回实例对象
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
