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
import proj.projetofeitv.dao.FilmeDAO;
import proj.projetofeitv.model.Filme;

/**
 *
 * @author Gustavo
 */
public class ControllerFilme {
    
    public List<Filme> buscarFilmes() {
    try (Connection conn = new Conexao().getConnection()) {
        FilmeDAO dao = new FilmeDAO(conn);
        return dao.listarFilmes();
    } catch (SQLException e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
   }
}
