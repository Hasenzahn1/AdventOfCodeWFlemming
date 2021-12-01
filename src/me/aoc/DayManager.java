package me.aoc;

import me.util.AoCFile;

import java.io.FileNotFoundException;

public class DayManager {

    public enum Year{
        _2020("2020"),
        _2021("2021");

        private final String year;

        Year(String year){
            this.year = year;
        }

        public String getYear() {
            return year;
        }
    }

    private Day_Identifier day;
    private String main;
    private Year year;

    public DayManager(String main, Year year, Day_Identifier day){
        this.main = main;
        this.day = day;
        this.year = year;
    }

    public void run() {
        try {
            String name = main.split("\\.")[1];
            String pck = "me." + name + ".aoc._" + year.year + ".";
            String classToCall = pck + day.getClassName();
            Day test = (Day) Class.forName(classToCall).newInstance();

            System.out.println("#############Running Exercise 1#############");
            test.run1(new AoCFile("inputFiles/" + year.getYear() + "/" + name + "/" + day.getClassName() + ".txt", "rw"));

            System.out.println("#############Running Exercise 2#############");
            test.run2(new AoCFile("inputFiles/" + year.getYear() + "/" + name + "/" + day.getClassName() + ".txt", "rw"));

        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | FileNotFoundException e){
            e.printStackTrace();
        }

    }



}
