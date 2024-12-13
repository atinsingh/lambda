package dec12;

public class BlockingTask implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1_000; i++) {
            try {
                Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " +"Task finished");
    }
}
