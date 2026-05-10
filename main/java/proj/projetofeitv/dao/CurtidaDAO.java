/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    //função de curtir
   public void curtir(int usuarioId, int filmeId)
        throws SQLException {

    String sql = """
        INSERT INTO curtidas (usuario_id, filme_id)
        VALUES (?, ?)
        ON CONFLICT DO NOTHING
    """;

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setInt(1, usuarioId);
    stmt.setInt(2, filmeId);

    int linhas = stmt.executeUpdate();

    // verifica se inseriu e coloca no banco filmes
    if (linhas > 0) {

        String sqlUpdate = """
            UPDATE filmes
            SET curtidas = curtidas + 1
            WHERE id = ?
        """;

        PreparedStatement stmtUpdate =
            conn.prepareStatement(sqlUpdate);

        stmtUpdate.setInt(1, filmeId);

        stmtUpdate.executeUpdate();
    }
}
   
        //função de ver as curtidas no banco de dados
    public int contarCurtidas(int filmeId)
        throws SQLException {

    String sql = """
        SELECT curtidas
        FROM filmes
        WHERE id = ?
    """;

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setInt(1, filmeId);

    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {

        return rs.getInt("curtidas");
    }

    return 0;
}
    
    //verifica se ja curtiu
    public boolean jaCurtiu(int usuarioId, int filmeId) throws SQLException {

    String sql = """
        SELECT * FROM curtidas
        WHERE usuario_id = ? AND filme_id = ?
    """;

    PreparedStatement stmt = conn.prepareStatement(sql);

    stmt.setInt(1, usuarioId);
    stmt.setInt(2, filmeId);

    ResultSet rs = stmt.executeQuery();

    return rs.next();
}   
    
    //remove a curtida
    public void removerCurtida(int usuarioId, int filmeId)
        throws SQLException {

    String sql = """
        DELETE FROM curtidas
        WHERE usuario_id = ? AND filme_id = ?
    """;

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setInt(1, usuarioId);
    stmt.setInt(2, filmeId);

    int linhas = stmt.executeUpdate();

    // verifica se tirou e coloca no banco filmes
    if (linhas > 0) {

        String sqlUpdate = """
            UPDATE filmes
            SET curtidas = curtidas - 1
            WHERE id = ?
        """;

        PreparedStatement stmtUpdate =
            conn.prepareStatement(sqlUpdate);

        stmtUpdate.setInt(1, filmeId);

        stmtUpdate.executeUpdate();
    }
  }
}
