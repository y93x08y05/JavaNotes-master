package com.jack.algorithm.chain.chainDefinition;

public class Node {
    Object element;
    Node next;
    public Node(Node next){
        this.next = next;
    }
    public Node(Object obj, Node next) {
        this.element = obj;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public String toString() {
        return this.element.toString();
    }
}