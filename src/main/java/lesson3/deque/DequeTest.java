package lesson3.deque;

import java.util.Arrays;

public class DequeTest<E> {

    @SuppressWarnings("unchecked")
    public boolean stackTest(E[] arr, int dequeSize){
        Deque<E> deque = new DequeImpl<>(dequeSize);

        for (E e : arr) {
            if (deque.isFull()) {
                throw new RuntimeException("stack is full");
            } else {
                deque.insertRight(e);
            }
        }

        E[] arrOut = (E[]) new Object[deque.size()];
        for (int i = arrOut.length - 1; i >= 0; i--) {
            arrOut[i] = deque.removeRight();
        }
        if (Arrays.equals(arr, arrOut)){
            return true;
        }else {
            return false;
        }
    }


    @SuppressWarnings("unchecked")
    public boolean queueTest(E[] arr, int dequeSize){
        Deque<E> deque = new DequeImpl<>(dequeSize);

        for (E e : arr) {
            if (deque.isFull()) {
                throw new RuntimeException("queue is full");
            } else {
                deque.insertRight(e);
            }
        }

        E[] arrOut = (E[]) new Object[deque.size()];
        for (int i = 0; i < arrOut.length - 1; i++) {
            arrOut[i] = deque.removeRight();
        }
        if (Arrays.equals(arr, arrOut)){
            return true;
        }else {
            return false;
        }
    }

}
