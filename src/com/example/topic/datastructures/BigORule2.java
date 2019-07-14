package com.example.topic.datastructures;

public class BigORule2 {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        printFirstItemThenPrintHalfThenSayHi100Times(data);
    }

    private static void printFirstItemThenPrintHalfThenSayHi100Times(int[] items) {
        System.out.println(items[0]);

        int middleIndex = items.length / 2;
        int index = 0;

        while (index < middleIndex) {
            System.out.println(items[middleIndex]);
            index++;
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }

    // O(1 + n/2 + 100)
    // O(n/2 + 101)
    // O(n/2)
    // O(n)
}
