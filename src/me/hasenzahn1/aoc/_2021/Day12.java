package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day12 extends Day {

    public int counter = 0;
    private ArrayList<String> paths = new ArrayList<>();

    @Override
    public void run1(AoCFile file) {
        counter = 0;
        paths.clear();
        ArrayList<String> lines = file.readLines();
        HashMap<String, ArrayList<String>> connections = new HashMap<>();
        for(String line : lines){
            String[] split = line.split("-");
            if(!connections.containsKey(split[0])){
                connections.put(split[0], new ArrayList<>());
            }
            if(!connections.containsKey(split[1])){
                connections.put(split[1], new ArrayList<>());
            }
            connections.get(split[0]).add(split[1]);
            connections.get(split[1]).add(split[0]);
        }
        System.out.println(connections);
        loop(connections, "start", "", false);
        System.out.println(counter);
    }

    public void loop(HashMap<String, ArrayList<String>> connections, String current, String visited, boolean visitedtwice){
        if(current.equals("end")){
            counter++;
            //System.out.println(visited + "end");
            paths.add(visited + "end");
            return;
        }

        visited += current + ",";
        for(String conn : connections.get(current)){
            if (conn.equals("start")) continue;

            if(Character.isLowerCase(conn.charAt(0)) && Arrays.asList(visited.split(",")).contains(conn) && !visitedtwice){
                visitedtwice = true;
                loop(connections, conn, visited, visitedtwice);
                visitedtwice = false;
                continue;
            }else if(Character.isLowerCase(conn.charAt(0)) && Arrays.asList(visited.split(",")).contains(conn)){
                continue;
            }
            loop(connections, conn, visited, visitedtwice);
        }

    }

    @Override
    public void run2(AoCFile file) {

    }
}
