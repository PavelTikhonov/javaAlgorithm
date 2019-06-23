package lesson4.LinkIterator;

class LinkedList{
    private Link first;
    public LinkedList(){
        first = null;
    }
    public Link getFirst() {
        return first;
    }
    public void setFirst (Link first) {
        this.first = first;
    }
    public LinkInterator getIterator (){
        return new LinkInterator (this);
    }
    public boolean isEmpty(){
        return (first == null);
    }
    public void display(){
        Link current = first;
        while (current != null){
            current.display();
            current = current.next;
        }
    }
}
