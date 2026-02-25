package com.example.datastructure.stack;

import com.example.datastructure.linkedlist.LinkedList;

public class InheritedStack<E extends Comparable> extends LinkedList implements StackInterface<E> {

    public InheritedStack() {
        super();
    }

    @Override
    public void push(E newItem) {
        add(0, newItem);
    }

    @Override
    public E pop() {
        if (!isEmpty()) return (E) remove(0);
        return null;
    }

    @Override
    public E top() {
        return (E) get(0);
    }

    @Override
    public void popAll() {
        clear();
    }
}
