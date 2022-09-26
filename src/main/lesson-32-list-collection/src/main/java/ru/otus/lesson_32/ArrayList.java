package ru.otus.lesson_32;

public class ArrayList implements List {
    private Object[] elements = new Object[10];
    private int lastIdx = 0;

    @Override
    public boolean add(Object elem) {
        elements[lastIdx++] = elem;
        return true;
    }

    @Override
    public Object get(int idx) {
        return elements[idx]; // TODO: 19.09.2022 check
    }

    @Override
    public boolean contains(Object elem) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean remove(Object elem) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
