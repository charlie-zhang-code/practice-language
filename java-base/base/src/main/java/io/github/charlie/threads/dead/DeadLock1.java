package io.github.charlie.threads.dead;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class DeadLock1 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // 线程1
        new Thread(() -> {
            synchronized (sb1) { // 锁定 sb1
                sb1.append("a");
                sb2.append("b");

                try {
                    Thread.sleep(100);  // 暂停10毫秒，增加死锁发生的可能性
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (sb2) {  // 尝试锁定 sb2
                sb1.append("c");
                sb2.append("d");

                System.out.println(sb1);
                System.out.println(sb2);
            }
        }).start();


        // 线程2
        new Thread(() -> {
            synchronized (sb2) { // 锁定 sb2
                sb1.append("e");
                sb2.append("f");

                try {
                    Thread.sleep(100); // 暂停10毫秒，增加死锁发生的可能性
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (sb1) { // 尝试锁定 sb1
                    sb1.append("g");
                    sb2.append("h");

                    System.out.println(sb1);
                    System.out.println(sb2);
                }
            }
        }).start();
    }
}
