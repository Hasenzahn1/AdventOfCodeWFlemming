package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;

public class Day1 extends Day {

    @Override
    public void run1(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        int[] intlines = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++){
            intlines[i] = Integer.parseInt(lines.get(i));
        }

        int count = 0;

        for (int i = 1; i < intlines.length; i++){
            if (intlines[i-1] < intlines[i]) count++;
        }

        System.out.println(count);

    }

    @Override
    public void run2(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        int[] intlines = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++){
            intlines[i] = Integer.parseInt(lines.get(i));
        }

        int[] values = new int[lines.size() - 2];
        for (int i = 0; i < lines.size() - 2; i++){
            values[i] = intlines[i] + intlines[i + 1] + intlines[i + 2];
        }

        int count = 0;

        for (int i = 1; i < values.length; i++){
            if (values[i-1] < values[i]) count++;
        }

        System.out.println(count);
    }
}
