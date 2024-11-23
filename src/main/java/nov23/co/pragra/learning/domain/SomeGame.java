package nov23.co.pragra.learning.domain;

public class SomeGame implements Game{
    private int age;
    @Override
    public void play(){
        System.out.println("SOME GAME");
    }
}
