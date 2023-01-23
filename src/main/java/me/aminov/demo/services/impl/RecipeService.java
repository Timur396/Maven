package me.aminov.demo.services.impl;

import me.aminov.demo.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService implements me.aminov.demo.services.RecipeService {
    Map<Integer, Recipe> recipeMap = new HashMap<>();

    int counter = 0;

    @Override
    public void addRecipe(Recipe recipe) {
        recipeMap.put(counter++, recipe);

    }

    @Override
    public void editRecipe(int id, Recipe newRecipe) {
        recipeMap.put(id, newRecipe);
    }

    @Override
    public Recipe getRecipe(int number) {
        recipeMap.get(number);

        return null;
    }

    @Override
    public void deleteRecipe(int counter) {
        recipeMap.remove(counter);
    }

    @Override
    public List<Recipe> getAllRecipe() {
        ArrayList<Recipe> temp = new ArrayList<>();
        for (Map.Entry<Integer, Recipe> all : recipeMap.entrySet()) {
            temp.add(all.getValue());
        }return temp;
    }
}
