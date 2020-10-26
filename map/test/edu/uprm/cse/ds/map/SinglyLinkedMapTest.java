package edu.uprm.cse.ds.map;

import edu.uprm.cse.ds.list.List;
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

        String value = this.M.get("0001");
        assertEquals("Cannot find key pair (0001, Joe Smith)", value, "Joe Smith");
        value  = this.M.get("0020");
        assertTrue("Fails to detect that no key pair has key 0020.", value == null);

    }

    @Test
    public void put() {
        String value = this.M.get("0020");
        assertTrue("Fails to detect that no key pair has key 0020.", value == null);
        this.M.put("0020", "Tito Kayak");
        value = M.get("0020");
        assertEquals("Cannot find key pair (0020, Tito Kayak)", value, "Tito Kayak");
    }

    @Test
    public void remove() {
        String value = this.M.get("0001");
        assertEquals("Cannot find key pair (0001, Joe Smith)", value, "Joe Smith");
        value = this.M.remove("0001");
        assertEquals("Cannot detect removal key pair (0001, Joe Smith)", value, "Joe Smith");
        value = this.M.get("0001");
        assertTrue("Fails to detect that no key pair has key 0001.", value == null);

    }

    @Test
    public void contains() {
        assertTrue("Cannot find key pair (0001, Joe Smith)", this.M.contains("0001"));
        assertFalse("Fails to detect that no key pair has key 0020.", this.M.contains("0020"));

    }

    @Test
    public void clear() {
        assertEquals("Fails to detect that map has 4 entries.", 4, this.M.size());
        this.M.clear();
        assertEquals("Fails to detect that cleared map has 0 entries.", 0, this.M.size());

    }

    @Test
    public void getKeys() {
        List<String> L = this.M.getKeys();
        assertEquals("Fails to detect that there are 4 keys", 4, L.size());
        assertTrue("Fails to detect key 0001 in map.", L.isMember("0001"));
        assertTrue("Fails to detect key 0002 in map.", L.isMember("0002"));
        assertTrue("Fails to detect key 0003 in map.", L.isMember("0003"));
        assertTrue("Fails to detect key 0010 in map.", L.isMember("0010"));

    }

    @Test
    public void getValues() {
        List<String> L = this.M.getValues();
        assertEquals("Fails to detect that there are 4 values", 4, L.size());
        assertTrue("Fails to detect value Joe Smith in map.", L.isMember("Joe Smith"));
        assertTrue("Fails to detect value Ken Diaz in map.", L.isMember("Ken Diaz"));
        assertTrue("Fails to detect value Tim Li in map.", L.isMember("Tim Li"));
        assertTrue("Fails to detect value Amy Ortiz in map.", L.isMember("Amy Ortiz"));


    }
}