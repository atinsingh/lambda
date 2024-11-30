package nov30.methodref;

public class MethodRef {

    public void doSomthing(String x){
        System.out.println(x);
    }

    public static void main(String[] args) {
        AlokFunction<Integer, String> alok =  MethodRef::intToString;
        MethodRef obj = new MethodRef();

        AloksConsumer aloksConsumer = t->System.out.println(t);

        AloksConsumer consumer = AwesomePrinter::printJokes;


        consumer.printer("Hello World");

        System.out.println("alok.transform(1344) = " + alok.transform(1344));



    }


    public static String intToString(int x){
        return "Hello "+ x;
    }
}
