package com.example.TASK5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Usuario {
        private int id;
        private String nome;
        private String email;
        private int idade;
        private double altura;

        public Usuario(String nome, String email, int idade, double altura) {
                this.nome = nome;
                this.email = email;
                this.idade = idade;
                this.altura = altura;
        }

        public Usuario(int id, String nome, String email, int idade, double altura) {
                this.id = id;
                this.nome = nome;
                this.email = email;
                this.idade = idade;
                this.altura = altura;
        }
}
