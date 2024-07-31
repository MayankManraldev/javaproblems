package program.corejava.multithreading;

public class WaitNotifyExample {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread producer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Producer thread is running...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Producer thread is resumed...");
            }
        });


        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Consumer thread is running...");
                lock.notify();
                System.out.println("Consumer thread is resumed...");
            }
        });
        producer.start();
        consumer.start();
    }
}