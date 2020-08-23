package edu.uprm.cse.bag.test;

public class TestMasi {

    public  static void main(String[] argv){
        int i=0, flag =0;

        i = 10;

        flag = i++;
        // ver/usar el valor i
        // i = i + 1

        System.out.println("i: " + i);
        System.out.println("flag: " + flag);

        System.out.println();

        i = 10;
        flag = ++i;
        // i = i + 1
        // ver/usar el valor i
        System.out.println("i: " + i);
        System.out.println("flag: " + flag);


    }
}
