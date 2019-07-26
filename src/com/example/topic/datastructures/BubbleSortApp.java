package com.example.topic.datastructures;

public class BubbleSortApp {

    public static void main(String[] args) {
        int[] data = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        doBubbleSort(data);

        for (int num: data) {
            System.out.print(num + ", ");
        }

    }

    private static void doBubbleSort(int[] data) {
        int length = data.length;

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < (length - 1); j++) {
                if (data[j] > data[j+1]) {
                    //Swap
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
