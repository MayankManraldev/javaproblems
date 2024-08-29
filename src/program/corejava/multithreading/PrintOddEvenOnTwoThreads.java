package program.corejava.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrintOddEvenOnTwoThreads {

    static ReentrantLock  lock=new ReentrantLock();
    static Condition  condition=lock.newCondition();

    static IntPredicate odd=(a)->a%2!=0;
    static IntPredicate even=a->a%2==0;

    private static void print(IntPredicate cond){

        IntStream.rangeClosed(1,20).filter(cond).forEach(a->printNo(a));
    }

    private static void printNo(int n){ //both thread tries to Acquire lock
        lock.lock(); // suppose Thread-1 acquires the lock
        try{
           condition.signal(); // Thread-1 signal to resume thread 2
            System.out.println(n +" Thread Name"+Thread.currentThread().getName()); // Thread-1 prints
            condition.await();  //Thread-1 going to waiting state and release the lock now thread-2 can can acquire lock
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock(); //thread-1 resume when thread-2 call signal() and await()
        }

    }

    public static void main(String[] args) {

        java.util.concurrent.CompletableFuture.runAsync(()->print(odd));
        java.util.concurrent.CompletableFuture.runAsync(()->print(even));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
 /*
 Step-by-Step Execution
    Thread 1 (Odd) Acquires the Lock:
        1. Thread 1 (printing odd numbers) acquires the lock using lock.lock().
        2. It prints the number and signals the condition using condition.signal().
        3. Then, it calls condition.await(), which puts it into a waiting state and releases the lock.
    Thread 2 (Even) Acquires the Lock:
         1. When Thread 1 calls condition.await(), it releases the lock.
         2. Thread 2 (printing even numbers), which was waiting to acquire the lock, now gets the chance to acquire it.
         3. Thread 2 acquires the lock, prints the number, and signals the condition using condition.signal().
         4. Then, Thread 2 calls condition.await(), which puts it into a waiting state and releases the lock.
    Thread 1 Resumes:
        1. When Thread 2 calls condition.signal(), it wakes up Thread 1.
        2. Thread 1 resumes execution after the await() call, reacquires the lock, and continues to the next number.
        3. This cycle repeats, with each thread signaling the other and then waiting.

Key Points
    1. Signaling and Awaiting: The condition.signal() call wakes up the other thread, allowing it to proceed.
    2. Lock Release: The condition.await() call releases the lock, allowing the other thread to acquire it.
    3. Alternating Execution: This mechanism ensures that the threads alternate in acquiring the lock and printing numbers.

Example Flow
    Thread 1: Acquires lock, prints odd number, signals, waits (releases lock).
    Thread 2: Acquires lock, prints even number, signals, waits (releases lock).
    Thread 1: Resumes, acquires lock, prints next odd number, signals, waits (releases lock).
    Thread 2: Resumes, acquires lock, prints next even number, signals, waits (releases lock).
*/


}

