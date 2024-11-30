package nov30.methodref;

@FunctionalInterface
interface BiConsumer{
    void consume(String a, String b);
}

interface Anything{
    int sum(int a, int b);
}

public class PrintTwo {
    public void printTwoName(String name1, String name2) {
        System.out.println("name1 = " + name1);
        System.out.println("name2 = " + name2);
    }

    public static void main(String[] args) {
        PrintTwo obj = new PrintTwo();
        BiConsumer biConsumer = obj::printTwoName;   //(a,b)-> System.out.println("A ==" + a + "\nB ==" + b);
        biConsumer.consume("ALok","Prateek");
        Anything anything = new Calculator()::sum;
    }
}
