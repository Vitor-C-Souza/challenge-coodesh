package com.example.TASK3;

import java.util.ArrayList;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 */
public class TASK3 {
    private ArrayList<String> lista = new ArrayList<>();


    void setLista(String item) {
        this.lista.add(item);
    }

    ArrayList<String> getLista() {
        return lista;
    }

    int HowMuchItens() {
        ArrayList<String> listaTemp = new ArrayList<>();
        int size = 0;
        for (String item : lista) {
            if (!listaTemp.contains(item)) {
                listaTemp.add(item);
                size++;
            }
        }
        return size;
    }
}
