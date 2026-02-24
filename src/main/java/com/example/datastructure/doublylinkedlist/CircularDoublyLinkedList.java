package com.example.datastructure.doublylinkedlist;

import com.example.datastructure.arraylist.ListInterface;

public class CircularDoublyLinkedList<E extends Comparable> implements ListInterface<E> {

    private BidirectionalNode<E> head;
    private int numItems;

    public CircularDoublyLinkedList() {
        numItems = 0;
        head = new BidirectionalNode<>(null);
        head.next = head.prev = head;
    }

    @Override
    public void add(int index, E item) {
        if (index >= 0 && index <= numItems) {
            BidirectionalNode<E> prevNode = getNode(index - 1);
            BidirectionalNode<E> newNode = new BidirectionalNode<>(prevNode, item, prevNode.next);
            prevNode.next = newNode;
            head.prev = newNode;
            numItems++;
            showItems();
        } else {
            /* 에러 처리 */
        }
    }

    private BidirectionalNode<E> getNode(int index) {
        BidirectionalNode<E> currNode = head;
        if (index < numItems/2) {
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
        } else {
            for (int i = numItems-1; i >= index; i--) {
                currNode = currNode.prev;
            }
        }
        return currNode;
    }

    @Override
    public void append(E item) {
        BidirectionalNode<E> prevNode = head.prev;
        BidirectionalNode<E> newNode = new BidirectionalNode<>(prevNode, item, head);
        prevNode.next = newNode;
        head.prev = newNode;
        numItems++;
        showItems();
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index <= numItems - 1) {
            BidirectionalNode<E> currNode = getNode(index);

            if (currNode == null) return null;

            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            numItems--;
            showItems();
            return currNode.item;
        }
        return null;
    }

    @Override
    public boolean removeItem(E item) {
        BidirectionalNode<E> currNode = head;
        for (int i = 0; i < numItems; i++) {
            currNode = currNode.next;
            if (((Comparable)(currNode.item)).compareTo(item) == 0) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
                numItems--;
                showItems();
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        }

        return null;
    }

    @Override
    public void set(int index, E item) {
        if (index >= 0 && index <= numItems - 1) {
            getNode(index).item = item;
        } else {
            /* 에러 처리 */
        }
        showItems();
    }

    private static int NOT_FOUND = -12345;
    @Override
    public int indexOf(E item) {
        BidirectionalNode<E> currNode = head;

        for (int i = 0; i < numItems; i++) {
            currNode = currNode.next;
            if(currNode.item.compareTo(item) == 0) {
                return i;
            }
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
        head.prev = head.next = head;
    }

    public void showItems() {
        BidirectionalNode<E> currNode = head;
        for (int i = 0; i <= numItems; i++) {
            System.out.println(i + "번째 값 :" + currNode.item);
            currNode = currNode.next;
        }
        System.out.println();
    }
}
