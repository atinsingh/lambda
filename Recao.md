# Recapping the functional programming
For we should have functional interface for functional programming

Pre suppilied functional interface are part of package 
```cmd
java.util.function.*
```
Popular ones are 
```javascript

class Home {
    main(){
        Predicate<T> predicate;
        // Have one abstract method boolean test(T a) 
        Supplier<T> supplier;
        // Have one abstract method T get()
        
        Consumer<T> consumer ;
        // Have one abstract method void accpet(T a)
        
        Function<T,R> function;
        // Have one abstract method R change( T a )
        BiFunction<T,R,U> byfunction;
        // Have one abstract method U change( T a, R b )
            
    }
}

```
### LAMBDAS 
For functinal interfaces we can create lambdas, which inline implemetation
of method in functional interface 
Example 
```java
@FunctionalInterface
interface Play {
    String getResult();
}
interface Multiply {
    double multiply(double a, double b);
}
// Implementatiom
class Solution {
    public static void main(String[] args) {
        Play play = ()->"Winner";
        Multiply multiply = (a,b)->a*b;
    }
}

```
### Method reference 
Instead of implementing lambas we can refer to exiting method 
which has same parameters and return type 
Example 
```java
@FunctionalInterface
interface Play {
    String getResult();
}
interface Multiply {
    double multiply(double a, double b);
}
// Implementatiom
class Solution {
    public static void main(String[] args) {
        Play play = ()->"Winner";
        Play play1 = Solution::generate;
    }
    static String generate(){
        return "ECHO";
    }
}
```
## Stream 
Stream represent the continuous flow of element/data from source 
its used for data aggregation and manupulation. 