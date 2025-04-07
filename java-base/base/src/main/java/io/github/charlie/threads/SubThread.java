package io.github.charlie.threads;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/2
 * @Description: TODO
 */
public class SubThread extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }

    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        System.out.println(subThread.getName() + ": " + subThread.getState());
        subThread.start();

        while (State.TERMINATED != subThread.getState()) {
            System.out.println(subThread.getName() + ": " + subThread.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(subThread.getName() + ": " + subThread.getState());
    }
}
