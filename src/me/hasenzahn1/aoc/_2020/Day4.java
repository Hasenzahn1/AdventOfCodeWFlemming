package me.hasenzahn1.aoc._2020;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.Arrays;

public class Day4 extends Day {


    @Override
    public void run1(AoCFile file) {
        String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        String[] passports = file.readCompleteFile().split("\n\n");
        //System.out.println(Arrays.asList(passports));
        int passportCount = 0;
        for(String passport : passports){
            String[] cFields = passport.split(" |\n");
            int fieldCount = 0;
            for(int i = 0; i < cFields.length; i++){
                cFields[i] = cFields[i].split(":")[0];
                if (Arrays.asList(fields).contains(cFields[i])){
                    fieldCount ++;
                }
            }
            if(fieldCount == 7) passportCount++;
            //System.out.println(Arrays.asList(cFields) + ": " + fieldCount);
        }
        System.out.println(passportCount);
    }

    @Override
    public void run2(AoCFile file) {
        String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        String[] passports = file.readCompleteFile().split("\n\n");
        //System.out.println(Arrays.asList(passports));
        int passportCount = 0;
        for(String passport : passports) {
            String[] cFields = passport.split(" |\n");
            int fieldCount = 0;
            for (int i = 0; i < cFields.length; i++) {
                String[] keyValue = cFields[i].split(":");

                switch (keyValue[0]) {
                    case "byr":
                        int byr = Integer.parseInt(keyValue[1]);
                        if (byr >= 1920 && byr <= 2002) fieldCount++;
                        break;
                    case "iyr":
                        int iyr = Integer.parseInt(keyValue[1]);
                        if (iyr >= 2010 && iyr <= 2020) fieldCount++;
                        break;
                    case "eyr":
                        int eyr = Integer.parseInt(keyValue[1]);
                        if (eyr >= 2020 && eyr <= 2030) fieldCount++;
                        break;
                    case "hgt":
                        int number = Integer.parseInt(keyValue[1].replaceAll("cm|in", ""));
                        if (keyValue[1].contains("cm")) {
                            if (number >= 150 && number <= 193) fieldCount++;
                        } else if (keyValue[1].contains("in")) {
                            if (number >= 59 && number <= 76) fieldCount++;
                        }
                        break;
                    case "hcl":
                        if (keyValue[1].startsWith("#")) {
                            keyValue[1] = keyValue[1].replace("#", "");
                            if (keyValue[1].length() == 6) {
                                boolean valid = true;
                                for (char c : keyValue[1].toCharArray()) {
                                    if (!"0123456789abcdef".contains(c + "")) {
                                        valid = false;
                                        break;
                                    }
                                }
                                if (valid) fieldCount++;
                            }
                        }
                        break;
                    case "ecl":
                        if (Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(keyValue[1])) {
                            fieldCount++;
                        }
                        break;
                    case "pid":
                        if (keyValue[1].length() == 9 && Integer.parseInt(keyValue[1]) != -1) fieldCount++;
                        break;

                }
            }
            if(fieldCount == 7) passportCount++;
            //System.out.println(Arrays.asList(cFields) + ": " + fieldCount);
        }
        System.out.println(passportCount);
    }
}
