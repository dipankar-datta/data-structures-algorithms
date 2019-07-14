package com.example.topic.datastructures;

public class BigOCalculation1 {

    public static void main(String[] args) {
        funChallange(new int[10]);
    }

    private static int funChallange(int[] input) {
        int a = 10; // O(1)
        a = 50 + 3; // O(1)

        for (int i = 0; i < input.length; i++) { // O(n)
            justAnotherMethod(); // O(n)
            boolean stranger = true; // O(n)
            a++; // O(n)
        }

        return a; // O(1)
    }

    private static void justAnotherMethod(){

    }

    // O(1) + O(1) + O(1) + O(n) + O(n) + O(n) + O(n)
    // 1 + 1 + 1 + n + n + n + n
    // 3 + 4n
    // Big O(3 + 4n)
    // Big O(n)

}
