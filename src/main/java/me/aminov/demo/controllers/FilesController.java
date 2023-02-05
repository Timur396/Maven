package me.aminov.demo.controllers;

import me.aminov.demo.services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/files")
public class FilesController {
    @Value("${name.of.recipe.file}")
    private String recipeFileName;

    @Value("${name.of.ingredient.file}")
    private String ingredientFileName;
    private final FileService fileService;


    public FilesController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> downloadRecipeFile() throws FileNotFoundException {
        File recipeFile= fileService.getFile(recipeFileName);
        if (recipeFile.exists()) {
InputStreamResource resource=new InputStreamResource((new FileInputStream(recipeFile)));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(recipeFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\"Recipe.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/export/ingridient")
    public ResponseEntity<InputStreamResource> downloadIngridientFile() throws FileNotFoundException {
        File ingridientFile= fileService.getFile(ingredientFileName);
        if (ingridientFile.exists()) {
InputStreamResource resource=new InputStreamResource((new FileInputStream(ingridientFile)));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(ingridientFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\"Ingridient.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}

