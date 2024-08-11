package program.corejava.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class CountDownLatchs {

    static class Tasks implements Runnable{
    private int id;
    private CountDownLatch countDownLatch;

        public Tasks(int id, CountDownLatch countDownLatch) {
            this.id = id;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
        doWork();
        countDownLatch.countDown();
        }

        private void doWork() {
            try {
                System.out.println("Thread with Id :"+this.id+" is starts working");
            Thread.sleep(1000);
            }catch (InterruptedException e){
            e.printStackTrace();
            }
        }
    }
    //In Latch Single Thread is waiting for Other Threads to complete
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(5);
        ExecutorService executorService=Executors.newSingleThreadExecutor();

        for(int i=1;i<=5;i++)
            executorService.execute(new Tasks(i,latch));
        try {
            latch.await();   //for waiting the task executing by Main method
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("All Task is been completed");
        executorService.shutdown();
    }
}

