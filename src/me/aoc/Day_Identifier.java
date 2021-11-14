package me.aoc;

public enum Day_Identifier {
    DAY_1("Day1"),
    DAY_2("Day2"),
    DAY_3("Day3"),
    DAY_4("Day4"),
    DAY_5("Day5"),
    DAY_6("Day6"),
    DAY_7("Day7"),
    DAY_8("Day8"),
    DAY_9("Day9"),
    DAY_10("Day10"),
    DAY_11("Day11"),
    DAY_12("Day12"),
    DAY_13("Day13"),
    DAY_14("Day14"),
    DAY_15("Day15"),
    DAY_16("Day16"),
    DAY_17("Day17"),
    DAY_18("Day18"),
    DAY_19("Day19"),
    DAY_20("Day20"),
    DAY_21("Day21"),
    DAY_22("Day22"),
    DAY_23("Day23"),
    DAY_24("Day24"),
    DAY_25("Day25");


    private final String className;


    Day_Identifier(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
