package myTest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiongjiaxin on 2017/7/26.
 *
 * 现在有T1、T2、T3三个线程，保证T2在T1执行完后执行，T3在T2执行完后执行
 */
public class ThreadExecuteSequentially {
    static class MyRunnabel implements Runnable{
        CountDownLatch countDownLatch;

        MyRunnabel(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        final CountDownLatch t1Latch = new CountDownLatch(1);
        final CountDownLatch t2Latch = new CountDownLatch(1);

        final Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T1");
                t1Latch.countDown();
            }
        });

        final Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    T1.join();  //引用T1线程，等待T1线程执行完
                    t1Latch.await();
                    System.out.println("T2");
                    t2Latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread T3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    T2.join();  //引用T2线程，等待T2线程执行完
                    t2Latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T3");
            }
        });
        T3.start();
        T2.start();
        T1.start();//这三个线程启动没有先后顺序的
    }
}
