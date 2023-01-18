package me.aminov.demo.services.impl;

import me.aminov.demo.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RecipeService implements me.aminov.demo.services.RecipeService {
    Map<Integer, Recipe> recipeMap = new HashMap<>();

    int counter=0;
    @Override
    public void addRecipe(Recipe recipe) {
        recipeMap.put(counter++, recipe);

    }

    @Override
    public Recipe getRecipe(int number) {
        recipeMap.get(number);

        return null;
    }
}
