package me.aminov.demo.services;

public interface FileService {

    boolean saveToFile(String json,String fileName);

    String readFromFiles();
}
