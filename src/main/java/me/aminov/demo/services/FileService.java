package me.aminov.demo.services;

import java.io.File;
import java.nio.file.Path;

public interface FileService {

    boolean saveToFile(String json,String fileName);

    String readFromFiles(String fileName);

    boolean cleanRecipeFile(String fileName);
    File getDataFile(String fileName);

    Path createTempFile(String suffix);
}
