package com.example.datastructure.linkedlist;

import com.example.datastructure.arraylist.ListInterface;

public class CircularLinkedList<E extends Comparable> implements ListInterface<E> {

    private Node<E> tail;
    private int numItems;

    public CircularLinkedList() {
        numItems = 0;
        tail = new Node<>(null);
        tail.next = tail;
    }

    @Override
    public void add(int index, E item) {
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index-1);
            Node<E> newNode = new Node<>(item, prevNode.next);
            prevNode.next = newNode;
            if (index == numItems)
                tail = newNode;
            numItems++;
            showCurrentArray();
        }
    }

    @Override
    public void append(E item) {
        Node<E> prevNode = tail;
        Node<E> newNode = new Node<>(item, tail.next);
        prevNode.next = newNode;
        tail = newNode;
        numItems++;
        showCurrentArray();
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index <= numItems-1) {
            Node<E> prevNode = getNode(index-1);
            E rItem = prevNode.next.item;
            prevNode.next = prevNode.next.next;
            if(index == numItems) {
                tail = prevNode;
            }
            numItems--;
            showCurrentArray();
            return rItem;
        }
        return null;
    }

    @Override
    public boolean removeItem(E item) {
        Node<E> currNode = tail.next;
        Node<E> prevNode;
        for (int i = 0; i < numItems; i++) {
            prevNode = currNode;
            currNode = currNode.next;
            if(currNode.item.compareTo(item) == 0) {
                prevNode.next = currNode.next;
                numItems--;
                showCurrentArray();
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems-1) {
            return getNode(index).item;
        }
        return null;
    }

    @Override
    public void set(int index, E item) {
        if(index >= 0 && index <= numItems-1) {
            getNode(index).item = item;
            showCurrentArray();
        }
    }

    public final int NOT_FOUND = -12345;
    @Override
    public int indexOf(E item) {
        Node<E> currNode = tail.next;
        for (int i = 0; i < numItems-1; i++) {
            currNode = currNode.next;
            if(currNode.item.compareTo(item) == 0) return i;
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        tail = new Node<>(null);
        tail.next = tail;
    }

    private Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems) {
            Node<E> currNode = tail.next;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        }
        return null;
    }

    private void showCurrentArray() {
        if (numItems == 0) {
            System.out.println("리스트가 비어있습니다.\n");
            return;
        }

        // tail.next는 더미 헤드이므로, 실제 첫 번째 데이터는 tail.next.next 입니다.
        Node<E> targetNode = tail.next.next;

        for (int i = 0; i < numItems; i++) {
            System.out.println(i + " 번째 수 : " + targetNode.item);
            targetNode = targetNode.next;
        }
        System.out.println();
    }
}
