/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prjimobiliaria.negocio;

import java.sql.Date;

/**
 *
 * @author Elissandro
 */
public class Usuario extends Pessoa {

    private char tpPerfil;
    private String dsLogin;
    private String dsSenha;

    public Usuario () {}
    

    public Usuario(int idPessoa, String cdCPF, String cdRG, String nmPessoa, char tpSexo, String dtNascimento, String dsNaturalidade,
                   String dsNacionalidade, char tpEstadoCivil, String nmProfissao, String dsEndereco, String noEndereco, String dsComplemento,
                   String nmBairro, String cdCEP, String nmCidade, String sgEstado, String dsEmail, String dsObservacao, char tpPerfil,
                   String dsLogin, String dsSenha) {
        
        super(idPessoa, cdCPF, cdRG, nmPessoa, tpSexo, dtNascimento, dsNaturalidade, dsNacionalidade, tpEstadoCivil,
              nmProfissao, dsEndereco, noEndereco, dsComplemento, nmBairro, cdCEP, nmCidade, sgEstado, dsEmail, dsObservacao);
        
        this.tpPerfil = tpPerfil;
        this.dsLogin = dsLogin;
        this.dsSenha = dsSenha;
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

}