package edu.uprm.cse.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListStackTest {
    private Stack<String> S;

    @Before
    public void setUp() throws Exception {
        //this.S = new SinglyLinkedListStack<String>();
        this.S = new ArrayStack<String>(20);

        S.push("Joe");
        S.push("Bob");
        S.push("Ned");
    }

    @Test
    public void size() {
        assertTrue("Fails to returnn size 3", this.S.size() == 3);
    }

    @Test
    public void isEmpty() {
        assertTrue("Fails to returnn size 3", this.S.size() == 3);
        S.clear();
        assertTrue("Fails to returnn size 0", this.S.size() == 0);

    }

    @Test
    public void top() {
        String top = S.top();
        assertEquals("Fails to return Ned", top, "Ned");
    }

    @Test
    public void pop() {
        String e = S.pop();
        assertEquals("Fails to return Ned", e, "Ned");
        assertTrue("Fails to returnn size 2", this.S.size() == 2);
    }

    @Test
    public void push() {
        this.S.push("Tom");
        assertEquals("Fails to return Tom", S.top(), "Tom");
        assertTrue("Fails to returnn size 4", this.S.size() == 4);
    }

    @Test
    public void clear() {
        assertTrue("Fails to returnn size 3", this.S.size() == 3);
        this.S.clear();
        assertTrue("Fails to returnn size 0", this.S.size() == 0);

    }

    @Test
    public void print() {
        this.S.print(System.out);
        this.S.push("Amy");
        System.out.println();
        this.S.print(System.out);

    }
}