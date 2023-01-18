package me.aminov.demo.controllers;

import me.aminov.demo.model.Recipe;
import me.aminov.demo.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/add")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService=recipeService;
    }

    Recipe recipe = new Recipe("Пюре", 1, new ArrayList<>(), new ArrayList<>());

    @GetMapping("/recipe")
    public Recipe addRecipe() {
        recipeService.addRecipe(recipe);
        return recipeService.getRecipe(0);
    }
}
