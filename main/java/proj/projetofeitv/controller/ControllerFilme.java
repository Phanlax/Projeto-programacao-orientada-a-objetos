/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.controller;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import proj.projetofeitv.dao.Conexao;
import proj.projetofeitv.dao.CurtidaDAO;
import proj.projetofeitv.dao.FavoritoDAO;
import proj.projetofeitv.dao.FilmeDAO;
import proj.projetofeitv.model.Filme;

/**
 *
 * @author Gustavo
 */
public class ControllerFilme {
    
   
    // função de buscar filmes
   public List<Filme> buscarFilmes() {
        try (Connection conn = new Conexao().getConnection()) {
            FilmeDAO dao = new FilmeDAO(conn);
            return dao.listarFilmes();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    // função de pegar o numero de curtidas
    public int getCurtidas(int filmeId) {
        try (Connection conn = new Conexao().getConnection()) {

            CurtidaDAO dao = new CurtidaDAO(conn);
            return dao.contarCurtidas(filmeId);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // função de curtir
    public void curtir(int usuarioId, int filmeId) {
        try (Connection conn = new Conexao().getConnection()) {

            CurtidaDAO dao = new CurtidaDAO(conn);
            dao.curtir(usuarioId, filmeId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //funcãp de favoritar
    public void favoritar(int usuarioId, int filmeId) {
        try (Connection conn = new Conexao().getConnection()) {

            FavoritoDAO dao = new FavoritoDAO(conn);
            dao.favoritar(usuarioId, filmeId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //função de remover dos favoritos
    public void removerFavorito(int usuarioId, int filmeId) {

    try (Connection conn = new Conexao().getConnection()) {

        FavoritoDAO dao = new FavoritoDAO(conn);
        dao.removerFavorito(usuarioId, filmeId);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    // função de buscar os favoritos
    public List<Filme> buscarFavoritos(int usuarioId) {

    try (Connection conn = new Conexao().getConnection()) {

        FavoritoDAO dao = new FavoritoDAO(conn);
        return dao.buscarFavoritos(usuarioId);

    } catch (SQLException e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
   }
}
