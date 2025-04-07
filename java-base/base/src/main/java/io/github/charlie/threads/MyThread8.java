package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
class Ticket {
    private int number = 30;

    public void sale() {
        if (number > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余" + number + "票");
            number--;
        } else {
            System.out.println("票已售完");
        }
    }

    public int getNumber() {
        return number;
    }


}

public class MyThread8 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(() -> {
            while (true) {
                ticket.sale();
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                ticket.sale();
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                ticket.sale();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
