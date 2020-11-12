package hr.fer.oop.dz2.zad1;

import hr.fer.oop.dz2.zad3.ICursor;
import hr.fer.oop.dz2.zad4.IStringProcessor;

public interface IList {

    default void forEach(IStringProcessor p) {
        ICursor c = createCursor();
        while(c.hasNext()) {
            p.process(c.getNext());
        }
    }

    ICursor createCursor();

    int size();

    default boolean isEmpty(){
        return size() == 0;
    }

    default void add(String value){
        insertAt(size(), value);
    }

    void insertAt(int index, String value);

    void replace(int index, String value);

    String get(int index);

    void clear();

    String remove(int index);

}
