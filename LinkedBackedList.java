package hr.fer.oop.dz2.zad2;

import hr.fer.oop.dz2.zad1.IList;
import hr.fer.oop.dz2.zad3.ICursor;

import java.util.NoSuchElementException;

public class LinkedBackedList implements IList{

    private static Node head;
    private int size;

    public LinkedBackedList() {
        head = new Node();
        size = 0;
    }

    public LinkedBackedList(IList list) {
        head = new Node (list.get(0), new Node());
        size = 1;
        Node temp = head.getNextNode();
        for(int i=1; i<list.size(); i++) {
            temp.setValue(list.get(i));
            temp = temp.getNextNode();
            size++;
        }
    }

    public LinkedBackedList(String prvi, String ... ostali) {
        head = new Node(prvi, new Node());
        size = 1;
        Node temp = head.getNextNode();
        for (String s : ostali) {
            temp.setValue(s);
            temp = temp.getNextNode();
            size++;
        }
    }

    private static class Cursor implements ICursor {
        private Node trenutni;

        public Cursor() {
            this.trenutni = LinkedBackedList.head;
        }

        @Override
        public boolean hasNext() {
            return (trenutni != null);
        }

        @Override
        public String getNext() {
            if(!hasNext()) {
                throw new NoSuchElementException(String.format("Ne postoji sljedeci element."));
            }
            else {
                String ret = trenutni.getValue();
                trenutni=trenutni.getNextNode();
                return ret;
            }
        }
    }
    @Override
    public ICursor createCursor() {
        return new Cursor();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insertAt(int index, String value) {
        if(size == 0) {
            head = new Node(value);
            size++;
            return;
        }
        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.getNextNode();
        }
        Node prethodni = temp;
        if(prethodni.getNextNode() == null) {
            prethodni.setNextNode(new Node(value));
        }
        else {
            Node sljedeci = temp.getNextNode();
            Node trenutni = new Node(value, sljedeci);
            prethodni.setNextNode(trenutni);
        }
        size++;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNextNode();
        }
    }

    @Override
    public void replace(int index, String value) {
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.getNextNode();
        }
        temp.setValue(value);
    }

    @Override
    public String get(int index) {
        int i=0;
        Node temp = head;
        while(temp.getNextNode() != null && i<index) {
            temp = temp.getNextNode();
            i++;
        }
        if(temp == null) {
            return "This node is null.";
        }
        return temp.getValue();
    }

    @Override
    public void clear() {
        Node temp = head;
        for(int i=0; i<size; i++) {
            temp.setValue("");
            temp = temp.getNextNode();
        }
    }

    @Override
    public String remove(int index) {
        String ret = "";
        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.getNextNode();
        }
        ret = temp.getNextNode().getValue();
        if(temp.getNextNode() != null) {
            temp.setNextNode(temp.getNextNode().getNextNode());
        }
        else {
            temp.setNextNode(null);
        }
        size--;
        return ret;
    }
}
