package me.aminov.demo.services.impl;

import me.aminov.demo.model.Ingredients;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public void deleteIngridients(int id) {
        ingredientsMap.remove(id);
    }

    @Override
    public void editIngridient(int id, Ingredients ingredients) {
        ingredientsMap.put(id, ingredients);
    }

}
