package ru.otus.lesson_33.models;

import ru.otus.lesson_32.ListImpl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedListImpl<T> implements List<T> {

    private ru.otus.lesson_33.models.ListNode<T> head;
    private ru.otus.lesson_33.models.ListNode<T> tail;
    private int size = -1;

    public LinkedListImpl() {
        this.head = new ru.otus.lesson_33.models.ListNode<>(null);
        this.tail = new ru.otus.lesson_33.models.ListNode<>(null);
    }

    @Override
    public int size() {
        return size + 1;
    }

    @Override
    public boolean isEmpty() {
        return size < 0;
    }

    @Override
    public boolean add(T item) {
        if (item == null) {
            return false; //exc
        }

        // <-[T|V|H]->[]

        ru.otus.lesson_33.models.ListNode<T> listNode = new ru.otus.lesson_33.models.ListNode<>(item);
        if (isEmpty()) {
            head = listNode;
            tail = listNode;
            head.setNext(null);
            tail.setPrevious(null);
            System.out.println("solo head.getItem() after 1 insertion " + tail.getItem());
        } else {
            tail.setNext(listNode);
            listNode.setPrevious(tail);
            tail = listNode;
            tail.setNext(null);
            System.out.println("solo head.getItem() after 2+ insertion " + tail.getItem());
        }
        size++;

        return true;
    }

    @Override
    public void clear() {
        this.head = new ru.otus.lesson_33.models.ListNode<>(null);
        this.tail = new ru.otus.lesson_33.models.ListNode<>(null);
        size = -1;
    }

    @Override
    public T get(int index) {
        ru.otus.lesson_33.models.ListNode<T> current = head;
        if (current.getItem() != null) {
            int currIdx = 0;
            ru.otus.lesson_33.models.ListNode<T> currNode = current;

            while (currIdx != index && currNode != null) {
                currIdx++;
                currNode = currNode.getNext();
            }
            if (currIdx == index && currNode != null) {
                return currNode.getItem();
            }
        }
        return null;
    }

    @Override
    public T set(int index, T item) {
        // TODO
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private ru.otus.lesson_33.models.ListNode<T> current;

        LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current.hasNext();
        }

        @Override
        public T next() {
            ru.otus.lesson_33.models.ListNode<T> next = current.getNext();
            current = next;
            return current.getItem();
        }
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public void display() {
        ru.otus.lesson_33.models.ListNode<T> current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current.getNext() != null) {
            System.out.print(current.getItem() + " ");
            current = tail;
        }
    }

    @Override
    public String toString() {
        return "LinkedListImpl{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
