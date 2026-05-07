/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class CurtidaDAO {
    private Connection conn;

    public CurtidaDAO(Connection conn) {
        this.conn = conn;
    }

    public void curtir(int usuarioId, int filmeId) throws SQLException {

        String sql = "INSERT INTO curtidas (usuario_id, filme_id) VALUES (?, ?) ON CONFLICT DO NOTHING";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        stmt.setInt(2, filmeId);

        stmt.executeUpdate();
    }

    public int contarCurtidas(int filmeId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM curtidas WHERE filme_id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, filmeId);

        var rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }
}
