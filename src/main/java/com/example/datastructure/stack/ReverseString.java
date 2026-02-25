package com.example.datastructure.stack;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Test Seq 12345";
        String t = reverse(input);
        System.out.println("Input String: " + input);
        System.out.println("Reversed string: " + t);
    }

    private static String reverse(String s) {
        ArrayStack<Character> st = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }

        StringBuilder output = new StringBuilder();
        while(!st.isEmpty()) {
            output.append(st.pop());
        }
        return output.toString();
    }
}
