package me.aminov.demo.services;

import java.io.File;

public interface FileService {

    boolean saveToFile(String json,String fileName);

    String readFromFiles(String fileName);

    boolean cleanRecipeFile(String fileName);
    File getFile(String fileName);
}
