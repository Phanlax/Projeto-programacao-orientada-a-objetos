/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proj.projetofeitv.model.Usuario;

/**
 *
 * @author Gustavo
 */
public class UsuarioDAO {
     private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Usuario usuario) throws SQLException {

        String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
  

        statement.executeUpdate();

        statement.close();
        
    }
    
    public boolean existeUsuario(String usuario, String senha) throws SQLException {

    String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";

    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, usuario);
    stmt.setString(2, senha);

    var rs = stmt.executeQuery();

    return rs.next();
}
}