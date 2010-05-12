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

    private String dsLogin;
    private String dsSenha;
    private int idPessoa;

    Usuario () {}

    public Usuario (String dsLogin, String dsSenha, int idPessoa) {

        this.dsLogin = dsLogin;
        this.dsSenha = dsSenha;
        this.idPessoa = idPessoa;
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
     * @return the idPessoa
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
}
