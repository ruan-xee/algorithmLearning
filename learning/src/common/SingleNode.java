package common;

public class SingleNode{
    public int value;
    public SingleNode next;

    public SingleNode(){}

    public SingleNode(int value){
        this.value = value;
    }

    public SingleNode(int value, SingleNode next) {
        this.value = value;
        this.next = next;
    }
}
