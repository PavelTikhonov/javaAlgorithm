package lesson2;

import java.util.Arrays;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    private static final int INITIAL_CAPACITY = 16;

    protected E[] data;
    protected int size;

    public ArrayImpl() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    //О(N)
    public void add(E value) {
        checkGrow();
        data[size++] = value;
    }

    protected void checkGrow() {
        if (size == data.length) {
            data = grow();
        }
    }

    private E[] grow() {
        return Arrays.copyOf(data, data.length * 2);
    }

    @Override
    //О(1)
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidArrayStateException(index, size);
        }
    }

    @Override
    //О(N)
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }

        return -1;
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
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void sortBubble() {
        long time = System.nanoTime() / 1000000;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
        System.out.println("sortBubble time = " + (System.nanoTime() / 1000000 - time) + " ms");
}

    private void swap(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    @Override
    public void sortSelect() {
        long time = System.nanoTime() / 1000000;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(i, minIndex);
        }
        System.out.println("sortSelect time = " + (System.nanoTime() / 1000000 - time) + " ms");
    }

    @Override
    public void sortInsert() {
        long time = System.nanoTime() / 1000000;
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
        System.out.println("sortSelect time = " + (System.nanoTime() / 1000000 - time) + " ms");
    }

    public E[] getAll(){
        return data;
    }

    public void copy(E[] data){
        for (E datum : data) {
            this.add(datum);
        }
    }
}
