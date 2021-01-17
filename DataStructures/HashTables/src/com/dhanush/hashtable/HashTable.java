package com.dhanush.hashtable;

import java.util.LinkedList;

public class HashTable<K, V> {
    private class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key +"=" + value;
        }
    }

    private final LinkedList<Entry>[] entries = new LinkedList[5];
    private int size = 0;

    public void put (K key, V value) {
        int index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        LinkedList<Entry> bucket = entries[index];

        for (Entry entry : bucket)
            if (entry.key == key) {
                entry.value = value;
                return;
            }

        bucket.addLast(new Entry(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];

        if(bucket != null)
            for (Entry entry : bucket)
                if (entry.key == key)
                    return entry.value;

        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];

        if (bucket == null) {
            String errorMessage = "No value found at key : " + key.toString();
            throw new IllegalStateException(errorMessage);
        }

        for (Entry entry : bucket)
            if (entry.key == key) {
                bucket.remove(entry);
                size--;
                return;
            }

        String errorMessage = "No value found at key : " + key.toString();
        throw new IllegalStateException(errorMessage);
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];
        if (bucket == null)
            return false;
        else
            for (Entry entry : bucket)
                if (entry.key == key)
                    return true;
        return false;
    }

    public boolean containsValue(V value) {
        for (LinkedList<Entry> list : entries)
            for (Entry entry : list)
                if (entry.value == value)
                    return true;
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return key.hashCode() % entries.length;
    }

    @Override
    public String toString() {
        LinkedList<Entry> toString = new LinkedList<>();
        for (LinkedList<Entry> entryLinkedList : entries) {
            if (entryLinkedList != null)
                for (Entry entry : entryLinkedList)
                    toString.addLast(entry);
        }

        return "Items : " + toString.toString()
                + "\nSize : " + size ;
    }
}
