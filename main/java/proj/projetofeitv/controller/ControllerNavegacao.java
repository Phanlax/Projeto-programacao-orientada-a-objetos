/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.controller;
import proj.projetofeitv.view.TelaCadastro;
import proj.projetofeitv.view.TelaLogin;
import proj.projetofeitv.view.TelaPrincipal;
/**
 *
 * @author Gustavo
 */
public class ControllerNavegacao {
    private TelaLogin telaLogin;
    private TelaCadastro telaCadastro;
    private TelaPrincipal telaPrincipal;

    public void iniciar() {
        telaLogin = new TelaLogin(this);
        telaLogin.setVisible(true);
    }

   public void abrirCadastro() {
    telaLogin.dispose();

    telaCadastro = new TelaCadastro(this);
    telaCadastro.setVisible(true);
}

    public void voltarLogin() {
       telaCadastro.dispose();

        telaLogin = new TelaLogin(this);
        telaLogin.setVisible(true);
    }
    
    public void abrirPrincipal() {
    telaLogin.dispose();

    telaPrincipal = new TelaPrincipal(this);
    telaPrincipal.setVisible(true);
}

}
