package nov30;

@FunctionalInterface
public interface AlokFunction<T,R> {
    R transform(T a);
}
