package com.example.topic.datastructures;

import java.util.Arrays;

public class MyArrayApp {
    public static void main(String[] args) {
        MyArray myArray = new MyArray<Integer>(2);
        myArray.add(11);
        myArray.add(22);
        myArray.add(33);
        myArray.add(44);
        myArray.add(55);
        myArray.add(66);
        System.out.println(myArray);
        myArray.delete(2);
        System.out.println(myArray);
        myArray.delete(2);
        myArray.delete(2);
        myArray.delete(2);
        System.out.println(myArray);
        myArray.add(77);
        System.out.println(myArray);

    }
}

class MyArray<T> {

    private Object[] data;
    private int pointer;

    MyArray() {
        data = new Object[8];
        pointer = 0;
    }

    MyArray(int size) {
        data = new Object[size];
    }

    public T get(int index) {
        if (index >= data.length) {
            throw new RuntimeException("Invalid index");
        }
        return (T) data[index];
    }

    public void add(T item) {
        if (pointer == data.length) {
            data = expandArray(data);
        }
        data[pointer++] = item;
    }

    public T delete(int index) {
        if (pointer == 0) {
            throw new RuntimeException("Empty Array");
        }
        if (index >= data.length) {
            throw new RuntimeException("Invalid index");
        }
        T item = (T) data[index];
        shiftLeft(index);
        pointer--;
        return item;
    }

    public T pop() {
        if (pointer == 0) {
            throw new RuntimeException("Empty Array");
        }
        T item = (T) data[0];
        shiftLeft(0);
        pointer--;
        return item;
    }

    public int length() {
        return pointer;
    }

    public int capacity() {
        return data.length;
    }

    private Object[] expandArray(Object[] currentData) {
        Object[] newData = new Object[data.length + data.length/2];
        for(int i = 0; i < currentData.length; i++) {
            newData[i] = currentData[i];
        }
        return newData;
    }


    private void shiftLeft(int index) {
        for (int i = index; i < (data.length - 1) && data[i] != null; i++) {
            data[i] = data[i+1];
        }
        data[data.length - 1] = null;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "data=" + Arrays.toString(data) +
                ", pointer=" + pointer +
                '}';
    }
}