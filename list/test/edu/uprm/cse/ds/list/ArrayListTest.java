package edu.uprm.cse.ds.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    private List<String> L;
    @Before
    public void setUp() throws Exception {
        L = new ArrayList<>();
        L.add("Joe");
        L.add("Ned");
        L.add("Kim");

    }

    @Test
    public void size() {
        int expectedSize = L.size();
        assertEquals("size()-> fails to return 3 on L = {Joe, Ned, Kim}", expectedSize, 3);
    }

    @Test
    public void isEmpty() {
        assertTrue("isEmpty() -> fails to get size of 3 in L = {Joe, Ned, Kim}", L.size() == 3);
        this.L.clear();
        System.out.println("size after erase: " + L.size());
        assertTrue("isEmpty() -> fails to get size of 0 in L = {}", L.size() == 0);

    }

    @Test
    public void isMember() {
        assertTrue("isMember() -> fails to detect Joe as member L = {Joe, Ned, Kim}",
                L.isMember("Joe"));
        assertFalse("isMember() -> fails to detect that Apu is not  member L = {Joe, Ned, Kim}",
                L.isMember("Apu"));
    }

    @Test
    public void firstIndex() {
    }

    @Test
    public void lastIndex() {
    }

    @Test
    public void add() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void get() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void replace() {
        L.replace(0, "Xi");
        System.out.println("L.get(0): " + L.get(0));
        assertEquals("replace()-> fails to have Xi in position 0", L.get(0), "Xi");
    }

    @Test
    public void clear() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void set() {
    }
}