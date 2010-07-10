package prjimobiliaria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import prjimobiliaria.negocio.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Elissandro
 */
public class PessoaDao {

    /**
     * Método que insere novo
     * 
     * @param pessoa
     * 
     * @return int
     */
    public boolean inserirPessoa(Pessoa pessoa) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        
        try {

            String sql = "INSERT INTO tb_pessoa VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);
            
            ps.setString(1, pessoa.getCdCPF());
            ps.setString(2, pessoa.getCdRG());
            ps.setString(3, pessoa.getNmPessoa());
            ps.setInt(4, pessoa.getTpSexo());
            ps.setDate(5, pessoa.getDtNascimento());
            ps.setString(6, pessoa.getDsNaturalidade());
            ps.setString(7, pessoa.getDsNacionalidade());
            ps.setInt(8, pessoa.getTpEstadoCivil());
            ps.setString(9, pessoa.getNmProfissao() );
            ps.setString(10, pessoa.getDsEndereco());
            ps.setString(11, pessoa.getNoEndereco());
            ps.setString(12, pessoa.getDsComplemento());
            ps.setString(13, pessoa.getNmBairro());
            ps.setString(14, pessoa.getCdCEP() );
            ps.setString(15, pessoa.getNmCidade());
            ps.setString(16, pessoa.getSgEstado());
            ps.setString(17, pessoa.getDsEmail());
            ps.setString(18, pessoa.getDsObservacao());

            int inseriu = ps.executeUpdate();

            if(inseriu == 1) result = true;
            
            ps.close();

            //Comitar Transação
            con.commit();

        } catch (SQLException ex) {

             //Comitar Transação
             con.rollback();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return result;
    }

    /**
     *
     * Método que atualiza uma pessoa, específicada pelo id
     * @return int
     */
    public boolean alterarPessoa(Pessoa pessoa) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;

        try {

            String sql = "UPDATE tb_pessoa SET "         +
                                "cd_cpf = ?, "           +
                                "cd_rg = ?, "            +
                                "nm_pessoa = ?, "        +
                                "tp_sexo = ?, "          +
                                "dt_nascimento = ?, "    +
                                "ds_naturalidade = ?, "  +
                                "ds_nacionalidade = ?, " +
                                "tp_estado_civil = ?, "  +
                                "ds_endereco = ?, "      +
                                "no_endereco = ?, "      +
                                "ds_complemento = ?, "   +
                                "nm_bairro = ?, "        +
                                "cd_cep = ?, "           +
                                "nm_cidade = ?, "        +
                                "sg_estado = ?, "        +
                                "ds_email = ?, "         +
                                "ds_observacao = ? "     +
                          "WHERE "                       +
                                "id_pessoa = ?;"         ;

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            ps.setString(1, pessoa.getCdCPF());
            ps.setString(2, pessoa.getCdRG());
            ps.setString(3, pessoa.getNmPessoa());
            ps.setInt(4, pessoa.getTpSexo());
            ps.setDate(5, pessoa.getDtNascimento());
            ps.setString(6, pessoa.getDsNaturalidade());
            ps.setString(7, pessoa.getDsNacionalidade());
            ps.setInt(8, pessoa.getTpEstadoCivil());
            ps.setString(9, pessoa.getNmProfissao() );
            ps.setString(10, pessoa.getDsEndereco());
            ps.setString(11, pessoa.getNoEndereco());
            ps.setString(12, pessoa.getDsComplemento());
            ps.setString(13, pessoa.getNmBairro());
            ps.setString(14, pessoa.getCdCEP() );
            ps.setString(15, pessoa.getNmCidade());
            ps.setString(16, pessoa.getSgEstado());
            ps.setString(17, pessoa.getDsEmail());
            ps.setString(18, pessoa.getDsObservacao());

            int atualizou = ps.executeUpdate();

            if(atualizou == 1) result = true;

            ps.close();

            // Comitar Transação
            con.commit();

        } catch (SQLException ex) {

             //
             con.rollback();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return result;
    }

    /**
     *
     * Método que exclui uma Pessoa, especificada pelo id
     * @return boolean
     */
    public boolean excluirPessoa(int idPessoa) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;

        try {

            String sql = "DELETE FROM tb_pessoa WHERE id_pessoa = ?;";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            ps.setInt(1, idPessoa);

            int excluiu = ps.executeUpdate();

            if(excluiu == 1) result = true;

            ps.close();

            // Comitar Transação
            con.commit();

        } catch (SQLException ex) {

             //
             con.rollback();
              
        } catch (Exception ex) {

             ex.printStackTrace();
             
        } finally {

            conDao.fecharConexao();
        }
       
        return result;
    }

    /**
     * 
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Pessoa> obterTodosPessoa() throws SQLException, Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        ArrayList<Pessoa> lstPessoa = null;

        try {

             String sql = "SELECT "                         +
                                "p.id_pessoa        ,"      +
                                "p.cd_cpf           ,"      +
                                "p.cd_rg            ,"      +
                                "p.nm_pessoa        ,"      +
                                "p.tp_sexo          ,"      +
                                "p.dt_nascimento    ,"      +
                                "p.ds_naturalidade  ,"      +
                                "p.ds_nacionalidade ,"      +
                                "p.tp_estado_civil  ,"      +
                                "p.nm_profissao     ,"      +
                                "p.ds_endereco      ,"      +
                                "p.no_endereco      ,"      +
                                "p.ds_complemento   ,"      +
                                "p.nm_bairro        ,"      +
                                "p.cd_cep           ,"      +
                                "p.nm_cidade        ,"      +
                                "p.sg_estado        ,"      +
                                "p.ds_email         ,"      +
                                "p.ds_observacao     "      +
                          "FROM "                           +
                              "tb_pessoa p"                 ;

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            // Gerando lista de objetos Pessoa
            lstPessoa = new ArrayList<Pessoa>();
            while(rs.next()) {

                pessoa = new Pessoa();

                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setCdCPF(rs.getString("cd_cpf"));
                pessoa.setCdRG(rs.getString("cd_rg"));
                pessoa.setNmPessoa(rs.getString("nm_pessoa"));
                pessoa.setTpSexo(rs.getString("tp_sexo").charAt(0));
                pessoa.setDtNascimento(rs.getDate("dt_nascimento"));
                pessoa.setDsNaturalidade(rs.getString("ds_naturalidade"));
                pessoa.setDsNacionalidade(rs.getString("ds_nacionalidade"));
                pessoa.setTpEstadoCivil(rs.getString("tp_estado_civil").charAt(0));
                pessoa.setNmProfissao(rs.getString("nm_profissao"));
                pessoa.setDsEndereco(rs.getString("ds_endereco"));
                pessoa.setNoEndereco(rs.getString("no_endereco"));
                pessoa.setDsComplemento(rs.getString("ds_complemento"));
                pessoa.setNmBairro(rs.getString("nm_bairro"));
                pessoa.setCdCEP(rs.getString("cd_cep"));
                pessoa.setNmCidade(rs.getString("nm_cidade"));
                pessoa.setSgEstado(rs.getString("sg_estado"));
                pessoa.setDsEmail(rs.getString("ds_email"));
                pessoa.setDsObservacao(rs.getString("ds_observacao"));

                lstPessoa.add(pessoa);
            }

            rs.close();
            ps.close();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return lstPessoa;
    }


    /**
     * Método que retorna uma Pessoa, especificado pelo id.
     * 
     * @return ResultSet
     */
    public Pessoa obterPessoaPorId(int idPessoa) throws SQLException, Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = null;

        try {

             String sql = "SELECT * FROM tb_pessoa WHERE id_pessoa = ?";

             conDao = new ConexaoDao();
             con = conDao.abrirConexao();

             ps = con.prepareStatement(sql);

             ps.setInt(1, idPessoa);

             rs = ps.executeQuery();

            // Criando o objeto pessoa
            while(rs.next()) {

                pessoa = new Pessoa();

                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setCdCPF(rs.getString("cd_cpf"));
                pessoa.setCdRG(rs.getString("cd_rg"));
                pessoa.setNmPessoa(rs.getString("nm_pessoa"));
                pessoa.setTpSexo(rs.getString("tp_sexo").charAt(0));
                pessoa.setDtNascimento(rs.getDate("dt_nascimento"));
                pessoa.setDsNaturalidade(rs.getString("ds_naturalidade"));
                pessoa.setDsNacionalidade(rs.getString("ds_nacionalidade"));
                pessoa.setTpEstadoCivil(rs.getString("tp_estado_civil").charAt(0));
                pessoa.setNmProfissao(rs.getString("nm_profissao"));
                pessoa.setDsEndereco(rs.getString("ds_endereco"));
                pessoa.setNoEndereco(rs.getString("no_endereco"));
                pessoa.setDsComplemento(rs.getString("ds_complemento"));
                pessoa.setNmBairro(rs.getString("nm_bairro"));
                pessoa.setCdCEP(rs.getString("cd_cep"));
                pessoa.setNmCidade(rs.getString("nm_cidade"));
                pessoa.setSgEstado(rs.getString("sg_estado"));
                pessoa.setDsEmail(rs.getString("ds_email"));
                pessoa.setDsObservacao(rs.getString("ds_observacao"));
            }

            rs.close();
            ps.close();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return pessoa;
    }

    /**
     * Método que retorna uma Pessoa, especificado pelo CPF.
     *
     * @return ResultSet
     */
    public Pessoa obterPessoaPorCpf(String cdCpf) throws SQLException, Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = null;

        try {

             String sql = "SELECT * FROM tb_pessoa WHERE cd_cpf = ?";

             conDao = new ConexaoDao();
             con = conDao.abrirConexao();

             ps = con.prepareStatement(sql);

             ps.setString(1, cdCpf);

             rs = ps.executeQuery();

            // Criando o objeto pessoa
            while(rs.next()) {

                pessoa = new Pessoa();

                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setCdCPF(rs.getString("cd_cpf"));
                pessoa.setCdRG(rs.getString("cd_rg"));
                pessoa.setNmPessoa(rs.getString("nm_pessoa"));
                pessoa.setTpSexo(rs.getString("tp_sexo").charAt(0));
                pessoa.setDtNascimento(rs.getDate("dt_nascimento"));
                pessoa.setDsNaturalidade(rs.getString("ds_naturalidade"));
                pessoa.setDsNacionalidade(rs.getString("ds_nacionalidade"));
                pessoa.setTpEstadoCivil(rs.getString("tp_estado_civil").charAt(0));
                pessoa.setNmProfissao(rs.getString("nm_profissao"));
                pessoa.setDsEndereco(rs.getString("ds_endereco"));
                pessoa.setNoEndereco(rs.getString("no_endereco"));
                pessoa.setDsComplemento(rs.getString("ds_complemento"));
                pessoa.setNmBairro(rs.getString("nm_bairro"));
                pessoa.setCdCEP(rs.getString("cd_cep"));
                pessoa.setNmCidade(rs.getString("nm_cidade"));
                pessoa.setSgEstado(rs.getString("sg_estado"));
                pessoa.setDsEmail(rs.getString("ds_email"));
                pessoa.setDsObservacao(rs.getString("ds_observacao"));
            }

            rs.close();
            ps.close();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return pessoa;
    }
    
}
