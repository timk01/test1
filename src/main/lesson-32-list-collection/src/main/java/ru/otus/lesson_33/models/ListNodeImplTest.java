package ru.otus.lesson_33.models;

import java.util.Arrays;

public class ListNodeImplTest {
    public static void main(String[] args) {
        ru.otus.lesson_33.models.LinkedListImpl<Integer> linkedList = new ru.otus.lesson_33.models.LinkedListImpl<>();
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.add(1));
        System.out.println(linkedList.add(2));
        linkedList.display();

        for (Integer item : linkedList) {
            System.out.println(item);
        }

    }
}
