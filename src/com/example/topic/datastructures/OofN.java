package com.example.topic.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OofN {

    private static List<String> nemo = Arrays.asList("nemo");
    private static List<String> everyone = Arrays.asList("dory", "bruce", "marlin", "nemo", "gill",
            "bloat", "nigel", "squirt", "darla", "hank");
    private static List<String> large = new ArrayList<>();

    static {
        for (int i = 0; i < 9999999; i++) {
            large.add("Hello - " + i );
        }
        large.add("nemo");
    }

    public static void main(String[] args) {
        long start = new Date().getTime();

        long end = new Date().getTime();
        System.out.println("Total Addition time: " + (end - start) + " Milis");
        findNamo(large);
    }

    private static void findNamo(List<String>  list) {
        long start = new Date().getTime();
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("nemo")) {
                System.out.println("Found Nemo");
            }
        }
        long end = new Date().getTime();
        System.out.println("Total Execution time: " + (end - start) + " Milis");
    }
}
