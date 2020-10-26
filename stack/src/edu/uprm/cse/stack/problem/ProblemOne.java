package edu.uprm.cse.stack.problem;

import edu.uprm.cse.stack.ArrayStack;
import edu.uprm.cse.stack.Stack;

import java.util.ArrayList;

public class ProblemOne {

    private static Integer findMax(ArrayStack<Integer> S){

        if (S.isEmpty()){
            return null;
        }
        else {
            Stack<Integer> T = new ArrayStack<>(20);
            Integer maxValue = S.top();
            Integer temp = 0;
            // 1st loop
            while(!S.isEmpty()){
                temp = S.pop();
                if (temp > maxValue){
                    maxValue = temp;
                }
                T.push(temp);
            }

            // second loop
            while (!T.isEmpty()){
                S.push(T.pop());
            }
            return maxValue;
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> S = new ArrayStack<>(20);
        S.push(47);
        S.push(-40);
        S.push(300);
        S.push(10);
        int max = findMax(S);
        System.out.printf("Max value : %d\n", max);
    }
}
