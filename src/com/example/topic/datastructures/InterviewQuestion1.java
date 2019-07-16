package com.example.topic.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InterviewQuestion1 {

    private static String[] arr1 = {"A", "B", "C", "X"};
    private static String[] arr2 = {"Z", "Y", "C"};

    public static void main(String[] args) {
        System.out.println("Contains: " + containsCommonItem2(arr1, arr2));
    }

    private static boolean containsCommonItem(String[] arr1, String[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsCommonItem2(String[] arr1, String[] arr2) {
        Set<String> set = new HashSet<>(arr1.length);

        for (String item: arr1) {
            set.add(item);
        }

        System.out.println(set);

        for (String item: arr2) {
            if (set.contains(item)) {
                return true;
            }
        }

        return false;
    }
}
