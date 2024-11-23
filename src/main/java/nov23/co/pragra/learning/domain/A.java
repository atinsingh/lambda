package nov23.co.pragra.learning.domain;

public interface A {
    default void play(){
        System.out.println("Playing");
    }
}

interface  B {
    default void play(){
        System.out.println("Playing B");
    }
}

class C implements A, B {
    @Override
    public void play() {
        B.super.play();
    }

    public static void main(String[] args) {
        A obj = new C();
        obj.play();

    }
}
