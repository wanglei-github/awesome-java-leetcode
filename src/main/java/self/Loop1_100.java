package self;

import java.util.concurrent.CountDownLatch;

public class Loop1_100 {
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(i>=100){
                        break;
                    }
                    synchronized (Loop1_100.class) {
                        while (i % 2 == 0) {
                            System.out.println("偶数 :>>> : " + i);
                            i++;
                            try {
                                Loop1_100.class.notify();
                                Loop1_100.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(i>=100){
                        break;
                    }
                    synchronized (Loop1_100.class) {
                        while (i % 2 == 1) {
                            System.out.println("**** " + i);
                            i++;
                        }
                        try {
                            Loop1_100.class.notify();
                            Loop1_100.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        countDownLatch.await();
    }
}
