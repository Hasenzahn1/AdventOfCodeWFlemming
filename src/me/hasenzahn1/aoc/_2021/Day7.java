package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;
import java.util.Collections;

public class Day7 extends Day {

    public static void main(String[] args) {
        Day7  d = new Day7();
        System.out.println(d.calculateFuel(4));
    }

    @Override
    public void run1(AoCFile file) {
        String[] numbers = file.readCompleteFile().replace("\n", "").split(",");
        ArrayList<Integer> intNumbers = new ArrayList<>();
        for(String s : numbers){
            intNumbers.add(Integer.parseInt(s));
        }
        Collections.sort(intNumbers);
        int minFuel = 9999999;
        int minHor = 999999;
        for(int c : intNumbers){
            int fuel = 0;
            for(int i : intNumbers){
                fuel += Math.abs(i - c);
            }
            if (fuel < minFuel){
                minFuel = fuel;
                minHor = c;
            }
        }
        System.out.println(minFuel + "; " + minHor);
    }

    public int calculateFuel(int max){
        int sum = 0, min = 0;
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }

    @Override
    public void run2(AoCFile file) {
        String[] numbers = file.readCompleteFile().replace("\n", "").split(",");
        ArrayList<Integer> intNumbers = new ArrayList<>();
        for(String s : numbers){
            intNumbers.add(Integer.parseInt(s));
        }
        Collections.sort(intNumbers);
        long minFuel = 999999999;
        long minHor = 999999999;
        for(int c = 0; c < intNumbers.get(intNumbers.size() - 1); c++){
            int fuel = 0;
            for(int i : intNumbers){
                fuel += calculateFuel(Math.abs(i - c));
            }
            if (fuel < minFuel){
                minFuel = fuel;
                minHor = c;
            }
        }
        System.out.println(minFuel + "; " + minHor);
    }
}
