package com.example.TASK2;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 */


public class TASK2 {
    private No begin = null;
    private No end = null;
    private int size = 0;

    void adicionar(int data) {
        No no = new No(data);

        if (this.begin == null) {
            begin = end = no;
        } else {
            end.after = no;
            no.before = end;
            end = no;
        }
        this.size++;
    }

    void getList() {
        No dataNow = begin;

        while (dataNow != null) {
            System.out.println(dataNow.data + " ");
            dataNow = dataNow.after;
        }
        System.out.println();
    }

    void removerItemDoMeio() {
        int indexMeio = size / 2;
        No dataNow = begin;

        for (int i = 0; i < indexMeio; i++) {
            dataNow = dataNow.after;
        }

        if (dataNow.before != null) {
            dataNow.before.after = dataNow.after;
        } else {
            begin = dataNow.after;
        }

        if (dataNow.after != null) {
            dataNow.after.before = dataNow.before;
        } else {
            end = dataNow.before;
        }

        size--;
    }



}