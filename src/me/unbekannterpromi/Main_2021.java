package me.unbekannterpromi;

import me.aoc.DayManager;
import me.aoc.Day_Identifier;
import me.aoc.Main_toimpl;

public class Main_2021 extends Main_toimpl {

    public static void main(String[] args) {
        DayManager manager = new DayManager(Main_2020.class.getName(), DayManager.Year._2021, Day_Identifier.DAY_2); // hier das DAY_! zu DAY_2 macheb vei neuem tag
        manager.run();

    }
}
