package nov30.methodref;

import java.util.List;

public class ListSorter {
    public static void main(String[] args) {
        List<String> names = List.of("alok","prateek","jagmeet","anmol");
        names.forEach(System.out::println);
    }
}
