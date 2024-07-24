package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {

    private static final int DEFAULT_STACK_SIZE = 10;
    private Object[] itemArray;
    private int capacity;
    private int elementAmount = 0;

    public StackImplementation() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        capacity = DEFAULT_STACK_SIZE;
        elementAmount = 0;
    }

    public StackImplementation(int cap) {
        itemArray = new Object[cap];
        capacity = cap;
        elementAmount = 0;
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
            elementAmount++;

        } catch (OutOfMemoryError O) {
            throw new OutOfMemoryError("Couldn't add capacity");
        }
    }

    private void allocateSpace() {
        int newCapacity = capacity * 2;
        try {
            Object[] itemArrayNew = new Object[newCapacity];
            int currentSize = size();

            System.arraycopy(itemArray, 0, itemArrayNew, 0, currentSize);

            capacity = newCapacity;
            itemArray = itemArrayNew;
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
        if (elementAmount == 0) {
            throw new IllegalStateException("all elements in the array are null, nothing to pop");
        }
        int currentIndex = size() - 1;
        E latest = (E) itemArray[currentIndex];
        itemArray[currentIndex] = null;
        elementAmount--;
        return latest;

    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The array is empty");
        }
        return (E) itemArray[size() - 1];
    }

    @Override
    public int size() {
        return elementAmount;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        Object[] clearedItemArray = new Object[DEFAULT_STACK_SIZE];
        itemArray = clearedItemArray;
        elementAmount = 0;
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
        return str.toString();
    }
}
