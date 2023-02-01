package me.aminov.demo.services;

import me.aminov.demo.model.Recipe;

import java.util.List;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    void editRecipe(Integer id, Recipe newRecipe);

    Recipe getRecipe(int number);

    void editRecipe(int id, Recipe newRecipe);

    void deleteRecipe(int counter);

    List<Recipe> getAllRecipe();
}
