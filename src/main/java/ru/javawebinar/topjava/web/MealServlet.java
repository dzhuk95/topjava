package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepositoryImpl;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private MealRepositoryImpl mealRepositoryImpl = MealRepositoryImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            req.setAttribute("mealList", MealsUtil.createWithExceed(mealRepositoryImpl.getMeals(), 2000));
            req.getRequestDispatcher("/meal.jsp").forward(req, resp);
        } else {
            if (action.equals("delete")) {
                String id = req.getParameter("id");
                mealRepositoryImpl.delete(Integer.valueOf(id));
                resp.sendRedirect("/meal");
            }
            if (action.equals("edit")) {
                String id = req.getParameter("id");
                Meal meal = mealRepositoryImpl.get(Integer.parseInt(id));
                req.setAttribute("meal", meal);
                req.getRequestDispatcher("/editMeal.jsp").forward(req, resp);
            }
            if (action.equals("create"))
                req.getRequestDispatcher("/createMeal.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("create")) {
            String description = req.getParameter("description");
            String calories = req.getParameter("calories");
            String date = req.getParameter("date");
            mealRepositoryImpl.createMeal(description, Integer.parseInt(calories), date);
            resp.sendRedirect("/meal");
        }else{
            String description = req.getParameter("description");
            String calories = req.getParameter("calories");
            String date = req.getParameter("date");
            String id = req.getParameter("id");
            mealRepositoryImpl.edit(Integer.valueOf(id), description, Integer.valueOf(calories), date);
            resp.sendRedirect("/meal");
        }
    }
}
