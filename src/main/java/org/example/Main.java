package org.example;

public class Main {
    public static void main(String[] args) {
        Container<Integer> container = new Container<>();
        container.addLast(10);
        container.addLast(20);
        container.addFirst(5);
        container.addByIndex(1, 15);
        container.removeFirst();
        container.removeLast();
        container.removeByIndex(1);

        System.out.println(container);
        System.out.println("Size: " + container.getSize());
        System.out.println(container.isEmpty());
    }
}

