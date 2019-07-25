package com.example.topic.datastructures;

public class Recusrion {

    private static int fibonacciCounter = 0;

    public static void main(String[] args) {
        System.out.println(doFibonacci(6));
    }

    private static int doFactorial(int number) {
        if (number == 2) {
            return number;
        }

        return number * doFactorial(number - 1);
    }

    private static int doFibonacci(int index) {

       if (index < 2) {
           return index;
       }
        return doFibonacci(index - 1) + doFibonacci(index - 2);
    }
}
