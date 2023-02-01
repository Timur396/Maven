package me.aminov.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.aminov.demo.model.Ingredients;
import me.aminov.demo.model.Recipe;
import me.aminov.demo.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Recipe")
@Tag(name = "Констроллер рецептов", description = "CRUD-опреции для работы с рецептами")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    Recipe recipe = new Recipe("Пюре", 1, new ArrayList<>(), new ArrayList<>());
    @Operation(
            summary = "Добавление рецепта",
            description = "Необходимо передать с помощью JSON объект рецепта"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт добавлен"
            )
    })
    @PostMapping("/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return recipeService.getRecipe(0);
    }
    @Operation(
            summary = "Показать рецепт"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200"
            )
    })
    @GetMapping("/recipeId")
    public ResponseEntity<Recipe> getRecipeId(@PathVariable int id) {
        Recipe result = recipeService.getRecipe(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }
    @Operation(
            summary = "Изменить рецепт ",
            description = "Введите id рецепта, который нужно изменить"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт изменен"
            )
    })
    @PutMapping("/edit/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        recipeService.editRecipe(id, recipe);
        return ResponseEntity.ok().body(recipe);
    }
    @Operation(
            summary = "Удалить рецепт ",
            description = "Введите id рецепта, который нужно удалить"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт удален"
            )
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().build();
    }
}
