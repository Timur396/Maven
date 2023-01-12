package me.aminov.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Recipe {

@GetMapping
    public String helloWorld() {
        return "Приложение запущено";
    }
    @GetMapping("/info")
    public String info() {
        return "Тимур."+'\n'+
                " Проект: Рецепты "+'\n'+
                "Дата создания :12.01.2023 "+'\n'+
                "Описание: Народные рецепты "
                ;
    }

}
