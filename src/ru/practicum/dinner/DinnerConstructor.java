package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, List<Dish>> menu;
    Random random;

    public DinnerConstructor() {
        menu = new HashMap<>();
        random = new Random();
    }

    public void addDish(String dishType, String dishName) {
        if (checkType(dishType)) {
            List<Dish> dishList = menu.get(dishType);
            dishList.add(new Dish(dishName));
        } else {
            List<Dish> dishList = new ArrayList<>();
            dishList.add(new Dish(dishName));
            menu.put(dishType, dishList);
        }
    }

    public void generateAndPrintResult (int count, List<String> listType) {
        List<ArrayList<String>> resultSet = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ArrayList<String> kit = new ArrayList<>();
            for (String s : listType) {
                List<Dish> dishes = menu.get(s);
                kit.add(dishes.get(random.nextInt(dishes.size())).getDishName());
            }
            resultSet.add(kit);
        }
        for(int i = 0; i < resultSet.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(resultSet.get(i));
        }
    }

    boolean checkType(String type) {
        return menu.containsKey(type);
    }
}