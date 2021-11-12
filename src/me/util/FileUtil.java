package me.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public enum Permissions{
        READ,
        WRITE,
        READ_CREATE,
        WRITE_CREATE
    }
    public enum Whence{
        SEEK_SET,
        SEEK_CUR,
        SEEK_END
    }

    private String fileName;
    private Permissions permission;
    private BufferedReader reader;
    private BufferedWriter writer;

    public FileUtil(String fileName, Permissions permission) throws IOException { // new FileUtil("test", FileUtil.Permissions.READ);
        this.fileName = fileName;
        this.permission = permission;
        File file = new File(fileName);
        switch (permission){
            case READ:
                reader = new BufferedReader(new FileReader(file));
                break;
            case READ_CREATE:
                if (!file.exists()) file.createNewFile();
                reader = new BufferedReader(new FileReader(file));
                break;
            case WRITE:
                writer = new BufferedWriter(new FileWriter(file));
                break;
            case WRITE_CREATE:
                if (!file.exists()) file.createNewFile();
                writer = new BufferedWriter(new FileWriter(file));
                break;
        }
    }

    //GLOBAL
    public void close(){

    }

    public void setToEntry(){

    }

    public void seek(int part){

    }

    public void seek(){

    }

    public void tell(){

    }


    //WRITING STUFF
    public void write(String content){

    }

    public void write(char character){

    }

    public void clear(){

    }

    public void newLine(){

    }

    //READING STUFF
    public char read(){
        return '\0';
    }

    public String read(int size){
        return "";
    }

    public String readAll(){
        return "";
    }

    public String readLine(){
        return "\0";
    }

    public List<String> readLines(int amount){
        return new ArrayList<>();
    }



}
