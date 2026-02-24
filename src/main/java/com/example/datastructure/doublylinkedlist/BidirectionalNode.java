package com.example.datastructure.doublylinkedlist;

public class BidirectionalNode<E> {
    BidirectionalNode<E> prev;
    E item;
    BidirectionalNode<E> next;

    public BidirectionalNode() {
        prev = next = null;
        item = null;
    }

    public BidirectionalNode(E newItem) {
        prev = next = null;
        this.item = newItem;
    }

    public BidirectionalNode(BidirectionalNode<E> prevNode, E newItem, BidirectionalNode<E> nextNode) {
        prev = prevNode; next = nextNode;
        item = newItem;
    }
}
