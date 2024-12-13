package nov30.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class StreamDemo {
    public static void main(String[] args) {
        List<Dish> dishes = createDishes();

        List<String> cheapDishes = dishes.stream().filter(d -> d.getPrice() < 10)
                .map(Dish::getName).distinct().collect(Collectors.toList());
        System.out.println(cheapDishes);

        List<Dish> paneers = dishes.stream().filter(d -> d.getName().toUpperCase().contains("PANEER"))
                .filter(d -> d.getDishType() == DishType.VEG)
                .collect(Collectors.toList());


        System.out.println(paneers);

        List<String> vegs = dishes.stream().map(Dish::getName).map(String::toUpperCase)
                .filter(s -> !s.contains("CHICKEN")).collect(Collectors.toList());
        System.out.println(vegs);

        List<Double> prices = dishes.stream().distinct().map(Dish::getPrice).collect(Collectors.toList());

        System.out.println(dishes.stream().map(Dish::getPrice).mapToDouble(Double::valueOf).sum());
        Double reduce = dishes.stream().map(Dish::getPrice).reduce(0.0, (a, b) -> a + b);
        System.out.println("reduce = " + reduce);
        

        double sum = 0;
        for (Double price : prices) {
            sum += price;
        }


    }


    public static List<Dish> createDishes() {
        List<Dish> dishes = new ArrayList<>();

        dishes.add(Dish.builder().name("Hamburger")
                        .price(12.5).calories(800)
                        .dishType(DishType.NOV_VEG)
                        .ingredients(List.of("Ham", "Cheese", "Tomoto", "Bun")).build());
        dishes.add(Dish.builder().name("Samosa")
                        .price(0.75).calories(300)
                        .dishType(DishType.VEG)
                        .ingredients(List.of("Potato", "Peas", "Salt", "Chilli")).build());
        dishes.add(Dish.builder().name("Sandwitch")
                        .price(6.5).calories(400)
                        .dishType(DishType.VEG)
                        .ingredients(List.of("Bread", "Cheese", "Salt", "Chilli", "Ketchup")).build());
        dishes.add(Dish.builder().name("Butter Chicken")
                        .price(6.5).calories(400)
                        .dishType(DishType.NOV_VEG)
                        .ingredients(List.of("Chicken", "Butter", "Salt", "Chilli", "Tomoto")).build());
        dishes.add(Dish.builder().name("Butter Chicken")
                .price(6.5).calories(400)
                .dishType(DishType.NOV_VEG)
                .ingredients(List.of("Chicken", "Butter", "Salt", "Chilli", "Tomoto")).build());
        dishes.add(Dish.builder().name("Butter Chicken")
                .price(6.5).calories(400)
                .dishType(DishType.VEG)
                .ingredients(List.of("Chicken", "Butter", "Salt", "Chilli", "Tomoto")).build());
        dishes.add(Dish.builder().name("Paneer Samosa")
                .price(6.5).calories(400)
                .dishType(DishType.VEG)
                .ingredients(List.of("paneer", "Peas", "Salt", "Chilli")).build());
        dishes.add(Dish.builder().name("Paneer Chicken")
                .price(6.5).calories(400)
                .dishType(DishType.VEG)
                .ingredients(List.of("paneer", "Peas", "Salt", "Chilli")).build());

        dishes.add(Dish.builder().name("Chicken Nugget")
                .price(10.25).calories(800)
                .dishType(DishType.NOV_VEG)
                .ingredients(List.of("Chicken", "Bread Crump", "Salt", "Chilli")).build());

        dishes.add(Dish.builder().name("Pizza")
                .price(18.5).calories(1400)
                .dishType(DishType.VEG)
                .ingredients(List.of("paneer", "cheeze", "Salt", "Chilli")).build());

        dishes.add(Dish.builder().name("Spaghetti")
                .price(20.5).calories(700)
                .dishType(DishType.NOV_VEG)
                .ingredients(List.of("chiken", "Peas", "Salt", "Chilli")).build());

        return dishes;

    }
}
