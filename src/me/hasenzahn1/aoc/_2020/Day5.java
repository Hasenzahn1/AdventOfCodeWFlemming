package me.hasenzahn1.aoc._2020;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;
import java.util.Collections;

public class Day5 extends Day {

    @Override
    public void run1(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        int highestSeat = 0;
        for (String test : lines) {
            int minRow = 0, maxRow = 127;
            char[] chars = test.toCharArray();
            for (int i = 0; i < 7; i++) {
                int diff = maxRow - minRow;
                if (chars[i] == 'F') {
                    maxRow -= Math.floor(diff / 2.0);
                } else {
                    minRow += Math.ceil(diff / 2.0);
                }
            }
            int row = Math.min(minRow, maxRow);
            int minCollum = 0, maxCollum = 7;
            chars = test.toCharArray();
            for (int i = 7; i < chars.length; i++) {
                int diff = maxCollum - minCollum;
                if (chars[i] == 'L') {
                    maxCollum -= Math.floor(diff / 2.0);
                } else {
                    minCollum += Math.ceil(diff / 2.0);
                }
            }
            int collum = Math.min(minCollum, maxCollum);
            int result = row * 8 + collum;
            if (result > highestSeat) highestSeat = result;
        }

        System.out.println(highestSeat);
    }

    @Override
    public void run2(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        ArrayList<Integer> values = new ArrayList<>();
        for (String test : lines) {
            int minRow = 0, maxRow = 127;
            char[] chars = test.toCharArray();
            for (int i = 0; i < 7; i++) {
                int diff = maxRow - minRow;
                if (chars[i] == 'F') {
                    maxRow -= Math.floor(diff / 2.0);
                } else {
                    minRow += Math.ceil(diff / 2.0);
                }
            }
            int row = Math.min(minRow, maxRow);
            int minCollum = 0, maxCollum = 7;
            chars = test.toCharArray();
            for (int i = 7; i < chars.length; i++) {
                int diff = maxCollum - minCollum;
                if (chars[i] == 'L') {
                    maxCollum -= Math.floor(diff / 2.0);
                } else {
                    minCollum += Math.ceil(diff / 2.0);
                }
            }
            int collum = Math.min(minCollum, maxCollum);
            int result = row * 8 + collum;
            values.add(result);
        }
        Collections.sort(values);
        for(int i = 0; i < values.size() - 1; i++){
            if(values.get(i + 1) - values.get(i) == 2){
                System.out.println(values.get(i) + ", " + values.get(i + 1));
                System.out.println("SeatId: " + (values.get(i) + 1));
            }
        }
    }
}
