package io.github.charlie.singleton.type8;

/**
 * 枚举
 */
enum Singleton {
    INSTANCE; // 枚举

    public void sayOK() {
        System.out.println("ok");
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}
