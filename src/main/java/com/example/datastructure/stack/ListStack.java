package com.example.datastructure.stack;

import com.example.datastructure.arraylist.ListInterface;
import com.example.datastructure.linkedlist.LinkedList;

public class ListStack<E extends Comparable> implements StackInterface<E>{

    private ListInterface<E> list;

    public ListStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public void push(E newItem) {
        list.add(0, newItem);
    }

    @Override
    public E pop() {
        return list.remove(0);
    }

    @Override
    public E top() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void popAll() {
        list.clear();
    }
}
