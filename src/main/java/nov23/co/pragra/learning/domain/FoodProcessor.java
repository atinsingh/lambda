package nov23.co.pragra.learning.domain;

@FunctionalInterface
public interface FoodProcessor <T,U> {
     U process(T t);
}
