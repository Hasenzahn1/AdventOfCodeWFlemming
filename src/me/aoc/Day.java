package me.aoc;

import me.util.AoCFile;
import me.util.FileLoader;


public abstract class Day {

    private String fileName1, fileName2;
    protected AoCFile file1, file2;

    public Day(String fileName1, String fileName2){
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        file1 = FileLoader.loadFileRead(fileName1);
        file2 = FileLoader.loadFileRead(fileName2);
    }

    public abstract void run1();
    public abstract void run2();

}
