package me.aminov.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {
    @NotBlank
    private String name;
    @PositiveOrZero
    private int numberOfIngredients;
    @NotBlank
    private String measure;
    private  Integer id;
private static int counter=0;

    public Ingredients(String name, int numberOfIngredients, String measure) {
        setName(name);
        setNumberOfIngredients(numberOfIngredients);
        setMeasure(measure);
        id=counter++;
    }


}

