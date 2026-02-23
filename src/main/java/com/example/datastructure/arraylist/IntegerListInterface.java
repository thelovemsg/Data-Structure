package com.example.datastructure.arraylist;

public interface IntegerListInterface {
    void add(int i, Integer x);
    void append(Integer x);
    Integer remove(int i);
    boolean removeItem(Integer x);
    Integer get(int i);
    void set(int i, Integer x);
    int indexOf(Integer x);
    int len();
    boolean isEmpty();
    void clear();
}
