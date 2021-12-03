package me.unbekannterpromi.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;

public class Day1 extends Day {

    @Override
    public void run1(AoCFile file) {

        String input = file.readCompleteFile();

        String[] splitinput = input.split("\n");

        int[] intinput = new int[splitinput.length];
        int zaehler = 0;
        int zwischenspeicher = 0;

        for(int i = 0; i < splitinput.length; i++ ) {
            intinput[i] = Integer.parseInt(splitinput[i]);
        }

        for(int u = 0; u < intinput.length-1; u++) {
            zwischenspeicher = intinput[u];
            if (zwischenspeicher < intinput[u+1]) {
                zaehler++;
            }
        }

        System.out.println(zaehler);
    }

    @Override
    public void run2(AoCFile file) {
        String input = file.readCompleteFile();

        String[] splitinput = input.split("\n");

        int[] intinput = new int[splitinput.length];
        int zaehler = 0;

        for(int i = 0; i < splitinput.length; i++ ) {
            intinput[i] = Integer.parseInt(splitinput[i]);
        }

        for(int u = 0; u < intinput.length-3; u++) {
            if (intinput[u]+intinput[u+1]+intinput[u+2] < intinput[u+1]+intinput[u+2]+intinput[u+3]) {
                zaehler++;
            }
        }

        System.out.println(zaehler);
    }
}
