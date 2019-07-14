package com.example.topic.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oof1 {

    private static int[] boxes = {0, 1, 2, 3, 4, 5};

    static {

    }

    public static void main(String[] args) {
        logFirstTwoBoxes(boxes);
    }

    private static void logFirstTwoBoxes(int[] boxes) {
        System.out.println(boxes[0]);
        System.out.println(boxes[1]);
    }
}
