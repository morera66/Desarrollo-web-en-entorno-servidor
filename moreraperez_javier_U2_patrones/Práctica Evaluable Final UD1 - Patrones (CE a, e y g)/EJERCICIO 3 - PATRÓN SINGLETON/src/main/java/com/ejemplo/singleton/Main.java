package com.ejemplo.singleton;

public class Main {
    public static void main(String[] args) {
        Presidente p1 = Presidente.getInstance("Joe", "Biden", 2020);
        Presidente p2 = Presidente.getInstance("Otro", "Distinto", 2024);

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        System.out.println("¿p1 == p2? " + (p1 == p2));
        System.out.println("hash p1: " + System.identityHashCode(p1));
        System.out.println("hash p2: " + System.identityHashCode(p2));
    }
}
