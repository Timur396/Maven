package me.aminov.demo.services;

import me.aminov.demo.model.Recipe;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe getRecipe(int number);
}
