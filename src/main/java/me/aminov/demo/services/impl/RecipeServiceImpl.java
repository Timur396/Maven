package me.aminov.demo.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.aminov.demo.model.Recipe;
import me.aminov.demo.services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class RecipeServiceImpl implements me.aminov.demo.services.RecipeService {
    Map<Integer, Recipe> recipeMap = new HashMap<>();
    final private FileService fileService;
    int counter = 0;

    public RecipeServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Value("${name.of.recipe.file}")
    private String recipeFileName;

    @Override
    public void addRecipe(Recipe recipe) {
        recipeMap.put(counter++, recipe);
        saveToRecipeFile();
    }
    @Override
    public Recipe getRecipe(int counter) {
        return recipeMap.get(counter);
    }
    @Override
    public void editRecipe(int id, Recipe newRecipe) {
        recipeMap.put(id, newRecipe);
        saveToRecipeFile();
    }
    @Override
    public void deleteRecipe(int counter) {
        recipeMap.remove(counter);
    }

    @Override
    public Collection<Recipe> getAllRecipe() {
        return Collections.unmodifiableCollection(recipeMap.values());
    }

    private void saveToRecipeFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            fileService.saveToFile(json,recipeFileName);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка при сохранинии файла");
        }

    }
    private void readFromFile() {
        String json = fileService.readFromFiles(recipeFileName);
        try {
            recipeMap =  new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer,Recipe >>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @PostConstruct
    private void init() {
        readFromFile();
    }
}
