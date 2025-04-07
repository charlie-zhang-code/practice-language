package io.github.charlie.threads.pcs;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/3
 * @Description: TODO
 */
class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("====================");
        while (true) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 生产者生产
            clerk.add();
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("====================");
        while (true) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 消费者消费
            clerk.minus();
        }
    }
}

class Clerk {
    private int product = 0;
    private static final int MAX = 20;
    private static final int MIN = 1;

    public synchronized void add() {
        if (product < MAX) {
            product++;
            System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + product);
            this.notifyAll(); // 唤醒所有线程
        } else {
            try {
                this.wait(); // 阻塞当前线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void minus() {
        if (product >= MIN) {
            product--;
            System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + product);
            this.notifyAll();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ConsumerProducerTest1 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");
        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }
}
