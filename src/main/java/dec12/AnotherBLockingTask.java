package dec12;

public class AnotherBLockingTask extends Thread{
    @Override
    public void run() {
        System.out.println("AnotherBLockingTask started");
    }
}
