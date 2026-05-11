/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proj.projetofeitv.model.Filme;

/**
 *
 * @author Gustavo
 */
public class ListaReproducaoDAO {
    private Connection conn;

    public ListaReproducaoDAO(Connection conn) {
        this.conn = conn;
    }

    // função que adiciona na lista
    public void adicionar(int usuarioId, int filmeId) throws SQLException {

        String sql = """
            INSERT INTO lista_reproducao (usuario_id, filme_id)
            VALUES (?, ?)
            ON CONFLICT DO NOTHING
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        stmt.setInt(2, filmeId);
        stmt.executeUpdate();
    }

    // // função que remove da lista
    public void remover(int usuarioId, int filmeId) throws SQLException {

        String sql = """
            DELETE FROM lista_reproducao
            WHERE usuario_id = ? AND filme_id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        stmt.setInt(2, filmeId);
        stmt.executeUpdate();
    }

    // função que busca na lista no banco de dados
    public List<Filme> buscarLista(int usuarioId) throws SQLException {

        List<Filme> lista = new ArrayList<>();

        String sql = """
            SELECT f.*
            FROM filmes f
            JOIN lista_reproducao lr
            ON f.id = lr.filme_id
            WHERE lr.usuario_id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            Filme f = new Filme();

            f.setId(rs.getInt("id"));
            f.setTitulo(rs.getString("titulo"));
            f.setGenero(rs.getString("genero"));
            f.setDuracao(rs.getString("duracao"));
            f.setAno(rs.getInt("ano"));

            lista.add(f);
        }

        return lista;
    }
}

