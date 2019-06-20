package lesson4.iterator;

import lesson4.SimpleLinkedListImpl;

import java.util.Iterator;
import java.util.LinkedList;

public class TestIterator {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        for (int i = 0; hasNext(array, i); i++) {
            int value = next(array, i);
            System.out.println(value);
        }

        System.out.println("---");

        for (int value : array) {
            System.out.println(value);
        }
        System.out.println("---");

        lesson4.LinkedList<Integer> linkedList = new SimpleLinkedListImpl();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);

//        for (Integer value : linkedList) {
//            System.out.println(value);
//        }

        lesson4.LinkedList.Entry current = linkedList.getFirst();
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("---");


        LinkedList<Integer> linkedListJdk = new LinkedList<>();
        linkedListJdk.add(1);
        linkedListJdk.add(2);
        linkedListJdk.add(3);

        for (Integer value : linkedListJdk) {
            System.out.println(value);
        }

        Iterator<Integer> iterator = linkedListJdk.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }


        System.out.println("---");
    }

    private static int next(int[] array, int i) {
        return array[i];
    }

    private static boolean hasNext(int[] array, int i) {
        return i < array.length;
    }
}
