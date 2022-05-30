package Task2;

public class Node<E> {
    protected E value;
    protected Node<E> next;

    public Node() {
    }

    public Node(final E value, final Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(final E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(final Node<E> next) {
        this.next = next;
    }
}
