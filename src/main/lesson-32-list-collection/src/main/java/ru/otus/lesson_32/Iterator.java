package ru.otus.lesson_32;

public interface Iterator extends java.util.Iterator<Object> {
    boolean hasNext();

    Object next();
}
