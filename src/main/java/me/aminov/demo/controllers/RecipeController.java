package me.aminov.demo.controllers;

import me.aminov.demo.model.Ingredients;
import me.aminov.demo.model.Recipe;
import me.aminov.demo.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/add")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    Recipe recipe = new Recipe("Пюре", 1, new ArrayList<>(), new ArrayList<>());

    @PostMapping("/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return recipeService.getRecipe(0);
    }

    @GetMapping("/recipeId")
    public ResponseEntity<Recipe> getRecipeId(@PathVariable int id) {
        Recipe result = recipeService.getRecipe(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

}
