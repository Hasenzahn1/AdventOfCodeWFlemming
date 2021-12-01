package me.unbekannterpromi.aoc._2020;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;

public class Day1 extends Day {
    public Day1() {
        super();
    }

    @Override
    public void run1(AoCFile file) {

        ArrayList<String> lines = file.readLines();

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
    public void run2(AoCFile file) {
        ArrayList<String> lines = file.readLines();

        int[] Liste = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            Liste[i] = Integer.parseInt(lines.get(i));
        }

        for (int i = 0; i < Liste.length; i++) {
            for(int z = i+1; z < Liste.length; z++) {
                for(int x = z+1; x < Liste.length; x++) {
                    if (Liste[i] + Liste[z] + Liste[x] == 2020) {
                        System.out.println(Liste[i] * Liste[z] * Liste[x]);
                    }
                }
            }
        }
    }
}
