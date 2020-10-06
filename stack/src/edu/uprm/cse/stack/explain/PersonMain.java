package edu.uprm.cse.stack.explain;

public class PersonMain {

    public static void main(String[] argv){
        Person P1 = new Person("Jil", "Smith", 21);
        // Mutable - Bad Pattern!!!! Bad Idea!

        // You want Inmutable object
        System.out.println(P1);
        P1 = new Person(P1.getFirstName(), "Diaz", P1.getAge());
        System.out.println(P1);

    }
}
