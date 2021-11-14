package me.unbekannterpromi;

import me.aoc.DayManager;
import me.aoc.Day_Identifier;
import me.aoc.Main_toimpl;

public class Main extends Main_toimpl {

    public static void main(String[] args) {//java Main.java test1.txt test2.txt
        DayManager manager = new DayManager(Main.class.getName(), DayManager.Year._2020, Day_Identifier.DAY_4);
        manager.run();
    }
}
