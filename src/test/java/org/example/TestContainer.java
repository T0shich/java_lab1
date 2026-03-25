package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestContainer {

    @Test
    void testAddFirstAndGetByIndex() {
        Container<Integer> container = new Container<>();
        container.addFirst(10);
        container.addFirst(5);
        
        assertEquals(5, container.getByIndex(0));
        assertEquals(10, container.getByIndex(1));
        assertEquals(2, container.getSize());
    }

    @Test
    void testAddLastAndGetByIndex() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        container.addLast(20);
        
        assertEquals(10, container.getByIndex(0));
        assertEquals(20, container.getByIndex(1));
        assertEquals(2, container.getSize());
    }

    @Test
    void testAddByIndex() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        container.addLast(30);
        container.addByIndex(1, 20);
        
        assertEquals(10, container.getByIndex(0));
        assertEquals(20, container.getByIndex(1));
        assertEquals(30, container.getByIndex(2));
        assertEquals(3, container.getSize());
    }

    @Test
    void testAddByIndexAtStart() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        container.addByIndex(0, 5);
        
        assertEquals(5, container.getByIndex(0));
        assertEquals(10, container.getByIndex(1));
        assertEquals(2, container.getSize());
    }

    @Test
    void testAddByIndexOutOfBounds() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        
        assertThrows(IndexOutOfBoundsException.class, () -> container.addByIndex(5, 20));
        assertThrows(IndexOutOfBoundsException.class, () -> container.addByIndex(-1, 20));
    }

    @Test
    void testRemoveFirst() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        container.addLast(20);
        container.addLast(30);
        
        container.removeFirst();
        
        assertEquals(20, container.getByIndex(0));
        assertEquals(30, container.getByIndex(1));
        assertEquals(2, container.getSize());
    }

    @Test
    void testRemoveLast() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        container.addLast(20);
        container.addLast(30);
        
        container.removeLast();
        
        assertEquals(10, container.getByIndex(0));
        assertEquals(20, container.getByIndex(1));
        assertEquals(2, container.getSize());
    }

    @Test
    void testRemoveByIndex() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        container.addLast(20);
        container.addLast(30);
        
        container.removeByIndex(1);
        
        assertEquals(10, container.getByIndex(0));
        assertEquals(30, container.getByIndex(1));
        assertEquals(2, container.getSize());
    }

    @Test
    void testRemoveByIndexOutOfBounds() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        
        assertThrows(IndexOutOfBoundsException.class, () -> container.removeByIndex(5));
        assertThrows(IndexOutOfBoundsException.class, () -> container.removeByIndex(-1));
    }

    @Test
    void testIsEmpty() {
        Container<Integer> container = new Container<>();
        
        assertTrue(container.isEmpty());
        
        container.addLast(10);
        assertFalse(container.isEmpty());
        
        container.removeFirst();
        assertTrue(container.isEmpty());
    }

    @Test
    void testGetSize() {
        Container<Integer> container = new Container<>();
        
        assertEquals(0, container.getSize());
        
        container.addLast(10);
        container.addLast(20);
        assertEquals(2, container.getSize());
        
        container.removeFirst();
        assertEquals(1, container.getSize());
    }

    @Test
    void testToString() {
        Container<Integer> container = new Container<>();
        
        assertEquals("[]", container.toString());
        
        container.addLast(10);
        container.addLast(20);
        container.addLast(30);
        
        assertEquals("[10, 20, 30]", container.toString());
    }

    @Test
    void testGetByIndexOutOfBounds() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        
        assertThrows(IndexOutOfBoundsException.class, () -> container.getByIndex(5));
        assertThrows(IndexOutOfBoundsException.class, () -> container.getByIndex(-1));
    }

    @Test
    void testRemoveFirstEmpty() {
        Container<Integer> container = new Container<>();
        
        container.removeFirst();
        
        assertTrue(container.isEmpty());
        assertEquals(0, container.getSize());
    }

    @Test
    void testRemoveLastEmpty() {
        Container<Integer> container = new Container<>();
        
        container.removeLast();
        
        assertTrue(container.isEmpty());
        assertEquals(0, container.getSize());
    }

    @Test
    void testRemoveSingleElement() {
        Container<Integer> container = new Container<>();
        container.addFirst(42);
        
        container.removeFirst();
        
        assertTrue(container.isEmpty());
        assertEquals(0, container.getSize());
    }

    @Test
    void testGenericType() {
        Container<String> stringContainer = new Container<>();
        stringContainer.addLast("Hello");
        stringContainer.addLast("World");
        
        assertEquals("Hello", stringContainer.getByIndex(0));
        assertEquals("World", stringContainer.getByIndex(1));
        assertEquals("[Hello, World]", stringContainer.toString());
    }
}
