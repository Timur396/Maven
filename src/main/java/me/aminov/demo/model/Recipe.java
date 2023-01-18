package me.aminov.demo.model;

import java.util.List;

public class Recipe {
    String name;
    int timeCooking;
    List<Ingredients> ingredientsList;
    List<String> steps;

    public Recipe(String name, int timeCooking, List<Ingredients> ingredientsList, List<String> steps) {
       setName(name);
        setTimeCooking(timeCooking);
        this.ingredientsList = ingredientsList;
        this.steps = steps;
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

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
