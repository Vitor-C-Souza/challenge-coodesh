package com.example.TASK2;

public class TASK2app {
    public static void main(String[] args) {
        TASK2 task2 = new TASK2();

        task2.adicionar(1);
        task2.adicionar(2);
        task2.adicionar(3);
        task2.adicionar(4);
        task2.adicionar(5);

        System.out.println("Lista: ");
        task2.getList();

        task2.removerItemDoMeio();

        System.out.println("Lista sem o elemento do meio: ");
        task2.getList();
    }
}
