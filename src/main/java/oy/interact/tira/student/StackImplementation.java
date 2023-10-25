package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E>{

    private static final int DEFAULT_STACK_SIZE = 10;
    private Object [] itemArray;
    private int capacity;
    private int nullElementAmount;



    public StackImplementation() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        capacity = DEFAULT_STACK_SIZE;
        nullElementAmount = DEFAULT_STACK_SIZE;
    }

    public StackImplementation(int cap) {
        itemArray = new Object[cap];
        capacity = cap;
        nullElementAmount = cap;
    }



    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        try {
            if (element == null) {
                throw new NullPointerException();
            }
            int currentIndex = size();
            if (currentIndex == capacity()) {
                allocateSpace();
            }
            itemArray[currentIndex] = element;
            nullElementAmount--;
        } catch (OutOfMemoryError O){
            throw new OutOfMemoryError("Couldn't add capacity");
        }
    }

    private void allocateSpace() {
        int newCapacity = capacity * 2;
        nullElementAmount = newCapacity - size();
        try {
            Object [] itemArrayNew = new Object[newCapacity];
            System.arraycopy(itemArray, 0, itemArrayNew, 0, size());
            itemArray = itemArrayNew;
            capacity = newCapacity;
        } catch (OutOfMemoryError O) {
            throw new OutOfMemoryError("Couldn't add any more capacity");
        }

    }
    @SuppressWarnings("unchecked")
    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The array is empty");
        }
        int currentIndex = size();
        E latest = (E)itemArray[size() - 1];
        itemArray[currentIndex] = null;
        return latest;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The array is empty");
        }
        return (E)itemArray[size() - 1];
    }

    @Override
    public int size() {
        return itemArray.length - nullElementAmount;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        Object[] clearedItemArray = new Object[DEFAULT_STACK_SIZE];
        itemArray = clearedItemArray;
        nullElementAmount = DEFAULT_STACK_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            str.append(itemArray[i]);
            if (i < size() - 1) {
                str.append(", ");
            }
        }
        str.append("]");
        String result = str.toString();
        return result;
    }
}
