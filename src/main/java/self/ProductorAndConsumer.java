package self;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class ProductorAndConsumer {


    private static ArrayList<Integer> queue = new ArrayList<Integer>(10);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch =new CountDownLatch(1);

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (queue) {

                        while (queue.size() == 10) {
                            System.out.println("生产已经满了 我要休息了");
                            queue.notify();
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        queue.add(1);
                    }
                }


            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (queue){
                        while (queue.isEmpty()){
                            System.out.println("队列空了，给我生产");
                            queue.notify();
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        queue.remove(0);
                    }
                }
            }
        }.start();
        countDownLatch.await();
    }

}
