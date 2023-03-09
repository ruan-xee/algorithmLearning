package common;

public class RandNode<T> {
    public T value;
    public RandNode<T> next;
    public RandNode<T> rand;

    public RandNode() {
    }

    public RandNode(T value) {
        this.value = value;
    }
}
