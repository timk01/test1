package ru.otus.lesson_32;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ListImplTest {

    @Test
    void add() {
        ru.otus.lesson_32.ListImpl list = new ru.otus.lesson_32.ListImpl();
        list.add(new Element("1st"));
        list.add(new Element("2nd"));

        System.out.println(list.toString());


    }

    @Test
    void contains() {
        ListImpl list = new ListImpl();
        list.add(new Element("1st"));
        list.add(new Element("2nd"));

        boolean checkContains = list.contains(new Element("1st"));

        assertTrue(checkContains);
    }

    @Test
    void testIteration() {
        ListImpl list = new ListImpl();
        list.add(new Element("1st"));
        list.add(new Element("2nd"));

        for (Object elem : list) {
            System.out.println(elem);
        }

        /*Iterable iterable;

        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
           Object elem =  iterator.next();
           //our logic here
        }*/
    }
}

class Element {
    private final String name;
    private List structures;

    Element(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(name, element.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}