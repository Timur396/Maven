package me.aminov.demo.services;

import me.aminov.demo.model.Ingredients;


public interface IngredientService {
    void addIngredient(Ingredients ingredients);

    void getIngredient(int number);
}
