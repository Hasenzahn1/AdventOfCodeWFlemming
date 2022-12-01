package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day14 extends Day {

    @Override
    public void run1(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        String instruction = lines.get(0);
        HashMap<String, String> compare = new HashMap<>();
        for(int i = 2; i < lines.size(); i++){
            String[] s = lines.get(i).split(" -> ");
            compare.put(s[0], s[1]);
        }
        for(int i = 0; i < 3; i++){
            StringBuffer newInstruction = new StringBuffer(instruction);

            for(int j = 0; j < instruction.length() - 1; j++){
                String arg = instruction.charAt(j) + "" + instruction.charAt(j+1);
                String result = compare.get(arg);
                newInstruction.insert(j + 1 + j, result);
            }

            instruction = newInstruction.toString();
            System.out.println(instruction);
        }

        HashMap<String, Integer> amounts = new HashMap<>();
        for(char c : instruction.toCharArray()){
            if(!amounts.containsKey(c + "")) amounts.put(c + "", 0);
            amounts.replace(c + "", amounts.get(c + "") + 1);
        }
        ArrayList<Integer> sortedAmounts = new ArrayList<>(amounts.values());
        Collections.sort(sortedAmounts);
        System.out.println(sortedAmounts.get(sortedAmounts.size() - 1) - sortedAmounts.get(0));
    }

    @Override
    public void run2(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        char[] instruction = lines.get(0).toCharArray();
        long length = instruction.length;
        HashMap<String, String> compare = new HashMap<>();
        for(int i = 2; i < lines.size(); i++){
            String[] s = lines.get(i).split(" -> ");
            compare.put(s[0], s[1]);
        }
        System.out.println(compare);
        for(int i = 0; i < 40; i++){
            length = length * 2 + 1;
            //ArrayList<Character> newInst = new ArrayList<>();
            for(int j = 0; j < 100; j++){
                //newInst.add(new ArrayList<Character>());
            }
            char[] newInst = new char[(int) length];
            int counter = 0;
            for(char c : instruction){
                newInst[counter] = c;
                counter += 2;
            }
            String inst = String.valueOf(instruction);
            for(Map.Entry<String, String> entry : compare.entrySet()){
                int index = inst.indexOf(entry.getKey());
                if(index != -1) {
                    newInst[index * 2 + 1] = entry.getValue().charAt(0);
                }
                while (index >= 0) {
                    index = inst.indexOf(entry.getKey(), index + 1);
                    if(index != -1) {
                        newInst[index * 2 + 1] = entry.getValue().charAt(0);
                    }
                }
                //System.out.println(indices);
            }
            instruction = newInst;
            System.out.println(i  + ": " + instruction.length);
            //System.out.println(String.valueOf(newInst));
        }
    }
}
