package me.aminov.demo.model;
import lombok.ToString;

import java.util.List;


@ToString
public class Recipe {
    private Integer id;
    private static int counter = 0;
    private String name;
    private int timeCooking;
    private final List<Ingredients> ingredientsList;
    private final List<String> steps;

    public Recipe(String name,
                  int timeCooking,
                  List<Ingredients> ingredientsList,
                  List<String> steps) {
        setName(name);
        setTimeCooking(timeCooking);
        this.ingredientsList = ingredientsList;
        this.steps = steps;
        id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else this.name = "Название рецепта не введено";
    }

    public int getTimeCooking() {
        return timeCooking;
    }

    public void setTimeCooking(int timeCooking) {
        if (timeCooking >= 0) {
            this.timeCooking = timeCooking;
        } else this.timeCooking = 0;

    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public List<String> getSteps() {
        return steps;
    }
}

