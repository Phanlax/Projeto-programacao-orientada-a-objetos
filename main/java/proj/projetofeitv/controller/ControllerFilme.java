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
import proj.projetofeitv.dao.ListaReproducaoDAO;
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

        // remove dos favoritos
        FavoritoDAO favoritoDAO = new FavoritoDAO(conn);
        favoritoDAO.removerFavorito(usuarioId, filmeId);

        //  remove também da lista
        ListaReproducaoDAO listaDAO = new ListaReproducaoDAO(conn);
        listaDAO.remover(usuarioId, filmeId);

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
    //busca a lista de reprodução
    public List<Filme> buscarListaReproducao(int usuarioId) {

    try (Connection conn = new Conexao().getConnection()) {

        ListaReproducaoDAO dao = new ListaReproducaoDAO(conn);
        return dao.buscarLista(usuarioId);

    } catch (SQLException e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}
    //adiciona a lista
    public void adicionarLista(int usuarioId, int filmeId) {

    try (Connection conn = new Conexao().getConnection()) {

        ListaReproducaoDAO dao = new ListaReproducaoDAO(conn);
        dao.adicionar(usuarioId, filmeId);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    //remove a lista
    public void removerLista(int usuarioId, int filmeId) {

    try (Connection conn = new Conexao().getConnection()) {

        ListaReproducaoDAO dao = new ListaReproducaoDAO(conn);
        dao.remover(usuarioId, filmeId);

    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
    //pesquisa os filmes
    public List<Filme> pesquisarFilmes(String texto) {

    try (Connection conn = new Conexao().getConnection()) {

        FilmeDAO dao = new FilmeDAO(conn);

        return dao.pesquisarFilmes(texto);

    } catch (SQLException e) {

        e.printStackTrace();
        return new ArrayList<>();
    }
}   // ve se ja favoritou
    public boolean jaFavoritou(int usuarioId, int filmeId) {

    try (Connection conn = new Conexao().getConnection()) {

        FavoritoDAO dao = new FavoritoDAO(conn);

        return dao.jaFavoritou(usuarioId, filmeId);

    } catch (SQLException e) {

        e.printStackTrace();
        return false;
    }
}
    //verifica a curtida
    public boolean jaCurtiu(int usuarioId, int filmeId) {

    try (Connection conn = new Conexao().getConnection()) {

        CurtidaDAO dao = new CurtidaDAO(conn);

        return dao.jaCurtiu(usuarioId, filmeId);

    } catch (SQLException e) {

        e.printStackTrace();
        return false;
    }
}
    //remove a curtida
    public void removerCurtida(int usuarioId, int filmeId) {

    try (Connection conn = new Conexao().getConnection()) {

        CurtidaDAO dao = new CurtidaDAO(conn);

        dao.removerCurtida(usuarioId, filmeId);

    } catch (SQLException e) {

        e.printStackTrace();
    }
}
    
}