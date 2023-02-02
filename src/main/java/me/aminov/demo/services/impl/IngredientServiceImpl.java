package me.aminov.demo.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.aminov.demo.model.Ingredients;
import me.aminov.demo.services.FileService;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;


@Service
public class IngredientServiceImpl implements me.aminov.demo.services.IngredientService {
    private String ingredientFileName;
    final private FileService fileService;
    Map<Integer, Ingredients>ingredientsMap=new HashMap<>();
    static int counter=0;

    public IngredientServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void addIngredient(Ingredients ingredients) {
        ingredientsMap.put(counter++, ingredients);
    }

    @Override
    public Ingredients getIngredient(int number) {
        return null;
    }

    @Override
    public void deleteIngridients(int id) {
        ingredientsMap.remove(id);
    }

    @Override
    public void editIngridient(int id, Ingredients ingredients) {
        ingredientsMap.put(id, ingredients);
    }




    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientsMap);
            fileService.saveToFile(json, ingredientFileName);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    private void readFromFile() {
        String json = fileService.readFromFiles();
        try {
            ingredientsMap =  new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer,Ingredients>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
