package ru.otus.lesson_32;

public class SetImpl implements Set {
    private final Node head = new Node(null, null);
    private Node tail = head;

    @Override
    public boolean add(Object elem) {
        if (!this.contains(elem)) {
            Node node = new Node(elem, null);
            tail.nextNode = node;
            tail = node;
            return true;
        }
        return false; // TODO: 19.09.2022  либо бросить эксепшн
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

    @Override
    public boolean remove(Object elem) {
        Node prevNode = head;
        Node currNode = head.nextNode;

        int elemHashCode = elem.hashCode();

        while (currNode != null) {
            int currNodeHashCode = currNode.elem.hashCode();
            if (currNodeHashCode == elemHashCode
                    && currNode.elem.equals(elem)) {

                prevNode.nextNode = currNode.nextNode;

                return true;
            }
            prevNode = currNode;
            currNode = currNode.nextNode;
        }

        return false;
    }

    private static class Node {
        private final Object elem;
        private Node nextNode;

        private Node(Object elem, Node nextNode) {
            this.elem = elem;
            this.nextNode = nextNode;
        }
    }
}
