package oy.interact.tira.student;

import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

public class HashTableContainer<K extends Comparable<K>, V> implements TIRAKeyedContainer<K, V> {

    private Pair<K, V>[] array;
    private int elementAmount;
    private int collisionCount;
    private final int TABLE_SIZE = 100;

    @SuppressWarnings("unchecked")
    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (array == null) {
            array = (Pair<K, V>[]) new Pair[TABLE_SIZE];
        } else if (size() >= Double.valueOf(capacity()) * 0.75) {
            ensureCapacity(array.length * 2);
        }
        Pair<K, V> keyValue = new Pair<>(key, value);
        int i = 0;
        while (i < capacity()) {
            int hashValue = key.hashCode() + i;
            int index = (hashValue & 0x7fffffff) % array.length; // Luentomateriaali

            if (array[index] == null) {
                array[index] = keyValue;
                elementAmount++;
                return;
            } else if (key.equals(array[index].getKey())) {
                array[index] = keyValue;
                return;
            }
            // if the code reaches this point, there already was an element in the current
            // index with a different hashcode, ie. there has been a collision
            collisionCount++;
            i++;
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        // Check for this, because CodeWordsCounter doesn't add an element before trying
        // to get one, and then the array is always null
        if (array == null) { 
            array = (Pair<K, V>[]) new Pair[TABLE_SIZE];
        }
        int i = 0;
        int hashValue = key.hashCode() + i;
        int index = (hashValue & 0x7fffffff) % array.length;
        while (i < capacity()) {
            Pair<K, V> pair = array[index];
            if (pair == null) {
                return null;
            }
            if (key.equals(pair.getKey())) {
                return pair.getValue();
            }
            i++;
            hashValue = key.hashCode() + i;
            index = (hashValue & 0x7fffffff) % array.length;
        }
        return null;
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        for (int i = 0; i < capacity(); i++) {
            if (array[i] != null) {
                if (searcher.test(array[i].getValue())) {
                    return array[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementAmount;
    }

    // returns the amount of collisions
    public int collision() {
        return collisionCount;
    }

    @Override
    public int capacity() {
        return array.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        Pair<K, V>[] newArray = (Pair<K, V>[]) new Pair[capacity];

        for (int i = 0; i < array.length; i++) {
            int j = 0;
            while (j < capacity) {
                if (array[i] != null) {
                    K key = array[i].getKey();
                    int hashValue = key.hashCode() + j;
                    int index = (hashValue & 0x7fffffff) % capacity;
                    if (newArray[index] == null) {
                        newArray[index] = array[i];
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
        }
        this.array = newArray;
    }

    @Override
    public void clear() {
        Pair<K, V>[] newArray = null;
        this.array = newArray;
        elementAmount = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Pair<K, V>[] toArray() throws Exception {
        Pair<K, V>[] result = new Pair[size()];
        int index = 0;
        for (Pair<K, V> element : array) {
            if (element != null) {
                result[index++] = element;
            }
        }
        return result;
    }

}
