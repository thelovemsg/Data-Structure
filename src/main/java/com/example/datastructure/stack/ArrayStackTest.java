package com.example.datastructure.stack;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> s = new ArrayStack<>(10);
        s.push(300);
        s.push(200);
        s.push(100);
        s.pop();
    }
}
