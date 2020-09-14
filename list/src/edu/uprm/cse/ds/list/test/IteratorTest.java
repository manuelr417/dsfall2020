package edu.uprm.cse.ds.list.test;


import java.util.Iterator;
import edu.uprm.cse.ds.list.ArrayList;
public class IteratorTest {

    public static void main(String[] argv) {
        String[] names = {"Jil", "Joe", "Ned", "Amy", "Tom"};
        System.out.println("For regular");
        for (int i=0; i < names.length; ++i){
            System.out.print(names[i] + " ");
        }
        System.out.println();
        System.out.println("For each");
        for (String s : names) {
            System.out.print(s + " ");
        }
        System.out.println();

        ArrayList<String> L = new ArrayList<>();
        L.add("Jil");
        L.add("Joe");
        L.add("Ned");
        L.add("Amy");
        L.add("Tom");
        System.out.println("For regular");
        for (int i=0; i < L.size(); ++i){
            System.out.print(L.get(i) + " ");
        }

        System.out.println();
        System.out.println("For each");
        for (String s : L){
            System.out.print(s + " ");
        }
        System.out.println("\nOld way of iteration ");
        Iterator<String> I = L.iterator();
        String s = null;
        while (I.hasNext()){
            s = I.next();
            System.out.print(s + " ");
        }

    }
}
