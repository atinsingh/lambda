package dec12;
/*
    java support multi-threading by default
    What is thread
    Thread - Light Weight Sub Process.n
    Concurrency - Parallism
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println("Total Before : "  + System.currentTimeMillis());
        Thread thread = new Thread(new BlockingTask()); // 1
        thread.setName("Task Thread 1");
        thread.start();

        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 1_000; i++) {
                try {
                    Thread.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " " +"Task2 finished");
        }); // 2
        thread1.setName("Task Thread 2");
        thread1.start();

        AnotherBLockingTask anotherBLockingTask = new AnotherBLockingTask(); //3
        anotherBLockingTask.start();

        System.out.println("Total Now : "  + System.currentTimeMillis());
        System.out.println( Thread.currentThread().getName() + " " + "Hello World");
    }
}
