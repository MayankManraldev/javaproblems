package program.corejava.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class CompletableFutureExamples {
    private static Object object = new Object();

    private static IntPredicate evenPredicate = a -> a % 2 == 0;
    private static IntPredicate oddPredicate = a -> a % 2 != 0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> printNo(evenPredicate));
        CompletableFuture.runAsync(() -> printNo(oddPredicate));
        Thread.sleep(1000);
    }



    public static void printNo(IntPredicate cond) {
        IntStream.rangeClosed(1, 10).filter(cond).forEach(CompletableFutureExamples::execute);
    }

    private static void execute(int no) {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + "==" + no);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
