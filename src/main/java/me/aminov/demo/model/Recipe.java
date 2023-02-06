package me.aminov.demo.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;
import java.util.List;

@Data
@EqualsAndHashCode
public class Recipe {


    private String name;

    private int timeCooking;
    private final List<Ingredients> ingredientsList;
    private final List<String> steps;

}

