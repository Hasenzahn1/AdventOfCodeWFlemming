package me.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class AoCFile extends RandomAccessFile {

    public AoCFile(String name, String mode) throws FileNotFoundException {
        super(name, mode);
    }

    public AoCFile(File file, String mode) throws FileNotFoundException {
        super(file, mode);
    }

    public ArrayList<String> readLines() {
        try {
            ArrayList<String> lines = new ArrayList<>();
            while (getFilePointer() < length()) {
                lines.add(readLine());
            }
            return lines;
        }catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public int read() {
        try {
            return super.read();
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int read(byte[] b, int off, int len) {
        try {
            return super.read(b, off, len);
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int read(byte[] b) {
        try {
            return super.read(b);
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int skipBytes(int n) {
        try {
            return super.skipBytes(n);
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void write(int b) {
        try {
            super.write(b);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void write(byte[] b) {
        try {
            super.write(b);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void write(byte[] b, int off, int len) {
        try {
            super.write(b, off, len);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public long getFilePointer() {
        try{
        return super.getFilePointer();
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void seek(long pos) {
        try{
            super.seek(pos);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public long length() {
        try{
        return super.length();
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void setLength(long newLength) {
        try{
            super.setLength(newLength);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try{
            super.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
