package lesson4.LinkIterator;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkInterator itr = new LinkInterator(list);
        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        list.display();

        itr.getCurrent().display();
        itr.deleteCurrent();
        itr.getCurrent().display();


    }
}