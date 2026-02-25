package com.example.datastructure.stackproblem;

public interface ListInterface<E> {
    void add(int index, E item);
    void append(E item);
    void remove(int index);
    E get(int index);
    void clear();
    int len();
    boolean isEmpty();
}
