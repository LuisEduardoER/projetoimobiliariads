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
public class Pessoa {

    private int idPessoa;
    private String cdCPF;
    private String cdRG;
    private String nmPessoa;
    private char tpSexo;
    private Date dtNascimento;
    private String dsNaturalidade;
    private String dsNacionalidade;
    private char tpEstadoCivil;
    private String nmProfissao;
    private String dsEndereco;
    private String noEndereco;
    private String dsComplemento;
    private String nmBairro;
    private String cdCEP;
    private String nmCidade;
    private String sgEstado;
    private String dsEmail;
    private String dsObservacao;

    public Pessoa() {}

    public Pessoa(int idPessoa, String cdCPF, String cdRG, String nmPessoa, char tpSexo, Date dtNascimento, String dsNaturalidade, 
                  String dsNacionalidade, char tpEstadoCivil, String nmProfissao, String dsEndereco, String noEndereco, String dsComplemento,
                  String nmBairro, String cdCEP, String nmCidade, String sgEstado, String dsEmail, String dsObservacao) {
        
        this.idPessoa = idPessoa;
        this.cdCPF = cdCPF;
        this.cdRG = cdRG;
        this.nmPessoa = nmPessoa;
        this.tpSexo = tpSexo;
        this.dtNascimento = dtNascimento;
        this.dsNaturalidade = dsNaturalidade;
        this.dsNacionalidade = dsNacionalidade;
        this.tpEstadoCivil = tpEstadoCivil;
        this.nmProfissao = nmProfissao;
        this.dsEndereco = dsEndereco;
        this.noEndereco = noEndereco;
        this.dsComplemento = dsComplemento;
        this.nmBairro = nmBairro;
        this.cdCEP = cdCEP;
        this.nmCidade = nmCidade;
        this.sgEstado = sgEstado;
        this.dsEmail = dsEmail;
        this.dsObservacao = dsObservacao;
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

    /**
     * @return the cdCPF
     */
    public String getCdCPF() {
        return cdCPF;
    }

    /**
     * @param cdCPF the cdCPF to set
     */
    public void setCdCPF(String cdCPF) {
        this.cdCPF = cdCPF;
    }

    /**
     * @return the cdRG
     */
    public String getCdRG() {
        return cdRG;
    }

    /**
     * @param cdRG the cdRG to set
     */
    public void setCdRG(String cdRG) {
        this.cdRG = cdRG;
    }

    /**
     * @return the nmPessoa
     */
    public String getNmPessoa() {
        return nmPessoa;
    }

    /**
     * @param nmPessoa the nmPessoa to set
     */
    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    /**
     * @return the tpSexo
     */
    public char getTpSexo() {
        return tpSexo;
    }

    /**
     * @param tpSexo the tpSexo to set
     */
    public void setTpSexo(char tpSexo) {
        this.tpSexo = tpSexo;
    }

    /**
     * @return the dtNascimento
     */
    public Date getDtNascimento() {
        return dtNascimento;
    }

    /**
     * @param dtNascimento the dtNascimento to set
     */
    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    /**
     * @return the dsNaturalidade
     */
    public String getDsNaturalidade() {
        return dsNaturalidade;
    }

    /**
     * @param dsNaturalidade the dsNaturalidade to set
     */
    public void setDsNaturalidade(String dsNaturalidade) {
        this.dsNaturalidade = dsNaturalidade;
    }

    /**
     * @return the dsNacionalidade
     */
    public String getDsNacionalidade() {
        return dsNacionalidade;
    }

    /**
     * @param dsNacionalidade the dsNacionalidade to set
     */
    public void setDsNacionalidade(String dsNacionalidade) {
        this.dsNacionalidade = dsNacionalidade;
    }

    /**
     * @return the tpEstadoCivil
     */
    public char getTpEstadoCivil() {
        return tpEstadoCivil;
    }

    /**
     * @param tpEstadoCivil the tpEstadoCivil to set
     */
    public void setTpEstadoCivil(char tpEstadoCivil) {
        this.tpEstadoCivil = tpEstadoCivil;
    }

    /**
     * @return the nmProfissao
     */
    public String getNmProfissao() {
        return nmProfissao;
    }

    /**
     * @param nmProfissao the nmProfissao to set
     */
    public void setNmProfissao(String nmProfissao) {
        this.nmProfissao = nmProfissao;
    }

    /**
     * @return the dsEndereco
     */
    public String getDsEndereco() {
        return dsEndereco;
    }

    /**
     * @param dsEndereco the dsEndereco to set
     */
    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    /**
     * @return the noEndereco
     */
    public String getNoEndereco() {
        return noEndereco;
    }

    /**
     * @param noEndereco the noEndereco to set
     */
    public void setNoEndereco(String noEndereco) {
        this.noEndereco = noEndereco;
    }

    /**
     * @return the dsComplemento
     */
    public String getDsComplemento() {
        return dsComplemento;
    }

    /**
     * @param dsComplemento the dsComplemento to set
     */
    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }

    /**
     * @return the nmBairro
     */
    public String getNmBairro() {
        return nmBairro;
    }

    /**
     * @param nmBairro the nmBairro to set
     */
    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    /**
     * @return the cdCEP
     */
    public String getCdCEP() {
        return cdCEP;
    }

    /**
     * @param cdCEP the cdCEP to set
     */
    public void setCdCEP(String cdCEP) {
        this.cdCEP = cdCEP;
    }

    /**
     * @return the nmCidade
     */
    public String getNmCidade() {
        return nmCidade;
    }

    /**
     * @param nmCidade the nmCidade to set
     */
    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    /**
     * @return the sgEstado
     */
    public String getSgEstado() {
        return sgEstado;
    }

    /**
     * @param sgEstado the sgEstado to set
     */
    public void setSgEstado(String sgEstado) {
        this.sgEstado = sgEstado;
    }

    /**
     * @return the dsEmail
     */
    public String getDsEmail() {
        return dsEmail;
    }

    /**
     * @param dsEmail the dsEmail to set
     */
    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    /**
     * @return the dsObservacao
     */
    public String getDsObservacao() {
        return dsObservacao;
    }

    /**
     * @param dsObservacao the dsObservacao to set
     */
    public void setDsObservacao(String dsObservacao) {
        this.dsObservacao = dsObservacao;
    }

    

}
