package program.corejava.multithreading;

public class DeadLock {


    public static void main(String[] args) {
        Object ob1 = new Object();
        Object ob2 = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println("t1 started");
            synchronized (ob1) {
                System.out.println("inside t1 ob1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (ob2) {
                    System.out.println("inside t1 ob2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 started");
            synchronized (ob2) {
                System.out.println("inside t2 ob2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (ob1) {
                    System.out.println("inside t2 ob1");
                }
            }
        });

        t1.start();
        t2.start();

    }


}
