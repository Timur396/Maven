package me.aminov.demo.controllers;

import me.aminov.demo.model.Ingredients;
import me.aminov.demo.services.IngredientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/ingredient")
    public void add(@RequestBody Ingredients ingredients) {
        ingredientService.addIngredient(ingredients);
        ingredientService.getIngredient(0);
    }

}
