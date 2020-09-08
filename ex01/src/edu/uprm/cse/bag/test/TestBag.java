package edu.uprm.cse.bag.test;

import edu.uprm.cse.bag.DynamicBag;
import edu.uprm.cse.bag.Bag;

public class TestBag {

    public static void main(String[] argv){

        Bag B = new DynamicBag();

        B.add("Joe");
        B.add("Ned");
        B.add("Jim");
        B.add("Joe");
        B.add("Ned");
        B.add("Ned");
        B.add("Ron");

        printBag(B);
        System.out.println("B.count(Joe)" + B.count("Joe"));
        System.out.println("B.count(Ned)" + B.count("Ned"));
        System.out.println("B.count(Jim)" + B.count("Jim"));
        System.out.println("B.count(Kim)" + B.count("Kim"));

        System.out.println("B.isMember(Ned)" + B.isMember("Ned"));

        int n = B.removeAll("Ned");
        System.out.println("B.isMember(Ned)" + B.isMember("Ned"));
        System.out.println("B.count(Ned)" + B.count("Ned"));
        printBag(B);

        System.out.println("B.count(100)");

        B.add(100);
        printBag(B);


    }

    private static void printBag(Bag b) {
        Object[] A = b.toArray();

        for (Object a : b.toArray()){
            System.out.print(a);
            System.out.print(" ");

        }
        System.out.println();
    }
}
