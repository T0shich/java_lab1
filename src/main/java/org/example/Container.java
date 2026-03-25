package org.example;

public class Container<T> {
    private static class Node<T>{
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    public Container() {
        this.head = null;
        this.size = 0;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addByIndex(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        Node<T> newNode = new Node<>(value);
        Node<T> temp = head;
        int counter = 0;

        while (counter != index - 1) {
            temp = temp.next;
            counter++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    public void removeLast(){
        if (isEmpty()) {
            // Empty container, nothing to remove
        } else if (head.next == null) {
            head = null;
            size--;
        } else {
            Node<T> temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            size--;
        }
    }

    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            head = head.next;
            size--;
        } else {
            Node<T> temp = head;
            int counter = 0;
            while (counter != index - 1) {
                temp = temp.next;
                counter++;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    public int getSize(){
        return size;
    }

    public T getByIndex(int index) {
        if (index >= 0 && index < size) {
            Node<T> temp = head;
            int counter = 0;

            while (counter != index) {
                temp = temp.next;
                counter++;
            }
            return temp.value;
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
