package com.example.TASK5.model;

import com.example.TASK5.dto.UsuarioDto;
import lombok.Getter;
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

        public Usuario(UsuarioDto dto) {
                this.nome = dto.getNome();
                this.email = dto.getEmail();
                this.idade = dto.getIdade();
                this.altura = dto.getAltura();
        }

        public Usuario(int id, String nome, String email, int idade, double altura) {
                this.id = id;
                this.nome = nome;
                this.email = email;
                this.idade = idade;
                this.altura = altura;
        }
}
