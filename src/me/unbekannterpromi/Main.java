package me.unbekannterpromi;

import me.aoc.Day;
import me.unbekannterpromi.aoc.Day1;

public class Main {



    public static void main(String[] args) {
        Day tag = new Day1("inputFiles/2020/UnbekannterPromi/Day1_1.txt", "inputFiles/2020/UnbekannterPromi/Day1_1.txt");
        System.out.println("Starten der ersten Aufgabe");
        tag.run1();
        System.out.println("Starten der zweiten Aufgabe");
        tag.run2();
    }

}
