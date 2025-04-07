package io.github.charlie.var;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: 类变量
 */
public class VariablesDemo02 {
    // 类变量（静态字段）
    private static int count = 0;

    // 实例构造器
    public VariablesDemo02() {
        // 每次创建新的VariablesDemo02对象时增加计数
        count++;
    }

    // 静态方法用于获取当前计数
    public static int getCount() {
        return count;
    }

    // 非静态方法也可以访问静态字段
    public void printCount() {
        System.out.println("创建总数计数器实例: " + count);
    }
}

class VariablesDemo02Test {
    public static void main(String[] args) {
        System.out.println("在创建对象之前，计数是: " + VariablesDemo02.getCount());

        VariablesDemo02 c1 = new VariablesDemo02();
        VariablesDemo02 c2 = new VariablesDemo02();
        VariablesDemo02 c3 = new VariablesDemo02();

        // 打印计数值
        c1.printCount();
        c2.printCount();
        c3.printCount();

        System.out.println("总数计数器实例: " + VariablesDemo02.getCount());
    }
}