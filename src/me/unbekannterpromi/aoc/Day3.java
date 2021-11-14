package me.unbekannterpromi.aoc;
import me.aoc.Day;
import me.util.AoCFile;


import java.util.ArrayList;

public class Day3 extends Day {


    public Day3() {
        super();
    }

    @Override
    public void run1(AoCFile file) {


        ArrayList<String> lines = file.readLines();
        for(int i = 0; i < lines.size(); i++) {
            for (int z = 0; z < 5; z++) {
                lines.set(i, lines.get(i) + lines.get(i));
            }
        }
        int x = 0;
        int zaehler = 0;
        for(int y = 0; y < lines.size(); y++) {

            if (lines.get(y).charAt(x) == '#') {
                zaehler = zaehler +1;
            }
            x = x +3;
        }
        System.out.println(zaehler);

    }

    @Override
    public void run2(AoCFile file) {


        ArrayList<String> lines = file.readLines();
        for(int i = 0; i < lines.size(); i++) {
            for (int z = 0; z < 10; z++) {
                lines.set(i, lines.get(i) + lines.get(i));
            }
        }

        // 1 1
        int a = 0;
        int zaehler11 = 0;
        for(int b = 0; b < lines.size(); b++) {

            if (lines.get(b).charAt(a) == '#') {
                zaehler11 = zaehler11 +1;
            }
            a = a +1;
        }
        //3 1
        int c = 0;
        int zaehler31 = 0;
        for(int d = 0; d < lines.size(); d++) {

            if (lines.get(d).charAt(c) == '#') {
                zaehler31 = zaehler31 +1;
            }
            c = c +3;
        }
        //5 1
        int e = 0;
        double zaehler51 = 0;
        for(int f = 0; f < lines.size(); f++) {

            if (lines.get(f).charAt(e) == '#') {
                zaehler51 = zaehler51 +1;
            }
            e = e +5;
        }
        //7 1
        int g = 0;
        double zaehler71 = 0;
        for(int h = 0; h < lines.size(); h++) {

            if (lines.get(h).charAt(g) == '#') {
                zaehler71 = zaehler71 +1;
            }
            g = g +7;
        }
        //2 1
        int x = 0;
        double zaehler12 = 0;
        for(int y = 0; y < lines.size(); y = y+2) {

            if (lines.get(y).charAt(x) == '#') {
                zaehler12 = zaehler12 +1;
            }
            x = x +1;
        }
        System.out.printf("%.0f", zaehler11 * zaehler12 * zaehler31 * zaehler51 * zaehler71);
    }

}