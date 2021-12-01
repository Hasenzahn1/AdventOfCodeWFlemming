package me.hasenzahn1;

import me.aoc.DayManager;
import me.aoc.Day_Identifier;
import me.aoc.Main_toimpl;

public class Main extends Main_toimpl {

    public static void main(String[] args) {
        int[] x = new int[1000];
        for (int i = 0; i < x.length; i++){
            x[i] = i;
        }

        Main main = new Main();
        main.test(x);

        DayManager manager = new DayManager(Main.class.getName(), DayManager.Year._2020, Day_Identifier.DAY_5);
        manager.run();

    }

    public void test(int[] a){

    }
}
