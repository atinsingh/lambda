package dec12;

public class SolutionTwo {
    public static void main(String[] args) throws InterruptedException {
        // 1  - > We can implement interface runnable
        Thread t1   = new Thread(new Task()); // Thread is created with state of NEW
        t1.start(); // Thread has been changed to RUNNABLE
        // FROM RUNNABLE --> WAITING OR TIMED_WAITING / BLOCKED  --> RUNNABLE --> TERMINATED
        Thread t2   = new Thread(()->{
            System.out.println("Executing " + Thread.currentThread().getName());
        });
        t2.start();
        Task2 task2 = new Task2();
        task2.start();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i <10 ; i++) {
//                try {
//                    //Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

            }
        });

        System.out.println(String.format("Thread: %s has State : %s", thread1.getName(), thread1.getState()));
        thread1.start();
        while (thread1.getState().name() != "TERMINATED") {
            System.out.println(String.format("Thread: %s has State : %s", thread1.getName(), thread1.getState()));
            Thread.sleep(10000);
        }
        thread1.join(); // I will wait in main thread till thread 1 is completed
        System.out.println(String.format("Thread: %s has State : %s", thread1.getName(), thread1.getState()));

        thread1.start(); // use to start thread execution
        thread1.run(); //  You define your task in run method
        Thread.sleep(5000); // Suspends execution of thread for time provided
        thread1.join(); //  Waits till excution of the thread is completed
        thread1.isAlive(); //  Check if your thread is still active


    }
}
// 1
class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Executing " + Thread.currentThread().getName());
    }
}

class Task2 extends Thread {
    @Override
    public void run() {
        System.out.println("Executing " + Thread.currentThread().getName());
    }


}
