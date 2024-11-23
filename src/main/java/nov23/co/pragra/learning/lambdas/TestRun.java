package nov23.co.pragra.learning.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TestRun {
    public static void main(String[] args) {
        Eat e1 =  ()->  "Eating Lambda ICE CREAM";

        System.out.println("eat.eat() = " + e1.eat());

        IGame game = ( a,  b)-> Math.random()>0.5? a:b;  //

        System.out.println("outcome= " + game.play("Sep 2024", "Nov 2024"));
        game.noShow();

        Work work = n-> System.out.println("Working with " + n);

        List<String> names = Arrays.asList("Gagan", "Jagmeet", "Anmol","Prateek", "Alok");
        List<String> guest = new ArrayList<>(names);
        System.out.println(names);
        names.sort( (s1,s2)-> s1.compareTo(s2) );
        guest.removeIf(n->n.contains("A"));
        System.out.println(guest);
    }
}

interface Work {
    void work(String employee);
}

@FunctionalInterface
interface IGame {
    String play(String teamA, String teamB);
    default void noShow(){
        System.out.println("No Game");
    }
}
