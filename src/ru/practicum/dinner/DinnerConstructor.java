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

    /**
     * Добавляет блюдо в меню по его типу
     *
     * @param dishType тип блюда
     * @param dishName название блюда
     */
    public void addDish(String dishType, String dishName) {
        if (!checkType(dishType)) { //используем 11 jdk (на 17 сказали много правок в курсе нужно делать)
            List<Dish> dishList = new ArrayList<>();
            menu.put(dishType, dishList);
            menu.get(dishType).add(new Dish(dishName));
        } else {
            menu.get(dishType).add(new Dish(dishName));
        }
    }

    /**
     * генерация определенного колличества вариантов комбо из заданных типов блюд (используется Random),
     * а также выводит сгенерированные комбо в консоль
     *
     * @param count колличество вариантов комбо
     * @param listType список типов блюд из которых нужно сгенерировать комбо
     */
    public void generateAndPrintResult(int count, List<String> listType) {
        List<ArrayList<String>> resultGenerateCombo = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String s : listType) {
                List<Dish> dishes = menu.get(s);
                combo.add(dishes.get(random.nextInt(dishes.size())).getDishName());
            }
            resultGenerateCombo.add(combo);
        }
        for (int i = 0; i < resultGenerateCombo.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(resultGenerateCombo.get(i));
        }
    }

    /**
     * Проверяет присутствие типа блюд в меню
     *
     * @param type тип блюда
     * @return возвращает boolean значение присутствия блюда
     */
    boolean checkType(String type) {
        return menu.containsKey(type);
    }
}