/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prjimobiliaria.negocio;

/**
 *
 * @author Elissandro
 */
public class Usuario {

    private int idUsuario;
    private char tpPerfil;
    private String dsLogin;
    private String dsSenha;
    private Pessoa pessoa;

    public Usuario () {}

    public Usuario (String dsLogin, String dsSenha, Pessoa pessoa) {

        this.dsLogin = dsLogin;
        this.dsSenha = dsSenha;
        this.pessoa = pessoa;
    }



    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @return the tpPerfil
     */
    public char getTpPerfil() {
        return tpPerfil;
    }

    /**
     * @param tpPerfil the tpPerfil to set
     */
    public void setTpPerfil(char tpPerfil) {
        this.tpPerfil = tpPerfil;
    }

    /**
     * @return the dsLogin
     */
    public String getDsLogin() {
        return dsLogin;
    }

    /**
     * @param dsLogin the dsLogin to set
     */
    public void setDsLogin(String dsLogin) {
        this.dsLogin = dsLogin;
    }

    /**
     * @return the dsSenha
     */
    public String getDsSenha() {
        return dsSenha;
    }

    /**
     * @param dsSenha the dsSenha to set
     */
    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}