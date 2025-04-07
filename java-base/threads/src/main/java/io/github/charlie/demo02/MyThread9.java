package io.github.charlie.demo02;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 
 * @Date: 2025/4/3
 * @Description: TODO
 */
public class MyThread9 implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        MyThread9 myThread9 = new MyThread9();
        FutureTask futureTask = new FutureTask(myThread9);
        new Thread(futureTask, "A").start();

        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}