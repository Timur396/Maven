package me.aminov.demo.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.aminov.demo.model.Recipe;
import me.aminov.demo.services.FileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeServiceImpl implements me.aminov.demo.services.RecipeService {
    Map<Integer, Recipe> recipeMap = new HashMap<>();
    final private FileService fileService;
    int counter = 0;
    public RecipeServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeMap.put(counter++, recipe);

    }

    @Override
    public void editRecipe(Integer id, Recipe newRecipe) {
        recipeMap.put(id, newRecipe);
    }

    @Override
    public Recipe getRecipe(int number) {
        recipeMap.get(number);

        return null;
    }

    @Override
    public void editRecipe(int id, Recipe newRecipe) {

    }

    @Override
    public void deleteRecipe(int counter) {
        recipeMap.remove(counter);
    }

    @Override
    public List<Recipe> getAllRecipe() {
        ArrayList<Recipe> temp = new ArrayList<>();
        for (Map.Entry<Integer, Recipe> all : recipeMap.entrySet()) {
            temp.add(all.getValue());
        }return temp;
    }
    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            fileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    private void readFromFile() {
        String json = fileService.readFromFiles();
        try {
            recipeMap =  new ObjectMapper().readValue(json, new TypeReference<Map<Integer,Recipe >>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}