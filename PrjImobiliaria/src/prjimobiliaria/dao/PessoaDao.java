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
    public int inserirPessoa(Pessoa pessoa) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        
        try {

            String sql = "INSERT INTO tb_pessoa VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            // Início da Transação
            con.setAutoCommit(false);
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pessoa.getCdCPF());
            ps.setString(2, pessoa.getCdRG());
            ps.setString(3, pessoa.getNmPessoa());
            ps.setString(4, String.valueOf(pessoa.getTpSexo()));
            ps.setDate(5, pessoa.getDtNascimento());
            ps.setString(6, pessoa.getDsNaturalidade());
            ps.setString(7, pessoa.getDsNacionalidade());
            ps.setString(8, String.valueOf(pessoa.getTpEstadoCivil()));
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

            result = ps.executeUpdate();
            
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
     * Método que atualiza uma pessoa, específicada pelo id
     * @return int
     */
    public int atualizarPessoa(Pessoa pessoa) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

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
                                "ds_observacao = ? "    +
                                "WHERE id_pessoa = ?";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            // Início da Transação
            con.setAutoCommit(false);

            ps = con.prepareStatement(sql);

            result = ps.executeUpdate();

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
     * @return int
     */
    public int excluirPessoa(int idPessoa) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;


        try {

            String sql = "DELETE FROM tb_pessoa WHERE id_pessoa = ?";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            // Início da Transação
            con.setAutoCommit(false);
            
            ps = con.prepareStatement(sql);

            ps.setInt(1, idPessoa);

            result = ps.executeUpdate();

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
     * Método que retorna uma Pessoa, especificado pelo id.
     * 
     * @return ResultSet
     */
    public Pessoa obterPessoa(int idPessoa) throws SQLException, Exception {

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

                pessoa.setCdCPF(rs.getString("id_pessoa"));
                pessoa.setCdCPF(rs.getString("cd_cpf"));
                pessoa.setCdCPF(rs.getString("cd_rg"));
                pessoa.setCdCPF(rs.getString("nm_pessoa"));
                pessoa.setCdCPF(rs.getString("tp_sexo"));
                pessoa.setCdCPF(rs.getString("dt_nascimento"));
                pessoa.setCdCPF(rs.getString("ds_naturalidade"));
                pessoa.setCdCPF(rs.getString("ds_nacionalidade"));
                pessoa.setCdCPF(rs.getString("tp_estado_civil"));
                pessoa.setCdCPF(rs.getString("nm_profissao"));
                pessoa.setCdCPF(rs.getString("ds_endereco"));
                pessoa.setCdCPF(rs.getString("no_endereco"));
                pessoa.setCdCPF(rs.getString("ds_complemento"));
                pessoa.setCdCPF(rs.getString("nm_bairro"));
                pessoa.setCdCPF(rs.getString("cd_cep"));
                pessoa.setCdCPF(rs.getString("nm_cidade"));
                pessoa.setCdCPF(rs.getString("sg_estado"));
                pessoa.setCdCPF(rs.getString("ds_email"));
                pessoa.setCdCPF(rs.getString("ds_observacao"));
                
            }


        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return pessoa;
    }
    
}
