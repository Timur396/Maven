package me.aminov.demo.services.impl;

import me.aminov.demo.services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FileService {

    @Value("${path.to.data.file}")
    private String dataFilePath;
    @Value(value = "${name.of.ingredient.file}")
    private String ingredientFileName;
    @Value("${name.of.recipe.file}")
    public String recipeFileName;
@Override
    public String getDataFilePath() {
        return dataFilePath;
    }
    @Override
    public String getIngredientFileName() {
        return ingredientFileName;
    }
    @Override
    public String getRecipeFileName() {
        return recipeFileName;
    }

    @Override
    public boolean saveToFile(String json, String fileName) {
        try {
            cleanDataFile(fileName);
            Files.writeString(Path.of(dataFilePath, fileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String readFromFiles(String fileName) {
        try {
            return Files.readString(Path.of(dataFilePath, fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public boolean cleanDataFile(String fileName) {
        Path path = Path.of(dataFilePath, fileName);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public File getDataFile(String fileName) {
        return new File(dataFilePath + "/" + fileName);
    }

    @Override
    public Path createTempFile(String suffix) {
        try {
            return Files.createTempFile(Path.of(dataFilePath), "tempFile", suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



