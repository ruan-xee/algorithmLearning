package common;

public class DoubleNode<T>{
    public T value;
    public DoubleNode<T> next;
    public DoubleNode<T> pre;

    public DoubleNode(){}

    public DoubleNode(T value) {
        this.value = value;
    }

    public DoubleNode(T value, DoubleNode<T> next, DoubleNode<T> pre) {
        this.value = value;
        this.next = next;
        this.pre = pre;
    }
}
