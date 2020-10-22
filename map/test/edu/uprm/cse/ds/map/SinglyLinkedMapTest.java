package edu.uprm.cse.ds.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedMapTest {

    private Map<String, String> M = new SinglyLinkedMap<>();

    @Before
    public void setUp() throws Exception {
        M.put("0001", "Joe Smith");
        M.put("0002", "Ken Diaz");
        M.put("0003", "Tim Li");
        M.put("0010", "Amy Ortiz");
    }

    @Test
    public void size() {
        assertEquals("Fails to detect size of 4", 4, this.M.size());
    }

    @Test
    public void isEmpty() {
        assertFalse("Fails to detect non empty Map", this.M.isEmpty());
        this.M.clear();
        assertTrue("Fails to detect  empty Map", this.M.isEmpty());
    }

    @Test
    public void get() {
    }

    @Test
    public void put() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void getKeys() {
    }

    @Test
    public void getValues() {
    }
}