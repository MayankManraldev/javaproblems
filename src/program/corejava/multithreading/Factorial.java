package program.corejava.multithreading;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.math.BigInteger;

public class Factorial {
    static class FactorialTask extends RecursiveTask<BigInteger> {
        private final int start, end;

        FactorialTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected BigInteger compute() {
            if (start == end) {
                return BigInteger.valueOf(start);
            } else if (end - start == 1) {
                return BigInteger.valueOf(start).multiply(BigInteger.valueOf(end));
            } else {
                int mid = (start + end) / 2;
                FactorialTask task1 = new FactorialTask(start, mid);
                FactorialTask task2 = new FactorialTask(mid + 1, end);
                task1.fork();
                return task2.compute().multiply(task1.join());
            }
        }
    }

    public static BigInteger factorial(int n) {
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(new FactorialTask(1, n));
    }

    public static void main(String[] args) {
        int number = 5; // Change this to any number you want to find the factorial of
        System.out.println("Factorial of " + number + " is " + factorial(number));
    }
}
