package me.hasenzahn1.aoc.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Display {


    HashMap<Integer, Integer> lengths;
    String[] input, output;
    String[] resolved;
    HashMap<Integer, Integer> defined;

    public Display(String[] input, String[] output){
        this.input = input;
        this.output = output;
        resolved = new String[10];
        lengths = new HashMap<>();
        lengths.put(0, 6);
        lengths.put(1, 2);
        lengths.put(2, 5);
        lengths.put(3, 5);
        lengths.put(4, 4);
        lengths.put(5, 5);
        lengths.put(6, 6);
        lengths.put(7, 3);
        lengths.put(8, 8);
        lengths.put(9, 6);

        defined = new HashMap<>();
        defined.put(2, 1);
        defined.put(7, 8);
        defined.put(3, 7);
        defined.put(4, 4);
    }

    public void dechiffre(){
        //System.out.println(Arrays.asList(input));
        for(String s : input){
            if(defined.containsKey(s.length())){
                resolved[defined.get(s.length())] = s;
            }
        }
        //System.out.println(Arrays.asList(resolved));
        String a47 = add(resolved[4], resolved[7]);
        String uul = subtract(resolved[8], a47);
        char ul;
        if(compareToAll(subtract(resolved[8], uul.charAt(0) + ""))) {
            resolved[9] = subtract(resolved[8], uul.charAt(0) + "");
            ul = uul.charAt(0);
        }else{
            resolved[9] = subtract(resolved[8], uul.charAt(1) + "");
            ul = uul.charAt(1);
        }

        //System.out.println(Arrays.asList(resolved));

        String ll = resolved[1];
        char lo;
        if(compareToAll(subtract(resolved[8], ll.charAt(0) + ""))){
            resolved[6] = subtract(resolved[8], ll.charAt(0) + "");
            lo = ll.charAt(0);
        }else{
            resolved[6] = subtract(resolved[8], ll.charAt(1) + "");
            lo = ll.charAt(1);
        }

        //System.out.println(Arrays.asList(resolved));

        resolved[5] = subtract(resolved[8], ul + "" + lo);

        //System.out.println(Arrays.asList(resolved));

        String s41 = subtract(resolved[4], resolved[1]);
        char m;
        if(compareToAll(subtract(resolved[8], s41.charAt(0) + ""))){
            resolved[0] = subtract(resolved[8], s41.charAt(0) + "");
            m = s41.charAt(0);
        }else{
            resolved[0] = subtract(resolved[8], s41.charAt(1) + "");
            m = s41.charAt(1);
        }

        resolved[3] = add(resolved[1], add(m + "", add(subtract(resolved[7], resolved[4]), uul.charAt((uul.indexOf(ul) + 1) % 2) + "")));
        //System.out.println(Arrays.asList(resolved));
        resolved[2] = subtract(resolved[8], add(ll.charAt((ll.indexOf(lo) + 1) % 2) + "", subtract(resolved[4], resolved[3])));
        //System.out.println(Arrays.asList(resolved));
    }

    public int parseOutput(){
        String out = "";
        for(String s : output){
            for(int i = 0; i < resolved.length; i++){
                if(sameChars(s, resolved[i])){
                    out += i;
                }
            }
        }

        return Integer.parseInt(out);
    }

    public boolean compareToAll(String s){
        for(String number : input){
            if(sameChars(number, s)) return true;
        }
        return false;
    }

    private boolean sameChars(String firstStr, String secondStr) {
        char[] first = firstStr.toCharArray();
        char[] second = secondStr.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    public String subtract(String s1, String s2){
        for(char c : s2.toCharArray()){
            s1 = s1.replace(c + "", "");
        }
        return s1;
    }

    public String add(String s1, String s2){
        String ns = "";
        for(char c : s1.toCharArray()){
            ns += c;
        }
        for(char c : s2.toCharArray()){
            if(!ns.contains(c + "")) ns += c;
        }
        return ns;
    }
}
