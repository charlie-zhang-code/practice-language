package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
class Ticket1 {
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

public class SaleThread3 {
    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (ticket) {
                    ticket.sale();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (ticket) {
                    ticket.sale();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                synchronized (ticket) {
                    ticket.sale();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
