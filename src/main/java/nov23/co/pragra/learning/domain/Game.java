package nov23.co.pragra.learning.domain;
/*
    Its Abstract
 */
public interface Game {
    void play();
    static void info(){
        System.out.println("This is game interface");
    }
}

