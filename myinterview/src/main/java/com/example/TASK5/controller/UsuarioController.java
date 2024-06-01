package com.example.TASK5.controller;

import com.example.TASK5.dto.UsuarioDto;
import com.example.TASK5.model.Usuario;
import com.example.TASK5.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> EncontreTodosOsUsuarios(){
        List<Usuario> usuarios = service.findAllUser();

        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> CriaUsuario(@RequestBody UsuarioDto dto, UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = service.criaUsuario(dto);
        URI endereco = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(endereco).body(usuario);
    }

    @GetMapping("/{id}/id")
    public ResponseEntity<Usuario> EncontreUmUsuarioPeloId(@PathVariable int id){
        Usuario usuario = service.FindUserById(id);

        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{nome}/nome")
    public ResponseEntity<List<Usuario>> EncontreUsuarioPeloNome(@PathVariable String nome){
        List<Usuario> usuarios = service.EncontreUsuarioPeloNome(nome);

        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> AtualizaUsuario(@PathVariable int id, @RequestBody UsuarioDto dto){
        Usuario usuarioUpdated = service.updateUsuario(id, dto);

        return ResponseEntity.ok(usuarioUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeletaUsuario(@PathVariable int id){
        service.deletaUsuario(id);

        return ResponseEntity.noContent().build();
    }
}
