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
@Tag(name = "Контроллер ингридиентов",description = "CRUD- операции для работы с ингридиентами")
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

    @GetMapping("/getCounterId")
    public ResponseEntity<Ingredients> getIngredient(@PathVariable int counter) {
        Ingredients ingredients = ingredientService.getIngredient(counter);
        return ResponseEntity.ok(ingredients);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Ingredients> editIngredient(@PathVariable int id, @RequestBody Ingredients ingredients) {
        ingredientService.editIngridient(id, ingredients);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ingredients> deleteIngredient(@PathVariable int id) {
        ingredientService.deleteIngridients(id);
        return ResponseEntity.ok().build();
    }

}
