package ru.otus.lesson_32;

public interface Queue {
    boolean add(Object elem);

    Object remove();

    Object poll(); //work with tail

    Object peek(); //work with tail
}
