package edu.uprm.cse.set.test;

import edu.uprm.cse.set.ArraySet;
import edu.uprm.cse.set.BagbasedSet;
import edu.uprm.cse.set.Set;

public class SetTest {

    public static void main(String[] argv){
        Set<String> S1 = null;
        Set<String> S2 = null;
        Set<String> S3 = null;

        S1 = buildSet(1);
        S2 = buildSet(1);

        S1.add("Joe");
        S1.add("Ned");
        S1.add("Amy");
        S1.add("Kim");

        S2.add("Joe");
        S2.add("Jil");
        S2.add("Bob");
        S2.add("Ron");
        S2.add("Al");
        S2.add("Kim");

        System.out.println("S1");
        S1.print(System.out);
        System.out.println("S2");
        S2.print(System.out);

        S1.add("Joe");
        S1.add("Joe");
        S1.add("Ned");
        System.out.println("S1");
        S1.print(System.out);



        S3 = S1.union(S2);
        System.out.println("S3=S1.union(S2)");
        S3.print(System.out);

        S3 = S1.intersection(S2);
        System.out.println("S3 = S1.interseciont(S2)");
        S3.print(System.out);
        System.out.println("S3 is empty: "+ S3.isEmpty());

        S3 = S1.difference(S2);
        System.out.println("S3 = S1.difference(S2)");
        S3.print(System.out);
        System.out.println("S3 is empty: "+ S3.isEmpty());

        S3 = S2.difference(S1);
        System.out.println("S3 = S2.difference(S1)");
        S3.print(System.out);
        System.out.println("S3 is empty: "+ S3.isEmpty());

        S1.remove("Kim");
        S1.remove("Joe");
        System.out.println("S1");
        S1.print(System.out);



    }

    private static Set<String> buildSet(int i) {

        if (i == 0){
            return new ArraySet<String>();
        }
        else {
            return new BagbasedSet<String>();
        }
    }
}
