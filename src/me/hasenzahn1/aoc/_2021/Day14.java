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
        for(int i = 0; i < 10; i++){
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
        String instText = lines.get(0);
        ArrayList<String> instruction = Arrays.asList(lines.get(0).toCharArray()).stream().map(String::new).collect(Collectors.toCollection(ArrayList::new));
        HashMap<String, String> compare = new HashMap<>();
        for(int i = 2; i < lines.size(); i++){
            String[] s = lines.get(i).split(" -> ");
            compare.put(s[0], s[1]);
        }
        for(int i = 0; i < 4; i++){
            ArrayList<String> instCopy = (ArrayList<String>) instruction.clone();

            for(Map.Entry<String, String> entry : compare.entrySet()){
                int[] indices = IntStream.range(0, instCopy.size() - 1)
                        .filter(z -> entry.getKey().equals(instText.charAt(z) + "" + instText.charAt(z + 1)))
                        .toArray();
                System.out.println(indices.length);

                for(int j = indices.length - 1; j >= 0; j--){
                    instCopy.add(j + 1, entry.getValue());
                }
            }
            instruction = instCopy;
            System.out.println(instCopy);
        }

        HashMap<String, Long> amounts = new HashMap<>();
        for(String c : instruction){
            if(!amounts.containsKey(c + "")) amounts.put(c + "", 0L);
            amounts.replace(c + "", amounts.get(c + "") + 1);
        }
        ArrayList<Long> sortedAmounts = new ArrayList<>(amounts.values());
        Collections.sort(sortedAmounts);
        System.out.println(sortedAmounts.get(sortedAmounts.size() - 1) - sortedAmounts.get(0));
    }
}
