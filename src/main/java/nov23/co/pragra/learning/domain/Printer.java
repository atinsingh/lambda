package nov23.co.pragra.learning.domain;

@FunctionalInterface
public interface Printer <T> {
    void print(T item);
}
