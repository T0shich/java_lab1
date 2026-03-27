package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestContainer {

    // Проверяет добавление в начало и корректный доступ к элементам по индексам.
    @Test
    void testAddFirstAndGetByIndex() {
        Container<Integer> container = new Container<>();
        container.addFirst(10);
        container.addFirst(5);
        
        assertEquals(5, container.getByIndex(0));
        assertEquals(10, container.getByIndex(1));
        assertEquals(2, container.getSize());
    }

    // Проверяет добавление в конец и корректный порядок элементов.
    @Test
    void testAddLastAndGetByIndex() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        container.addLast(20);
        
        assertEquals(10, container.getByIndex(0));
        assertEquals(20, container.getByIndex(1));
        assertEquals(2, container.getSize());
    }

    // Проверяет вставку по индексу в середину контейнера.
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

    // Проверяет вставку по индексу в начало контейнера.
    @Test
    void testAddByIndexAtStart() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        container.addByIndex(0, 5);
        
        assertEquals(5, container.getByIndex(0));
        assertEquals(10, container.getByIndex(1));
        assertEquals(2, container.getSize());
    }

    // Проверяет, что при неверном индексе вставка выбрасывает исключение.
    @Test
    void testAddByIndexOutOfBounds() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        
        assertThrows(IndexOutOfBoundsException.class, () -> container.addByIndex(5, 20));
        assertThrows(IndexOutOfBoundsException.class, () -> container.addByIndex(-1, 20));
    }

    // Проверяет удаление первого элемента и сдвиг оставшихся элементов.
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

    // Проверяет удаление последнего элемента контейнера.
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

    // Проверяет удаление элемента по индексу из середины контейнера.
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

    // Проверяет, что при неверном индексе удаление выбрасывает исключение.
    @Test
    void testRemoveByIndexOutOfBounds() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        
        assertThrows(IndexOutOfBoundsException.class, () -> container.removeByIndex(5));
        assertThrows(IndexOutOfBoundsException.class, () -> container.removeByIndex(-1));
    }

    // Проверяет корректную работу признака пустого контейнера.
    @Test
    void testIsEmpty() {
        Container<Integer> container = new Container<>();
        
        assertTrue(container.isEmpty());
        
        container.addLast(10);
        assertFalse(container.isEmpty());
        
        container.removeFirst();
        assertTrue(container.isEmpty());
    }

    // Проверяет изменение размера контейнера после операций добавления и удаления.
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

    // Проверяет строковое представление для пустого и заполненного контейнера.
    @Test
    void testToString() {
        Container<Integer> container = new Container<>();
        
        assertEquals("[]", container.toString());
        
        container.addLast(10);
        container.addLast(20);
        container.addLast(30);
        
        assertEquals("[10, 20, 30]", container.toString());
    }

    // Проверяет, что доступ по неверному индексу выбрасывает исключение.
    @Test
    void testGetByIndexOutOfBounds() {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        
        assertThrows(IndexOutOfBoundsException.class, () -> container.getByIndex(5));
        assertThrows(IndexOutOfBoundsException.class, () -> container.getByIndex(-1));
    }

    // Проверяет удаление первого элемента из пустого контейнера.
    @Test
    void testRemoveFirstEmpty() {
        Container<Integer> container = new Container<>();
        
        container.removeFirst();
        
        assertTrue(container.isEmpty());
        assertEquals(0, container.getSize());
    }

    // Проверяет удаление последнего элемента из пустого контейнера.
    @Test
    void testRemoveLastEmpty() {
        Container<Integer> container = new Container<>();
        
        container.removeLast();
        
        assertTrue(container.isEmpty());
        assertEquals(0, container.getSize());
    }

    // Проверяет удаление единственного элемента в контейнере.
    @Test
    void testRemoveSingleElement() {
        Container<Integer> container = new Container<>();
        container.addFirst(42);
        
        container.removeFirst();
        
        assertTrue(container.isEmpty());
        assertEquals(0, container.getSize());
    }

    // Проверяет работу контейнера с обобщенным типом String.
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
