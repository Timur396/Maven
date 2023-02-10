package me.aminov.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.aminov.demo.model.Ingredients;
import me.aminov.demo.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
@Tag(name = "Контроллер ингридиентов", description = "CRUD- операции для работы с ингридиентами")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Operation(
            summary = "Добавление ингредиента в список",
            description = "Требуется передать с помощью JSON объект ингредиента"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент добавлен"
            )
    })
    @PostMapping("/ingredient")
    public void add(@RequestBody Ingredients ingredients) {
        ingredientService.addIngredient(ingredients);
        ingredientService.getIngredient(0);
    }

    @GetMapping("/getIngr")
    public Ingredients getIngridient(@RequestParam int number) {
        return ingredientService.getIngredient(number);
    }

    @Operation(
            summary = "Показать ингридиент",
            description = "Требуется ввести id ингридиента"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200"
            )
    })
    @GetMapping("/getCounterId")
    public ResponseEntity<Ingredients> getIngredient(@PathVariable int counter) {
        Ingredients ingredients = ingredientService.getIngredient(counter);
        return ResponseEntity.ok(ingredients);
    }
    @Operation(
            summary = "Изменение ингредиента",
            description = "ВВедите id  ингридиента который нужно изменить"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент изменен"
            )
    })
    @PutMapping("/edit/{id}")
    public ResponseEntity<Ingredients> editIngredient(@PathVariable int id, @RequestBody Ingredients ingredients) {
        ingredientService.editIngridient(id, ingredients);
        return ResponseEntity.ok().build();
    }
    @Operation(
            summary = "Удаление ингридиента по id",
            description = "ВВедите id  ингридиента который нужно удалить"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент удален"
            )
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ingredients> deleteIngredient(@PathVariable int id) {
        ingredientService.deleteIngridients(id);
        return ResponseEntity.ok().build();
    }

}
