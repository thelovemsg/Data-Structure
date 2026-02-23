package com.example.datastructure.arraylist;

public interface ListInterface<E> {
    void add(int index, E item);
    void append(E item);
    E remove(int index);
    boolean removeItem(E item);
    E get(int index);
    void set(int index, E item);
    int indexOf(E item);
    int len();
    boolean isEmpty();
    void clear();
}
