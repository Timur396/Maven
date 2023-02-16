package me.aminov.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.aminov.demo.services.FileService;
import me.aminov.demo.services.impl.FilesServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
public class FilesController {

    private final FileService fileService;

    public FilesController(FileService fileService) {
        this.fileService = fileService;
    }
    @Operation(
            summary = "Скачать рецепт "
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт скачан"
            )
    })
    @GetMapping(value = "/export/recipe",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InputStreamResource> downloadRecipeFile() throws FileNotFoundException {
        File recipeFile = fileService.getDataFile(fileService.getRecipeFileName());
        if (recipeFile.exists()) {
            InputStreamResource resource = new InputStreamResource((new FileInputStream(recipeFile)));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(recipeFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"Recipe.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @Operation(
            summary = "Скачать ингридиент "
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингридиент скачан"
            )
    })
    @GetMapping("/export/ingridient")
    public ResponseEntity<InputStreamResource> downloadIngridientFile() throws FileNotFoundException {
        File ingridientFile = fileService.getDataFile(fileService.getIngredientFileName());
        if (ingridientFile.exists()) {
            InputStreamResource resource = new InputStreamResource((new FileInputStream(ingridientFile)));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(ingridientFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"Ingridient.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @Operation(
            summary = "Загрузить рецепт "
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт загружен"
            )
    })
    @PostMapping(value = "/import/recipe",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadDataRecipeFile(@RequestParam MultipartFile file) {
        fileService.cleanDataFile(fileService.getRecipeFileName());
        File dataRecipeFile = fileService.getDataFile(fileService.getRecipeFileName());
        try (FileOutputStream fos = new FileOutputStream(dataRecipeFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
           e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @Operation(
            summary = "Загрузить ингридиент "
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "ингридиент загружен"
            )
    })
    @PostMapping(value = "/import/ingredient",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadDataIngredientFile(@RequestParam MultipartFile file) {
        fileService.cleanDataFile(fileService.getIngredientFileName());
        File dataIngredientFile = fileService.getDataFile(fileService.getIngredientFileName());
        try (FileOutputStream fos = new FileOutputStream(dataIngredientFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

