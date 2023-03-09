package common;

public class SingleNode<T>{
    public T value;
    public SingleNode<T> next;

    public SingleNode(){}

    public SingleNode(T value){
        this.value = value;
    }

    public SingleNode(T value, SingleNode<T> next) {
        this.value = value;
        this.next = next;
    }
}
