package com.example.TASK3;

public class TASK3app {
    public static void main(String[] args) {
        TASK3 task3 = new TASK3();

        task3.setLista("maçã");
        task3.setLista("banana");
        task3.setLista("maçã");
        task3.setLista("laranja");
        task3.setLista("banana");
        task3.setLista("uva");

        System.out.println("Lista: " + task3.getLista());

        System.out.println(task3.HowMuchItens());
    }
}
