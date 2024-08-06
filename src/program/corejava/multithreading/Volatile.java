package program.corejava.multithreading;

class Workers {
    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    private volatile boolean terminated;


    public void run() {
        while (!isTerminated()) {
            System.out.println("Thread is running "+Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Volatile {
    public static void main(String[] args) {
        Workers worker = new Workers();
        Thread t1 = new Thread(worker::run,"WorkerThread");
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.setTerminated(true);
        System.out.println("Worker is terminated");
    }
}