package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;

public class Day3 extends Day {

    @Override
    public void run1(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        String gamma = "";
        String epsilon = "";
        for (int i = 0; i < lines.get(0).length(); i++){
            int oneCount = 0;
            int restCount = 0;
            for (String s : lines){
                if (s.charAt(i) == '1'){
                    oneCount++;
                }else{
                    restCount++;
                }
            }
            gamma += oneCount > restCount ? "1" : "0";
            epsilon += oneCount > restCount ? "0" : "1";
        }
        int power = Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);
        System.out.println(power);
    }

    @Override
    public void run2(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        ArrayList<String> oxygen = new ArrayList<>(lines);
        for(int i = 0; i < lines.get(0).length(); i++){
            if (oxygen.size() == 1) {
                System.out.println("BRoke");
                break;
            }
            int oneCount = 0;
            int restCount = 0;
            for (String s : oxygen){
                if (s.charAt(i) == '1'){
                    oneCount++;
                }else{
                    restCount++;
                }
            }
            char toRemoveOxygen = oneCount >= restCount ? '1' : '0';
            System.out.println(oneCount + "; " + restCount + "; " + toRemoveOxygen);
            for(int x = oxygen.size() - 1; x >= 0; x--){
                if(oxygen.get(x).charAt(i) != toRemoveOxygen){
                    oxygen.remove(x);
                }
            }
        }

        ArrayList<String> co2 = new ArrayList<>(lines);
        for(int i = 0; i < lines.get(0).length(); i++){
            if (co2.size() == 1) break;
            int oneCount = 0;
            int restCount = 0;
            for (String s : co2){
                if (s.charAt(i) == '1'){
                    oneCount++;
                }else{
                    restCount++;
                }
            }
            char toRemove = oneCount >= restCount ? '0' : '1';
            for(int x = co2.size() - 1; x >= 0; x--){
                if(co2.get(x).charAt(i) != toRemove){
                    co2.remove(x);
                }
            }
        }

        System.out.println(Integer.parseInt(oxygen.get(0), 2) * Integer.parseInt(co2.get(0), 2));

    }
}
