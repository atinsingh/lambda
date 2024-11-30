package nov30.methodref;

@FunctionalInterface
public interface AlokFunction<T,R> {
    R transform(T a);
}
