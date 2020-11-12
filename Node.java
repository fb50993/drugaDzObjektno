package hr.fer.oop.dz2.zad2;

public class Node {
    private String value;
    private Node nextNode;


    public Node(Node old) {
        this.value = old.value;
        this.nextNode = old.nextNode;
    }

    public Node() {
        this.value = "";
        this.nextNode = null;
    }

    public Node(String value) {
        this.value = value;
        this.nextNode = null;
    }

    public Node(String value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public String getValue() {
        return value;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
