package program.corejava.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Worker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("Producer method");
            condition.await();
            System.out.println("Restarted Producer method");
        }finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        lock.lock();
        try {
            System.out.println("Consumer method");
            Thread.sleep(3000);
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

}

public class ReentrantLocks {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(() -> {
            try {
                worker.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t2 = new Thread(() -> {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

}
