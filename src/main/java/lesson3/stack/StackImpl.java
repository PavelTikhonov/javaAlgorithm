package lesson3.stack;

public class StackImpl<E> implements Stack<E> {

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    @Override//O(1)
    public void push(E value) {
        data[size++] = value;
    }

    @Override//O(1)
    public E pop() {
        return data[--size];
    }

    @Override//O(1)
    public E peek() {
        return data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
