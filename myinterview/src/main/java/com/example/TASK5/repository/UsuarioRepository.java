package com.example.TASK5.repository;

import com.example.TASK5.conn.ConnectionFactory;
import com.example.TASK5.dto.UsuarioDto;
import com.example.TASK5.model.Usuario;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@Log4j2
public class UsuarioRepository {
    public void save(Usuario usuario) {
        String sql = "INSERT INTO `usuario_db`.`usuario` (`nome`, `email`, `idade`, `altura`) VALUES ('" + usuario.getNome() + "',\n" +
                "'" + usuario.getEmail() + "',\n" +
                "'" + usuario.getIdade() + "',\n" +
                "'" + usuario.getAltura() + "');";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> findAllUsuarios() {
        log.info("Finding all Users");
        String sql = "SELECT *\n" +
                "FROM `usuario_db`.`usuario`;";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                usuarios.add(convertString2User(rs));
            }
            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Encontra usuario pelo seu id
    public Usuario findUsuarioById(int id) {

        String sql = "SELECT * FROM usuario_db.usuario WHERE id = " + id + ";";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            Usuario usuario = null;
            if (rs.next()) {
                usuario = convertString2User(rs);
            }

            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> findUsuarioByUser(String typedUser) {
        log.info("Finding all {}", typedUser);
        String sql = "SELECT *\n" +
                "FROM `usuario_db`.`usuario` WHERE nome LIKE '" + typedUser + "%';";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                usuarios.add(convertString2User(rs));
            }

            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM `usuario_db`.`usuario` WHERE (`id` = '" + id + "');";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' from the database, rows affected '{}' ", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }

    public void update(int id, UsuarioDto usuario) {
        String sql = "UPDATE `usuario_db`.`usuario`\n " +
                "SET `nome` = '" + usuario.getNome() + "', \n" +
                "`email` = '" + usuario.getEmail() + "',\n" +
                " `idade` = " + usuario.getIdade() + ",\n" +
                " `altura` = " + usuario.getAltura() + "\n" +
                " WHERE `id` = " + id + ";";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Updated producer '{}', rows affected '{}' ", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", id, e);
        }
    }

    private static Usuario convertString2User(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String email = rs.getString("email");
        int idade = rs.getInt("idade");
        double altura = rs.getDouble("altura");

        return new Usuario(id, nome, email, idade, altura);
    }

}
