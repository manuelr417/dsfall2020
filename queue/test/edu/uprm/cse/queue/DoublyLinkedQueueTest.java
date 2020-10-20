package edu.uprm.cse.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedQueueTest {

    private Queue<String> Q = new DoublyLinkedQueue<>();

    @Before
    public void setUp() throws Exception {
        this.Q.enqueue("Joe");
        this.Q.enqueue("Bob");
        this.Q.enqueue("Ned");

    }

    @Test
    public void size() {
        assertEquals("Size is not 3.", this.Q.size(), 3);
    }

    @Test
    public void isEmpty() {
        assertFalse("Q is empty clear!", this.Q.isEmpty());
        this.Q.clear();
        assertTrue("Q is not clear.", this.Q.isEmpty());
    }

    @Test
    public void front() {
        assertEquals("Joe is not at the front.", this.Q.front(), "Joe" );
    }

    @Test
    public void enqueue() {
        int oldSize = this.Q.size();
        this.Q.enqueue("Xi");
        assertEquals("size is not incremented.", this.Q.size(), oldSize );

    }

    @Test
    public void dequeue() {
        this.Q.enqueue("Xi");
        assertEquals("Xi is not at the front.", this.Q.front(), "Xi" );

    }

    @Test
    public void clear() {
    }

    @Test
    public void print() {
    }
}