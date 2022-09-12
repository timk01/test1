package ru.otus.lesson_16_array_struct.dynamic.array;

import DataStructure.DynamicArrayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DynamicArrayImplTest {

    private DynamicArrayImpl array;

    @BeforeEach
    void init() {
        array = new DynamicArrayImpl();
    }

    @Test
    void testInsert() {
/*        assertEquals(0, array.size());
        assertNull(array.get(0));
        assertNull(array.get(1));

        array.insert(5);
        assertEquals(1, array.size());
        assertEquals(5, array.get(0));
        assertNull(array.get(1));

        for (int i = 6; i < 12; i++) {
            array.insert(i);
        }

        assertEquals(7, array.size());
        for (int i = 1; i <= 6; i++) {
            assertEquals(5 + i, array.get(i));
        }
        assertNull(array.get(7));*/
    }

    @Test
    void testDelete() {
/*        array.insert(5);
        assertEquals(1, array.size());
        assertEquals(5, array.get(0));

        array.insert(3);
        assertEquals(2, array.size());
        assertEquals(3, array.get(1));

        array.insert(6);
        assertEquals(3, array.size());
        assertEquals(6, array.get(2));

        array.delete(1);

        assertEquals(2, array.size());
        assertEquals(5, array.get(0));
        assertEquals(6, array.get(1));*/
    }
}


