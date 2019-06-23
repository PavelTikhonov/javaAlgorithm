package lesson3.deque;

public interface Deque<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();

    int size();

    boolean isEmpty();

    boolean isFull();
}
