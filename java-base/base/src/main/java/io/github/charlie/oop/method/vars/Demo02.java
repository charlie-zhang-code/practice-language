package io.github.charlie.oop.method.vars;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 参数传递机制示例类
 */
public class Demo02 {
    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public void swap(Data data) {
        int temp = data.a;
        data.a = data.b;
        data.b = temp;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        Demo02 demo02 = new Demo02();
        demo02.swap(a, b);
        System.out.println("a = " + a + ", b = " + b); // 值没有变化，说明形参是值传递

        Data data = new Data(1, 2);
        demo02.swap(data);
        System.out.println("data.a = " + data.a + ", data.b = " + data.b); // 值发生了变化
    }
}


class Data {
    int a;
    int b;

    public Data(int a, int b) {
        this.a = a;
        this.b = b;
    }
}