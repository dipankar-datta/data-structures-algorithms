package com.example.topic.datastructures;

public class OofNpower2 {

    private static int[] boxes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        logAllPairOfBoxes(boxes);
    }

    private static void logAllPairOfBoxes(int[] input) {
        for (int i = 0; i < input.length; i++ ){
            for (int j = 0; j < input.length; j++) {
                System.out.println(input[i] + " - " + input[j]);
            }
        }
    }
}
