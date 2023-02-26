package me.aminov.demo.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;
import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Recipe {


    private String name;
@Positive
    private int timeCooking;
    private  List<Ingredients> ingredientsList;
    private  List<String> steps;

}

