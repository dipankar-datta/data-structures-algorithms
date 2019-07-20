package com.example.topic.datastructures;

import java.util.Arrays;

public class MergeSortedArraysApp {

    public static void main(String[] args) {

        int[] sortedArr = mergeSortedArray(new int[]{4, 6, 30}, new int[]{0, 3, 4, 31});
        System.out.println(Arrays.toString(sortedArr));

    }

    private static int[] mergeSortedArray(int[] arr1, int[] arr2) {

        if (arr1.length == 0) {
            return arr2;
        }
        if (arr2.length == 0) {
            return arr1;
        }

        Integer arr1Val = arr1[0];
        Integer arr2Val = arr2[0];

        int arr1Counter = 1;
        int arr2Counter = 1;
        int resultIndex = 0;

        int[] result = new int[arr1.length + arr2.length];

        while (arr1Val != null || arr2Val != null || resultIndex < result.length) {

            if (arr1Val != null && (arr2Val == null || arr1Val < arr2Val) ) {
                result[resultIndex++] = arr1Val;
                arr1Val = arr1Counter < arr1.length ?  arr1[arr1Counter++] : null;
            } else {
                result[resultIndex++] = arr2Val;
                arr2Val = arr2Counter < arr2.length ? arr2[arr2Counter++] : null;
            }
        }

        return result;
    }
}
