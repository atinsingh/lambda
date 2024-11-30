package nov30;

public class MethodRef {

    public void doSomthing(String x){
        System.out.println(x);
    }

    public static void main(String[] args) {
        AlokFunction<Integer, String> alok =  MethodRef::intToString;
        MethodRef obj = new MethodRef();
        AloksConsumer consumer = obj::doSomthing;

        System.out.println("alok.transform(1344) = " + alok.transform(1344));



    }


    public static String intToString(int x){
        return "Hello "+ x;
    }
}
