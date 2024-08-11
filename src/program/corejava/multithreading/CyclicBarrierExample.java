package program.corejava.multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierExample {

    //In Cyclic barrier multiple thread can wait each other
    static class Tasks implements Runnable {
        private int id;
        private Random random;
        private CyclicBarrier cyclicBarrier;

        public Tasks(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.random = new Random();
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            doWork();
        }

        private void doWork() {
            try {
                System.out.println("Thread with Id :" + this.id + " is starts working");
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                cyclicBarrier.await();  //when all thread call awaits this is when barrier is broken
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("after the awaits()...");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5,()->{
            System.out.println("All Task has been finished");
        });
        for (int i=1;i<=5;i++){
            executorService.execute(new Tasks(i,cyclicBarrier));
        }
        executorService.shutdown();

    }
}

