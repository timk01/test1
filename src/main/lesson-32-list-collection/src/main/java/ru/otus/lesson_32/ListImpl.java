package ru.otus.lesson_32;

import java.util.ListIterator;

public class ListImpl implements List {
    private final Node head = new Node(null, null);
    private Node tail = head;

    @Override
    public boolean add(Object elem) {
        Node node = new Node(elem, null);
        tail.nextNode = node;
        tail = node;
        return true;
    }

    @Override
    public Object get(int idx) {
        if (!head.equals(tail)) {
            int currIdx = 0; // TODO: 19.09.2022 check
            Node currNode = head.nextNode;

            while (currIdx != idx && currNode != null) {
                currIdx++;
                currNode = currNode.nextNode;
            }

            return currNode;
        }
        return null;
    }

    @Override
    public boolean contains(Object elem) {
        Node currNode = head.nextNode;
        int elemHashCode = elem.hashCode();

        while (currNode != null) {
            int currNodeHashCode = currNode.elem.hashCode();
            if (currNodeHashCode == elemHashCode
                    && currNode.elem.equals(elem)) {
                return true;
            }
            currNode = currNode.nextNode;
        }

        return false;
    }

//    @Override
//    public boolean contains(Object elem) {
//        Node currNode = head.nextNode;
//
//        while (currNode != null) {
//            // elem == currNode -> сравнение по ссылку
//            if (currNode.elem.equals(elem)) {
//                return true;
//            }
//            currNode = currNode.nextNode;
//        }
//
//        return false;
//    }

    @Override
    public boolean remove(Object elem) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String toString() {
        Node currNodeent = head.nextNode;
        StringBuilder res = new StringBuilder();
        while (currNodeent != null) {
            res.append(currNodeent.elem).append(",");
            currNodeent = currNodeent.nextNode;
        }
        return res.toString();
    }

    @Override
    public Iterator iterator() {
        return new ListIterator(head);
    }

    private static class Node {
        private final Object elem;
        private Node nextNode;

        private Node(Object elem, Node nextNode) {
            this.elem = elem;
            this.nextNode = nextNode;
        }
    }

    private static class ListIterator implements Iterator {
        private Node currNode;

        public ListIterator(Node currNode) {
            this.currNode = currNode;
        }

        @Override
        public boolean hasNext() {
            return currNode.nextNode != null; // TODO: 19.09.2022 check null
        }

        @Override
        public Object next() {
            Node node = currNode.nextNode;
            currNode = node;
            return node.elem;
        }
    }
}
