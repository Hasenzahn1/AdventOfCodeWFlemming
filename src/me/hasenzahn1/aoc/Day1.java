package me.hasenzahn1.aoc;

import me.aoc.Day;


public class Day1 extends Day {

    public Day1(String fileName1, String fileName2) {
        super(fileName1, fileName2);
    }

    @Override
    public void run1() {
        int[] values = file1.readLines().stream().map(Integer::parseInt).mapToInt(x -> x).toArray();
        for(int x = 0; x < values.length; x++){
            for (int y = x + 1; y < values.length; y++){
                if(values[x] + values[y] == 2020){
                    System.out.println(values[x] + " * " + values[y] + " = " + (values[x] * values[y]));
                    return;
                }
            }
        }

    }

    @Override
    public void run2() {
        int[] values = file2.readLines().stream().map(Integer::parseInt).mapToInt(x -> x).toArray();
        for(int x = 0; x < values.length; x++){
            for (int y = x + 1; y < values.length; y++){
                for (int z = y + 1; z < values.length; z++) {
                    if (values[x] + values[y] + values[z] == 2020) {
                        System.out.println(values[x] + " * " + values[y] + " * " + values[z] + " = " + (values[x] * values[y] * values[z]));
                        return;
                    }
                }
            }
        }
    }
}
