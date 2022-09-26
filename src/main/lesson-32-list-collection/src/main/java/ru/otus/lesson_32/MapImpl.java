package ru.otus.lesson_32;

public class MapImpl implements Map {
    private Entry head = new Entry(null, null, null);
    private Entry tail = head;

    @Override
    public boolean put(Object key, Object value) {
        Entry currEntry = head.nextEntry;

        while (currEntry != null) {
            if (currEntry.key.equals(key)) {
                currEntry.value = value;
                return true;
            }
            currEntry = currEntry.nextEntry;
        }

        Entry entry = new Entry(key, value, null);
        tail.nextEntry = entry;
        tail = entry;
        return true;
    }

    @Override
    public Object get(Object key) {
        Entry currEntry = head.nextEntry;

        while (currEntry != null) {
            if (currEntry.key.equals(key)) {
                return currEntry.value;
            }
            currEntry = currEntry.nextEntry;
        }

        return null;
    }

    private static class Entry {
        private final Object key;
        private Object value;
        private Entry nextEntry;

        private Entry(Object key, Object value, Entry nextEntry) {
            this.key = key;
            this.value = value;
            this.nextEntry = nextEntry;
        }
    }
}
