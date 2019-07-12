package com.example.topic.datastructures;

import java.util.Arrays;
import java.util.List;

public class GoodCode {
    private static List<String> nemo = Arrays.asList("nemo");

    public static void main(String[] args) {
        findNamo(nemo);
    }

    private static void findNamo(List<String>  list) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("nemo")) {
                System.out.println("Found Nemo");
            }
        }
    }
}