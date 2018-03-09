package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.concurrent.atomic.AtomicInteger;

public interface MealRepository {

    AtomicInteger id = new AtomicInteger(6);

    void createMeal(String description, int calories, String date);

    Meal get(int id);

    void edit(int id, String description, int calories, String date);

    void delete(int id);
}
