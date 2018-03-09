package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class MealRepositoryImpl implements MealRepository {
    private static MealRepositoryImpl ourInstance = new MealRepositoryImpl();
    private static List<Meal> meals;

    public static MealRepositoryImpl getInstance() {
        return ourInstance;
    }

    private MealRepositoryImpl() {
        meals = new CopyOnWriteArrayList<>();
        meals.addAll(Arrays.asList(new Meal(1, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 400),
                new Meal(2, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(3, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(4, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(5, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(6, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)));
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void createMeal(String description, int calories, String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date);
        Meal meal = new Meal(id.incrementAndGet(), localDateTime, description, calories);
        meals.add(meal);
    }

    public Meal get(int id) {
        return meals.get(id - 1);
    }

    public synchronized void edit(int id, String description, int calories, String date) {
        Optional<Meal> finedMeal = meals.stream().filter(item -> item.getId() == id).findFirst();
        if (!finedMeal.isPresent())
            throw new IllegalArgumentException("No such id");
        Meal meal = finedMeal.get();
        if (description != null)
            meal.setDescription(description);
        if (calories != 0)
            meal.setCalories(calories);
        if (date != null) {
            LocalDateTime localDateTime = LocalDateTime.parse(date);
            meal.setDateTime(localDateTime);
        }
        meals.add(meal.getId() - 1, meal);
        meals.remove(meal.getId());
    }

    public synchronized void delete(int id) {
        meals.removeIf(item -> item.getId() == id);
    }
}
