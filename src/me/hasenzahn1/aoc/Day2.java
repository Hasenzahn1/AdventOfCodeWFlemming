package me.hasenzahn1.aoc;

import com.sun.deploy.util.StringUtils;
import me.aoc.Day;
import me.util.AoCFile;

import java.util.Arrays;

public class Day2 extends Day {

    public Day2() {
        super();
    }

    @Override
    public void run1(AoCFile file) {
        int counter = 0;
        for (String line : file.readLines()){ //14-15 v: vdvvvvvsvvvvvfpv
            String[] first = line.split(": ");
            String[] second = first[0].split(" ");
            String[] numbers = second[0].split("-");

            int count = first[1].split(second[1], -1).length - 1;
            int min = Integer.parseInt(numbers[0]);
            int max = Integer.parseInt(numbers[1]);
            if (count >= min && count <= max){
                counter++;
            }
        }
        System.out.println(counter);
    }

    @Override
    public void run2(AoCFile file) {
        int counter = 0;
        for (String line : file.readLines()){ //14-15 v: vdvvvvvsvvvvvfpv
            String[] first = line.split(": ");
            String[] second = first[0].split(" ");
            String[] numbers = second[0].split("-");
            int p1 = Integer.parseInt(numbers[0]);
            int p2 = Integer.parseInt(numbers[1]);
            String toSearch = "" + first[1].charAt(p1 - 1) + first[1].charAt(p2 - 1);
            int count = toSearch.split(second[1], -1).length - 1;
            if (count == 1) counter++;
        }
        System.out.println(counter);
    }
}
