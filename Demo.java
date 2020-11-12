package hr.fer.oop.dz2.zad2;

import hr.fer.oop.dz2.zad1.IList;

public class Demo {
    public static void main(String ... args) {
        System.out.println("Idem koristiti ArrayBackedList");
        System.out.println("------------------------------");
        koristiKolekciju(new LinkedBackedList());
        System.out.println("Idem koristiti LinkedBackedList");
        System.out.println("-------------------------------");
        IList lista = koristiKolekciju(new LinkedBackedList());
        IList nova = new ArrayBackedList(lista);
        lista.insertAt(0, "Kristina");
        lista.insertAt(1, "Stjepan");
        System.out.println("Ispisujem listu");
        System.out.println("-------------------------------");
        ispisiKolekciju(lista);

        System.out.println("Ispisujem novu listu");
        System.out.println("-------------------------------");
        ispisiKolekciju(nova);
    }
    private static IList koristiKolekciju(IList lista) {
        System.out.println("Veličina je "+lista.size());
        lista.add("Ivana");
        System.out.println("Veličina je "+lista.size());
        System.out.println("Zadnji element je "+lista.get(lista.size()-1));
        lista.add("Branko");
        System.out.println("Veličina je "+lista.size());
        System.out.println("Zadnji element je "+lista.get(lista.size()-1));
        lista.add("Vesna");
        System.out.println("Veličina je "+lista.size());
        System.out.println("Zadnji element je "+lista.get(lista.size()-1));
        lista.add("Danko");
        System.out.println("Veličina je "+lista.size());
        System.out.println("Zadnji element je "+lista.get(lista.size()-1));
        lista.insertAt(1, "Anamari");
        System.out.println("Veličina je "+lista.size());
        System.out.println("Zadnji element je "+lista.get(lista.size()-1));
        lista.insertAt(1, "Marinko");
        System.out.println("Veličina je "+lista.size());
        System.out.println("Zadnji element je "+lista.get(lista.size()-1));
        ispisiKolekciju(lista);
        return lista;
    }
    private static void ispisiKolekciju(IList lista) {
        for(int i = 0, n = lista.size(); i < n; i++) {
            System.out.printf("Na poziciji %d nalazi se element %s.%n", i, lista.get(i));
        }
    }
}