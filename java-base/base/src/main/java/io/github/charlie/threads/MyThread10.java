package io.github.charlie.threads;

import java.util.concurrent.*;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/3
 * @Description: TODO
 */
class MyThread10D implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class MyThread10E implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class MyThread10F implements Callable {

    @Override
    public Object call() throws Exception {
        int evenSum = 0;

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                evenSum += i;
            }
        }

        return evenSum;
    }
}

public class MyThread10 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

        threadPoolExecutor.setMaximumPoolSize(50);
        threadPoolExecutor.execute(new MyThread10D());
        threadPoolExecutor.execute(new MyThread10E());

        try {
            Future future = executorService.submit(new MyThread10F());
            Object o = future.get();
            System.out.println(o);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
