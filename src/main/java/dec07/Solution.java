package dec07;

import nov30.streams.Dish;
import nov30.streams.DishType;
import nov30.streams.StreamDemo;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Set<Employee> emp=new HashSet<>();

        emp.add(new Employee(101,"amit",24,4500.50));
        emp.add(new Employee(102,"rahul",25,5500.50));
        emp.add(new Employee(103,"alok",26,6500.50));
        emp.add(new Employee(104,"amy",21,7500.50));

        LinkedList<Employee> collect = emp.stream().collect(Collectors.toCollection(LinkedList::new));

        List<String> vips = Arrays.asList("John", "Jean","Adam","Michael");
        List<String> friends = Arrays.asList("Jagmeet", "Robin","Praeek","Gagan");
        List<String> ignoredOnes = Arrays.asList("Sunny", "Shuham","Atin");
        List<String> family = Arrays.asList("Alok", "Krishna","Satvir");

        Stream<List<String>> listStream = Stream.of(vips, friends, ignoredOnes, family);

        Stream<Stream<String>> streamStream = Stream.of(vips, friends, ignoredOnes, family)
                .map(list -> list.stream());

        Stream<String> stringStream = Stream.of(vips, friends, ignoredOnes, family).flatMap
                (list -> list.stream());


        List<Dish> dishes= StreamDemo.createDishes();

//        List<Dish> vegs = dishes.stream()
//                .filter(d -> d.getDishType() == DishType.VEG)
//                .collect(Collectors.toList());
//
//
//        List<Dish> nov_vegs = dishes.stream()
//                .filter(d -> d.getDishType() == DishType.NOV_VEG)
//                .collect(Collectors.toList());
//
//        Map<DishType, List<Dish>> disgroup = new HashMap<>();
//        disgroup.put(DishType.VEG, vegs);
//        disgroup.put(DishType.NOV_VEG, nov_vegs);
//
//        System.out.println(disgroup);

        Map<DishType, List<Dish>> disgroup = dishes.stream().distinct()
                .collect(Collectors.groupingBy(Dish::getDishType));
        System.out.println(disgroup);

        Map<DishType, List<String>> namedDishes = dishes.stream().distinct()
                .collect(Collectors.groupingBy(Dish::getDishType, Collectors.mapping(
                        Dish::getName,
                        Collectors.toList()
                )));

        System.out.println("namedDishes = " + namedDishes);
        
        List<String> shoppingList  = new ArrayList<>();
        for (Dish dish : dishes) {
           for (String ing: dish.getIngredients()) {
               shoppingList.add(ing);
           }
        };

        List<String> collect1 = dishes
                .parallelStream()
                .flatMap(dish -> dish.getIngredients().stream())
                .distinct().collect(Collectors.toList());

        //System.out.println(collect1);
        DoubleSummaryStatistics summaryStatistics = dishes.stream().map(Dish::getPrice)
                .collect(Collectors.summarizingDouble(d -> d));

        System.out.println("summaryStatistics = " + summaryStatistics);

        Map<String, Double> namePriceMap = dishes.stream().distinct()
                .collect(Collectors.toMap(Dish::getName, Dish::getPrice,
                        (a, b) -> a
        ));
        System.out.println("namePriceMap = " + namePriceMap);



    
    }

    private static Employee raiseSalary(Employee e) {
         e.setSalary(e.getSalary()+1000);
         return e;
    }
}
