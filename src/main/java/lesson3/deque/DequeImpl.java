package lesson3.deque;

public class DequeImpl<E> implements Deque<E> {

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;

    protected E[] data;

    protected int size;

    private int tail;
    private int head;

    @SuppressWarnings("unchecked")
    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if(head != 0){
            data[--head] = value;
            size++;
        } else {
            for (int i = tail; i >= 0; i--) {
                data[i + 1] = data[i];
            }
            data[0] = value;
            tail++;
            size++;
        }
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == lastIndex()) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E removedValue = data[head++];
        size--;
        return removedValue;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        E removedValue = data[tail--];
        size--;
        return removedValue;
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

    private int lastIndex() {
        return data.length - 1;
    }
}
