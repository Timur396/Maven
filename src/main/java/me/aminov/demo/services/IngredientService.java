package me.aminov.demo.services;

import me.aminov.demo.model.Ingredients;


public interface IngredientService {
    void addIngredient(Ingredients ingredients);

    Ingredients  getIngredient(int number);


}
