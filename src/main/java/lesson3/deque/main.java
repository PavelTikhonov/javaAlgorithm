package lesson3.deque;

public class main {
    public static void main(String[] args) {

        Deque<Integer> deque = new DequeImpl<>(5);
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertRight(5);
        deque.insertRight(5);
        deque.insertLeft(5);
        deque.removeLeft();
        deque.insertLeft(6);

        while (!deque.isEmpty()){
            System.out.println(deque.removeRight());
        }


        String str = "Keep calm and code java";
        Deque<Character> stringDeque = new DequeImpl<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            stringDeque.insertRight(str.charAt(i));
        }
        System.out.println(str);
        while (!stringDeque.isEmpty()){
            System.out.print(stringDeque.removeRight());
        }
    }
}
