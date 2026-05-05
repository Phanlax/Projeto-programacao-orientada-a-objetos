/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.model;

/**
 *
 * @author Gustavo
 */
public class Usuario {
    private String usuario;
    private String senha;       

    
    public Usuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    
 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String getSenha() {
        return senha;
    }
}