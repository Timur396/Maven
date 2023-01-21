package me.aminov.demo.controllers;

import me.aminov.demo.model.Ingredients;
import me.aminov.demo.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getIngr")
    public Ingredients getIngridient(@RequestParam int number) {
        return ingredientService.getIngredient(number);
    }

    @GetMapping("/getCounterId")
    public ResponseEntity<Ingredients> getIngredient(@PathVariable int counter) {
        Ingredients ingredients = ingredientService.getIngredient(counter);
        return ResponseEntity.ok(ingredients);
    }
}
