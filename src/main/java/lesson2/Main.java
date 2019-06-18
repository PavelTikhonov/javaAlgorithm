package lesson2;

import java.util.Arrays;

public class Main {

    private static final int INITIAL_CAPACITY = 100000;

    public static void main(String[] args) {

        Array<Integer> array = new ArrayImpl<>(INITIAL_CAPACITY);
        Array<Integer> arrayCopy1 = new ArrayImpl<>();
        Array<Integer> arrayCopy2 = new ArrayImpl<>();
        Array<Integer> arrayCopy3 = new ArrayImpl<>();

        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            array.add((int) (Math.random() * 1000));
        }

        arrayCopy1.copy(array.getAll());
        arrayCopy2.copy(array.getAll());
        arrayCopy3.copy(array.getAll());
        System.out.println("Copy is complete");
        //array.display();

        arrayCopy1.sortBubble();
        arrayCopy2.sortInsert();
        arrayCopy3.sortSelect();
    }

}
