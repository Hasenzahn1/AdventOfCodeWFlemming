package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day10 extends Day {

    @Override
    public void run1(AoCFile file) {
        HashMap<String, String> endings = new HashMap<>(){{
            put("(", ")");
            put("[", "]");
            put("{", "}");
            put("<", ">");
        }};
        HashMap<String, Integer> points = new HashMap<>(){{
            put(")", 3);
            put("]", 57);
            put("}", 1197);
            put(">", 25137);
        }};
        ArrayList<String> lines = file.readLines();
        ArrayList<String> wrong = new ArrayList<>();
        for(String line : lines){
            ArrayList<String> closing = new ArrayList<>();
            for(char c : line.toCharArray()){
                if(endings.containsKey(c + "")){
                    closing.add(0, endings.get(c + ""));
                }else {
                    if (endings.size() > 0){
                        if (!closing.get(0).equals(c + "")) {
                            wrong.add(c + "");
                        }
                        closing.remove(0);
                    }else{
                        break;
                    }
                }
            }
        }
        int count = 0;
        for(String s : wrong){
            count += points.get(s);
        }
        System.out.println(count);
    }

    @Override
    public void run2(AoCFile file) {
        HashMap<String, String> endings = new HashMap<>(){{
            put("(", ")");
            put("[", "]");
            put("{", "}");
            put("<", ">");
        }};
        HashMap<String, Integer> points = new HashMap<>(){{
            put(")", 1);
            put("]", 2);
            put("}", 3);
            put(">", 4);
        }};
        ArrayList<String> lines = file.readLines();
        for(int i = lines.size() - 1; i >= 0; i--){
            ArrayList<String> closing = new ArrayList<>();
            for(char c : lines.get(i).toCharArray()){
                if(endings.containsKey(c + "")){
                    closing.add(0, endings.get(c + ""));
                }else {
                    if (endings.size() > 0){
                        if (!closing.get(0).equals(c + "")) {
                            lines.remove(i);
                            break;
                        }
                        closing.remove(0);
                    }else{
                        break;
                    }
                }
            }
        }
        ArrayList<Long> counts = new ArrayList<>();
        for(int i = lines.size() - 1; i >= 0; i--){
            ArrayList<String> closing = new ArrayList<>();
            for(char c : lines.get(i).toCharArray()){
                if(endings.containsKey(c + "")){
                    closing.add(0, endings.get(c + ""));
                }else {
                    if(closing.get(0).equals(c + "")){
                        closing.remove(0);
                    }
                }
            }
            long count = 0;
            for(String s : closing){
                count *= 5;
                count += points.get(s);
            }
            System.out.println(count);
            counts.add(count);
        }
        System.out.println(counts);
        Collections.sort(counts);
        System.out.println(counts.get(counts.size() / 2));

    }
}
