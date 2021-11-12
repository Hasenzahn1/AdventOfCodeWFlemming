package me.unbekannterpromi.aoc;

import me.aoc.Day;

import java.util.ArrayList;

public class Day1 extends Day {
    public Day1(String fileName1, String fileName2) {
        super(fileName1, fileName2);
    }

    @Override
    public void run1() {

        ArrayList<String> lines = file1.readLines();

        int[] Liste = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            Liste[i] = Integer.parseInt(lines.get(i));
        }
        for (int i = 0; i < Liste.length; i++) {
            for(int z = i+1; z < Liste.length; z++) {
                if (Liste[i] + Liste[z] == 2020) {
                    System.out.println(Liste[i] * Liste[z]);
                }
            }
        }
    }

    @Override
    public void run2() {

    }
}
