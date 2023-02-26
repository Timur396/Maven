package me.aminov.demo.services;

import me.aminov.demo.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe getRecipe(int number);

    void editRecipe(int id, Recipe newRecipe);

    void deleteRecipe(int counter);

    Collection<Recipe> getAllRecipe();

    Path createRecipeTxt() throws IOException;
}
