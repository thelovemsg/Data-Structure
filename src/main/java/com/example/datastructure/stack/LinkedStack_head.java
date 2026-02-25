package com.example.datastructure.stack;

import com.example.datastructure.common.Node;

public class LinkedStack_head<E> implements StackInterface<E> {

    private Node<E> topNode;
    private final E ERROR = null;

    public LinkedStack_head() {
        topNode = null;
    }

    @Override
    public void push(E newItem) {
        topNode = new Node<>(newItem, topNode);
        showItems();
    }

    @Override
    public E pop() {
        if(isEmpty()) return ERROR;
        Node<E> temp = topNode;
        topNode = topNode.next;
        showItems();
        return temp.item;
    }

    @Override
    public E top() {
        if (isEmpty()) return ERROR;
        return topNode.item;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void popAll() {
        topNode = null;
    }

    public void showItems() {
        Node<E> node = topNode;
        int index = 0;
        while(node != null) {
            System.out.println(index + "번째 : " + node.item);
            node = node.next;
            index++;
        }
        System.out.println();
    }

}
