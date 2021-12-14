package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;
import java.util.HashMap;

public class Day6 extends Day {

    @Override
    public void run1(AoCFile file) {
        String[] lines = file.readCompleteFile().replace("\n", "").split(",");
        ArrayList<Integer> counters = new ArrayList<>();
        for(String s : lines){
            counters.add(Integer.parseInt(s.strip()));
        }
        for(int i = 0; i < 80; i++){
            ArrayList<Integer> newCounters = new ArrayList<>();
            for (Integer counter : counters) {
                if (counter == 0) {
                    newCounters.add(6);
                    newCounters.add(8);
                } else {
                    newCounters.add(counter - 1);
                }
            }
            counters = newCounters;
        }
        System.out.println(counters.size());
    }

    @Override
    public void run2(AoCFile file) {
        String[] lines = file.readCompleteFile().replace("\n", "").split(",");
        HashMap<Integer, Long> amounts = new HashMap<>();
        for(int i = 0; i < 9; i++){
            amounts.put(i, (long) 0);
        }
        for(String line : lines){
            amounts.put(Integer.parseInt(line), amounts.get(Integer.parseInt(line)) + 1);
        }
        for (int i = 0; i < 256; i++){
            HashMap<Integer, Long> newAmounts = new HashMap<>();
            for (Integer key : amounts.keySet()) {
                if (key == 0){
                    newAmounts.put(8, amounts.get(0) + (newAmounts.get(9 - 1) != null ? newAmounts.get(9 - 1) : 0));
                    newAmounts.put(6, amounts.get(0) + (newAmounts.get(6 - 1) != null ? newAmounts.get(6 - 1) : 0));
                }else{
                    if (newAmounts.get(key - 1) != null)
                        newAmounts.put(key - 1, amounts.get(key) + newAmounts.get(key - 1));
                    else
                        newAmounts.put(key - 1, amounts.get(key));
                }
            }
            amounts = newAmounts;

        }
        long count = 0;
        for(int key : amounts.keySet()){
            count += amounts.get(key);
        }
        System.out.println(count);

    }
}
