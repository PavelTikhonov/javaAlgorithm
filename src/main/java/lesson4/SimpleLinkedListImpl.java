package lesson4;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {





    protected Entry<E> firstElement;//001[005]
    protected int size;

    @Override//O(1)
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);//002[007]
        entry.next = firstElement;//007[...next->005]
        firstElement = entry;//001[007]
        size++;
    }

    @Override//O(1)
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E removedValue = this.firstElement.value;
        firstElement = firstElement.next;
        size--;
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> previous = null;
        Entry<E> current = firstElement;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {//previous == null
            firstElement = firstElement.next;//current.next
        }
        else {
            previous.next = current.next;
        }

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println("----------");
        Entry<E> current = firstElement;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("----------");
    }

    @Override
    public E getFirstElement() {
        return firstElement.value;
    }

    @Override
    public Entry getFirst() {
        return firstElement;
    }

}
