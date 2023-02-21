package me.aminov.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.aminov.demo.model.Recipe;
import me.aminov.demo.services.RecipeService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;



@RestController
@RequestMapping("/Recipe")
@Tag(name = "Констроллер рецептов", description = "CRUD-опреции для работы с рецептами")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

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
    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.ok(recipe);
    }

    @Operation(
            summary = "Показать рецепт"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeId(@PathVariable int id) {
        Recipe result = recipeService.getRecipe(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
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

    @GetMapping("/All")
    @Operation(summary = "Поиск всех рецептов",
            description = "выводит сразу все рецепты")
    public Collection<Recipe> getAllRecipes() {
        return recipeService.getAllRecipe();
    }

    @GetMapping("/gettxtfile")
    public ResponseEntity<Object> getTxtFile() {
        try {
            Path path =  recipeService.createRecipeTxt();
            if (Files.size(path) == 0) {
                return ResponseEntity.noContent().build();
            }
            InputStreamResource resource = new InputStreamResource(new FileInputStream(path.toFile()));
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .contentLength(Files.size(path))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"recipeBook.txt\"")
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.toString());
        }

    }
}
