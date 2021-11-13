package me.unbekannterpromi;

import me.aoc.Day;
import me.unbekannterpromi.aoc.Day1;
import me.unbekannterpromi.aoc.Day2;

public class Main {

    public static void main(String[] args) {//java Main.java test1.txt test2.txt
        Day tag = new Day2("inputFiles/2020/UnbekannterPromi/Day2_1.txt", "inputFiles/2020/UnbekannterPromi/Day2_1.txt");
        System.out.println("Starten der ersten Aufgabe");
        tag.run1();
        System.out.println("Starten der zweiten Aufgabe");
        tag.run2();
    }

}
