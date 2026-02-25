package com.example.datastructure.stack;

public class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStack<String> s = new LinkedStack<>();
        s.push("test 1");
        s.push("test 2");
        s.push("test 3");
        s.pop();
    }
}
