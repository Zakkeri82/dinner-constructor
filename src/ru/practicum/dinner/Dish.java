package ru.practicum.dinner;

public class Dish {

    private final String dishName;

    public Dish(String dishName) {
        this.dishName = dishName;
    }

    public String getDishName() {
        return dishName;
    }
}