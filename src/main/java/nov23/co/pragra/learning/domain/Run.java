package nov23.co.pragra.learning.domain;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        Printer<String> pr = t-> System.out.println(t);
        pr.print("Hello World");

        FoodProcessor<String, Double> p = n-> Double.parseDouble(n);



        FoodProcessor<String , String> fp  = (s1)->s1.equalsIgnoreCase("Potato")?"Samosa":"Burger";
        System.out.println("fp.process(\"Potato\") = " + fp.process("Potato"));

    }
}
