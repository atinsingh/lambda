package dec12;

public class SolutionPriority {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1  = new Thread(()->{
           for (int i = 0; i < 10000; i++) {
               counter.increment();
           }
        });
        Thread t2  = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count is  = " + counter.getCount());

        // Thread has their data/ stack
    }
}

class Counter {
    private int count = 0;
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
