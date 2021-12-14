package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.hasenzahn1.aoc.util.Display;
import me.util.AoCFile;

import java.util.ArrayList;
import java.util.Arrays;

public class Day8 extends Day {

    @Override
    public void run1(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        ArrayList<Integer> lengths = new ArrayList<>(Arrays.asList(2, 4, 3, 7));
        int count = 0;
        for(String line : lines) {
            String use = line.split(" ; ")[1].strip();
            String[] numbers = use.split(" ");
            for(String s : numbers){
                if(lengths.contains(s.length())) count++;
            }
        }
        System.out.println(count);
    }

    @Override
    public void run2(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        int count = 0;
        for(String line : lines){
            String input = line.split(" ; ")[0].strip();
            String output = line.split(" ; ")[1].strip();
            String[] inputNumbers = input.split(" ");
            String[] outputNumbers = output.split(" ");
            Display display = new Display(inputNumbers, outputNumbers);
            display.dechiffre();
            count += display.parseOutput();
        }
        System.out.println(count);
    }
}
