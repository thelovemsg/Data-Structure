package com.example.datastructure.linkedlist;

import com.example.datastructure.arraylist.ListInterface;

public class LinkedList<E extends Comparable<E>> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;

    public LinkedList() {
        numItems = 0;
        head = new Node<>(null, null);
    }

    @Override
    public void add(int index, E item) {
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index-1);
            if(prevNode != null) {
                prevNode.next = new Node<>(item, prevNode.next);
                numItems++;
                showCurrentArray();
            }
        }
    }

    @Override
    public void append(E item) {
        Node<E> prevNode = head;
        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }

        prevNode.next = new Node<>(item, null);
        numItems++;
        showCurrentArray();
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index <= numItems -1) {
            Node<E> prevNode = getNode(index-1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next;
            numItems--;
            showCurrentArray();
            return currNode.item;
        }
        return null;
    }

    public void remove(int index, int k) {
        if (index >= 0 && index <= numItems -1) {
            for (int j=0; j<k; j++) {
                Node<E> prevNode = getNode(index-1+j);
                if(prevNode != null) {
                    Node<E> currNode = prevNode.next;
                    prevNode.next = currNode.next;
                    numItems--;
                }
            }
        }
        showCurrentArray();
    }

    @Override
    public boolean removeItem(E item) {
        Node<E> prevNode, currNode = head;
        for (int i = 0; i < numItems-1; i++) {
            prevNode = currNode;
            currNode = currNode.next;
            if(currNode.item.compareTo(item) == 0){
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
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        }
        return null;
    }

    @Override
    public void set(int index, E item) {
        if (index >= 0 && index <= numItems -1) {
            getNode(index).item = item;
            showCurrentArray();
        }
    }

    public final int NOT_FOUND = -12345;
    @Override
    public int indexOf(E item) {
        Node<E> currNode = head;
        for (int i=0; i < numItems; i++){
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
        head = new Node<>(null, null);
    }

    public void concat(LinkedList<E> list1, LinkedList<E> list2) {
        Node<E> target = head;
        while(target.next != null) {
            target = target.next;
        }

        Node<E> node1 = list1.getNode(0);
        while(node1 != null) {
            target.next = new Node<>(node1.item, null);
            node1 = node1.next;
            target = target.next;
            this.numItems++; // 상태 동기화
        }

        Node<E> node2 = list2.getNode(0);
        while(node2 != null) {
            target.next = new Node<>(node2.item, null);
            node2 = node2.next;
            target = target.next;
            this.numItems++; // 상태 동기화
        }

        showCurrentArray();
    }

    private Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems -1) {
            Node<E> currNode = head;
            for (int i=0; i<= index; i++) {
                currNode = currNode.next;
            }

            return currNode;
        } else {
            return null;
        }
    }

    private void showCurrentArray() {
        Node<E> targetNode = head;
        int index = 0;
        while(targetNode != null){
            System.out.print(index++ + " 번째 수 : " + targetNode.item);
            System.out.println();
            targetNode = targetNode.next;
        }
        System.out.println();
    }

}
