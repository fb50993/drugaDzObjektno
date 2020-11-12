package hr.fer.oop.dz2.zad2;

import hr.fer.oop.dz2.zad1.IList;
import hr.fer.oop.dz2.zad3.ICursor;

import java.util.NoSuchElementException;

public class ArrayBackedList implements IList {

    private String[] elementi;

    {
        elementi = new String[2];
    }

    private int size;

    public ArrayBackedList () {
        elementi = new String[2];
        size = 0;
    }

    public ArrayBackedList(IList list) {
        while(elementi.length < list.size()) {
            elementi = new String[elementi.length * 2];
        }
        for(int i=0; i<list.size(); i++) {
            elementi[i] = list.get(i);
        }
        size = list.size();
    }

    public ArrayBackedList(String prvi, String ... ostali) {
        while(elementi.length < ostali.length + 1) {
            elementi = new String[elementi.length * 2];
        }
        elementi[0] = prvi;
        int i = 1;
        size = 1;
        for(String s : ostali) {
            elementi[i] = s;
            i++;
            size++;
        }
    }

    private static class Cursor implements ICursor{

        private static String[] elementiKursora;
        private int position;

        public Cursor(String[] elementi) {
            elementiKursora = new String[elementi.length];
            for(int i=0; i<elementi.length; i++) {
                elementiKursora[i] = elementi[i];
            }
            position=0;
        }

        @Override
        public boolean hasNext() {
            return ((position+1) <= elementiKursora.length);
        }

        @Override
        public String getNext() {
            if(position >= elementiKursora.length) {
                throw new NoSuchElementException(String.format("Ne postoji sljedeci element."));
            }
            else {
                position++;
                return elementiKursora[position-1];
            }
        }

        public String getCurrent() {
            return elementiKursora[position];
        }
    }

    @Override
    public ICursor createCursor() {
        return new Cursor(this.elementi);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insertAt(int index, String value) {
        if(size == elementi.length){
            String[] temp = elementi;
            elementi = new String[2*size];
            size = 0;
            int i=0;
            for(String s : temp) {
                elementi[i] = s;
                i++;
                size++;
            }
        }
        String[] novi = new String[size + 1];
        for(int i=0; i<index; i++) {
            novi[i] = elementi[i];
        }
        novi[index] = value;
        for(int i=index+1; i<novi.length; i++) {
            novi[i] = elementi[i-1];
        }
        elementi = novi;
        size++;
    }

    @Override
    public void replace(int index, String value) {
        elementi[index] = value;
    }

    @Override
    public String get(int index) {
        return elementi[index];
    }

    @Override
    public void clear() {
        elementi = new String[2];
        size = 0;
    }

    @Override
    public String remove(int index) {
        String el = elementi[index];
        String[] novi = new String[elementi.length-1];
        for(int i=0; i<index; i++) {
            novi[i] = elementi[i];
        }
        for(int i=index; i<novi.length; i++) {
            novi[i] = elementi[i+1];
        }
        elementi = novi;
        size--;
        return el;
    }
}
