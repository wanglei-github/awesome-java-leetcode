package easy._001;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolWithSyncQueue extends ThreadPoolExecutor {


    public ThreadPoolWithSyncQueue(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new SynchronousQueue<>());
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ThreadPoolWithSyncQueue poolWithSyncQueue = new ThreadPoolWithSyncQueue(1, 1, 1000, TimeUnit.MILLISECONDS);
        for (; ; ) {
            poolWithSyncQueue.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(123);
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
