package me.hasenzahn1;

import me.aoc.Day;
import me.hasenzahn1.aoc.Day1;

public class Main {

    public static void main(String[] args) {
        Day day1 = new Day1("inputFiles/2020/Day1_1.txt", "inputFiles/2020/Day1_1.txt");
        System.out.println("###################Running Part 1###################");
        day1.run1();
        System.out.println("###################Running Part 2###################");
        day1.run2();
    }
}
