package com.example.TASK5.service;

import com.example.TASK5.dto.UsuarioDto;
import com.example.TASK5.model.Usuario;
import com.example.TASK5.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<Usuario> findAllUser() {
        return repository.findAllUsuarios();
    }


    public Usuario criaUsuario(UsuarioDto dto) {
        repository.save(new Usuario(dto));
        List<Usuario> usuario = repository.findUsuarioByUser(dto.getNome());
        return usuario.get(0);
    }

    public Usuario FindUserById(int id) {
        return repository.findUsuarioById(id);
    }

    public List<Usuario> EncontreUsuarioPeloNome(String nome) {
        return repository.findUsuarioByUser(nome);
    }

    public Usuario updateUsuario(int id, UsuarioDto dto) {
        repository.update(id, dto);
        return repository.findUsuarioById(id);
    }

    public void deletaUsuario(int id) {
        repository.delete(id);
    }
}
