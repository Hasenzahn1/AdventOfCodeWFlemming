package me.util;

import java.io.FileNotFoundException;

public class FileLoader {

    public static AoCFile loadFileRead(String path) {
        try {
            return new AoCFile(path, "r");
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
            return null;
        }
    }

    public static AoCFile loadFileReadWrite(String path) {
        try {
            return new AoCFile(path, "rw");
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
            return null;
        }
    }

}
