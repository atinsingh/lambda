package nov23.co.pragra.learning.domain;

import java.util.List;

@FunctionalInterface
public interface Hamburger {
    int count =0; // Valid today as well
    static int getCount(){
        return count;  // valid
    }

    List<String> getIngredients();

    default double getPrice(){
        return 0;
    }
}
