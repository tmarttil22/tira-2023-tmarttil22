package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class QueueImplementation<E> implements QueueInterface<E> {

    private static final int DEFAULT_STACK_SIZE = 10;
    private Object [] itemArray;
    private int capacity;
    private int elementAmount = 0;
    private int head;
    private int tail;



    public QueueImplementation() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        capacity = DEFAULT_STACK_SIZE;
        elementAmount = 0;
        head = 0;
        tail = 0;
    }

    public QueueImplementation(int capacity) {
        itemArray = new Object[capacity ];
        this.capacity = capacity;
        elementAmount = 0;
        head = 0;
        tail = 0;
    }



    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("The element is null");
        }
        if (size() == capacity()) {
            allocateSpace();
        }
        itemArray[tail] = element; 
        tail = (tail + 1) % capacity(); // from chatGPT, propt used: "how would i make my own queue interface?" modified to use this classes capacity method
        elementAmount++; //  using modulus (%) makes the value "circle" around the array instead of going ovet the index limit
    }

    private void allocateSpace() {
        int newCapacity = capacity * 2;
        try {
            Object [] itemArrayNew = new Object[newCapacity];
            int currentSize = size();
            System.arraycopy(itemArray, head, itemArrayNew, 0, size() - head);
            System.arraycopy(itemArray, 0, itemArrayNew, size() - head, tail);

            capacity = newCapacity;
            head = 0;
            tail = currentSize;
            itemArray = itemArrayNew;
        } catch (OutOfMemoryError O) {
            throw new OutOfMemoryError("Couldn't add any more capacity");
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        E removed = (E)itemArray[head];
        itemArray[head] = null;
        head = (head + 1) % capacity(); //moves the head to the next element in the queue
        elementAmount--;
        return removed;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E element() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        return (E)itemArray[head];
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
        head = 0;
        tail = 0;
    }
    
    @Override
    public String toString() { //NOT CORRECT YET, FIGURE OUT (StackImplementation toString doesnt return correct result here)
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder str = new StringBuilder("[");
        int index = head;
        boolean firstElement = true;

        for (int i = 0; i < size(); i++) {
            if (!firstElement) {
                str.append(", ");
            }
            str.append(itemArray[index]);
            index = (index + 1) % capacity();
            firstElement = false;
        }

        str.append("]");
        return str.toString();
    }
}
