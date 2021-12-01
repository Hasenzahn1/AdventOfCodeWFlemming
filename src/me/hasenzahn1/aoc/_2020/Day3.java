package me.hasenzahn1.aoc._2020;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;

public class Day3 extends Day {
    
    @Override
    public void run1(AoCFile file) {
        int x = 0;
        int counter = 0;
        ArrayList<String> lines = file.readLines();
        for (int i = 0; i < lines.size(); i++){
            for (int z = 0; z < 5; z++){
                lines.set(i, lines.get(i) + lines.get(i));
            }
        }
        for (String line : lines) {
            if (line.charAt(x) == '#') {
                counter++;
            }
            x += 3;
        }
        System.out.println(counter);

    }

    @Override
    public void run2(AoCFile file) {
        int[] xs = {1, 3, 5, 7, 1};
        int[] ys = {1, 1, 1, 1, 2};
        ArrayList<String> lines = file.readLines();
        for (int i = 0; i < lines.size(); i++){
            for (int z = 0; z < 10; z++){
                lines.set(i, lines.get(i) + lines.get(i));
            }
        }
        double result = 1;
        for(int i = 0; i < xs.length; i++){
            int x = 0;
            int counter = 0;
            for (int y = 0; y < lines.size(); y += ys[i]){
                if (lines.get(y).charAt(x) == '#') {
                    counter++;
                }
                x += xs[i];
            }
            result *= counter;
        }
        System.out.printf("%.0f", result);
    }
}
