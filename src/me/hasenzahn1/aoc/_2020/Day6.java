package me.hasenzahn1.aoc._2020;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;

public class Day6 extends Day {


    @Override
    public void run1(AoCFile file) {
        String input = file.readCompleteFile();
        String[] parts = input.split("\n\n");
        int amount = 0;
        for(String part : parts){
            ArrayList<Character> chars = new ArrayList<>();
            for(char c : part.strip().toCharArray()){
                if (!chars.contains(c) && c != '\n'){
                    chars.add(c);
                }
            }
            System.out.println(chars);
            amount += chars.size();
        }
        System.out.println(amount);
    }

    @Override
    public void run2(AoCFile file) {

    }
}
