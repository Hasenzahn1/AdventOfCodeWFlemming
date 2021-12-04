package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;

public class Day2 extends Day {

    @Override
    public void run1(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        int xAmount = 0;
        int yAmount = 0;
        for (String line : lines) {
            int amount = Integer.parseInt(line.split(" ")[1]);
            if (line.charAt(0) == 'f') {
                xAmount += amount;
            } else if (line.charAt(0) == 'd') {
                yAmount += amount;
            } else {
                yAmount -= amount;
            }
        }
        System.out.println(xAmount * yAmount);
    }

    @Override
    public void run2(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        int xAmount = 0;
        int yAmount = 0;
        int aim = 0;
        for (String line : lines) {
            int amount = Integer.parseInt(line.split(" ")[1]);
            if (line.charAt(0) == 'f') {
                xAmount += amount;
                yAmount += aim * amount;
            } else if (line.charAt(0) == 'd') {
                aim += amount;
            } else {
                aim -= amount;
            }
        }
        System.out.println(xAmount * yAmount);
    }
}
