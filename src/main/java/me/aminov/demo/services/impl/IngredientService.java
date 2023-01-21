package me.aminov.demo.services.impl;

import me.aminov.demo.model.Ingredients;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService implements me.aminov.demo.services.IngredientService {
    Map<Integer, Ingredients>ingredientsMap=new HashMap<>();
    static int counter=0;

    @Override
    public void addIngredient(Ingredients ingredients) {
        ingredientsMap.put(counter++, ingredients);
    }

    @Override
    public Ingredients getIngredient(int number) {
        return null;
    }
}
