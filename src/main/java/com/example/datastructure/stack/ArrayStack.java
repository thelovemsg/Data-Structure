package com.example.datastructure.stack;

public class ArrayStack<E> implements StackInterface<E>{

    private E stack[];
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public ArrayStack() {
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1;
    }

    public ArrayStack(int n) {
        stack = (E[]) new Object[n];
        this.topIndex = -1;
    }

    @Override
    public void push(E newItem) {
        if (isFull()) { /* 에러 처리*/ }
        else stack[++topIndex] = newItem;
        showItems();
    }

    @Override
    public E pop() {
        if (isEmpty()) return ERROR;
        showItems();
        return stack[topIndex--];
    }

    @Override
    public E top() {
        if (isEmpty()) return ERROR;
        showItems();
        return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return (topIndex < 0);
    }

    @Override
    public void popAll() {
        stack = (E[]) new Object[stack.length];
        topIndex = -1;
    }

    private boolean isFull() {
        return (topIndex == stack.length-1);
    }
    
    public void showItems() {
        for (int i = 0; i < stack.length; i++) {
            System.out.println(i + "번째 : " + stack[i]);
        }
        System.out.println();
    }
}
