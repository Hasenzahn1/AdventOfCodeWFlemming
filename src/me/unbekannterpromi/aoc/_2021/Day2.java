package me.unbekannterpromi.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

public class Day2 extends Day {


    @Override
    public void run1(AoCFile file) {

        String input = file.readCompleteFile();

        int tiefe = 0;
        int weite = 0;
        int zwischenwert = 0;

        String[] splitinput = input.split("\n");
        for (String s : splitinput) {
            String[] einzeln = s.split(" ");
            zwischenwert = Integer.parseInt(einzeln[1]);
            if (einzeln[0].equals("forward")) {
                weite = weite + zwischenwert;
            } else if (einzeln[0].equals("up")) {
                tiefe = tiefe - zwischenwert;
            } else if (einzeln[0].equals("down")) {
                tiefe = tiefe + zwischenwert;
            }
        }


        System.out.println(tiefe * weite);
    }

    @Override
    public void run2(AoCFile file) {
        String input = file.readCompleteFile();

        int tiefe = 0;
        int weite = 0;
        int zwischenwert = 0;
        int aim = 0;
        int aimZwischenwert = 0;

        String[] splitinput = input.split("\n");
        for (String s : splitinput) {
            String[] einzeln = s.split(" ");
            zwischenwert = Integer.parseInt(einzeln[1]);
            if (einzeln[0].equals("forward")) {
                weite = weite + zwischenwert;
                aimZwischenwert = aim * zwischenwert;
                tiefe = tiefe + aimZwischenwert;
            } else if (einzeln[0].equals("up")) {
                aim = aim - zwischenwert;
            } else if (einzeln[0].equals("down")) {
                aim = aim + zwischenwert;
            }
        }


        System.out.println(tiefe * weite);
    }
}
