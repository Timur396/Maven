package me.aminov.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;


@Data
public class Recipe {
    private Integer id;
    private static int counter = 0;
   @NotBlank
    private String name;
    @PositiveOrZero
    private int timeCooking;
    private final List<Ingredients> ingredientsList;
    private final List<String> steps;

    public Recipe(String name,
                  int timeCooking,
                  List<Ingredients> ingredientsList,
                  List<String> steps) {
        setName(name);
        setTimeCooking(timeCooking);
        this.ingredientsList = ingredientsList;
        this.steps = steps;
        id = counter++;
    }
}

