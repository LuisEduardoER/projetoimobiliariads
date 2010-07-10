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
public class UsuarioDao {

    
    /**
     * Método que insere novo
     * 
     * @param usuario
     * 
     * @return boolean
     */
    public boolean inserirUsuario(Usuario usuario) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        
        try {

            String sql = "INSERT INTO tb_usuario VALUES (?,?,?,?);";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();
            
            ps = con.prepareStatement(sql);

            ps.setInt(1, usuario.getIdPessoa());
            ps.setInt(2, usuario.getTpPerfil());
            ps.setString(3, usuario.getDsLogin());
            ps.setString(4, usuario.getDsSenha());
            
            int inseriu = ps.executeUpdate();

            if(inseriu == 1) result = true;
            
            ps.close();

            //Comitar Transação
            con.commit();

        } catch (SQLException ex) {

             //Desfaz operações em caso de erro
             con.rollback();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return result;
    }


    /**
     * Método que atualiza um usuário, específicado pelo id
     * 
     * @return boolean
     */
    public boolean alterarUsuario(Usuario usuario) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;

        try {

            String sql = "UPDATE tb_usuario SET " +
                                "tp_perfil = ?, " +
                                "ds_login = ?, "  +
                                "ds_senha = ? "   +
                         "WHERE "                 +
                                "id_usuario = ?;" ;

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            ps.setInt(1,usuario.getTpPerfil());
            ps.setString(2,usuario.getDsLogin());
            ps.setString(3,usuario.getDsSenha());
            ps.setInt(4,usuario.getIdPessoa());

            int alterou = ps.executeUpdate();

            if(alterou == 1) result = true;

            ps.close();

            //Comitar Transação
            con.commit();

        } catch (SQLException ex) {

             //Desfaz operações em caso de erro
             con.rollback();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return result;
    }


    /**
     * Método que exclui um usuário, especificado pelo id
     * 
     * @return boolean
     */
    public boolean excluirUsuario(int idUsuario) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;

        try {

            String sql = "DELETE FROM tb_usuario WHERE id_usuario = ?;";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            ps.setInt(1, idUsuario);

            int excluiu = ps.executeUpdate();

            if(excluiu == 1) result = true;

            ps.close();

            //Comitar Transação
            con.commit();

        } catch (SQLException ex) {

             //Desfaz operações em caso de erro
             con.rollback();
              
        } catch (Exception ex) {

             ex.printStackTrace();
             
        } finally {

            conDao.fecharConexao();
        }
       
        return result;
    }


    /**
     * Método que retorna todos os usuários cadastrados
     * 
     * @return ArrayList<Usuario>
     */
    public ArrayList<Usuario> obterTodosUsuario() throws SQLException, Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;
        ArrayList<Usuario> lstUsuario = null;
        
        try {

             String sql = "SELECT "                         +
                                "u.id_usuario       ,"      +
                                "u.tp_perfil        ,"      +
                                "u.ds_login         ,"      +
                                "u.ds_senha         ,"      +
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
                              "tb_usuario u "               +
                          "INNE JOIN tb_pessoa p ON "       +
                              "u.id_usuario = p.id_pessoa " ;

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            // Gerando lista de objetos Usuario
            lstUsuario = new ArrayList<Usuario>();
            while(rs.next()) {

                usuario = new Usuario();

                usuario.setIdPessoa(rs.getInt("id_usuario"));

                usuario.setTpPerfil(rs.getString("tp_perfil").charAt(0));
                usuario.setDsLogin(rs.getString("ds_login"));
                usuario.setDsSenha(rs.getString("ds_senha"));

                usuario.setCdCPF(rs.getString("cd_cpf"));
                usuario.setCdRG(rs.getString("cd_rg"));
                usuario.setNmPessoa(rs.getString("nm_pessoa"));
                usuario.setTpSexo(rs.getString("tp_sexo").charAt(0));
                usuario.setDtNascimento(rs.getDate("dt_nascimento"));
                usuario.setDsNaturalidade(rs.getString("ds_naturalidade"));
                usuario.setDsNacionalidade(rs.getString("ds_nacionalidade"));
                usuario.setTpEstadoCivil(rs.getString("tp_estado_civil").charAt(0));
                usuario.setNmProfissao(rs.getString("nm_profissao"));
                usuario.setDsEndereco(rs.getString("ds_endereco"));
                usuario.setNoEndereco(rs.getString("no_endereco"));
                usuario.setDsComplemento(rs.getString("ds_complemento"));
                usuario.setNmBairro(rs.getString("nm_bairro"));
                usuario.setCdCEP(rs.getString("cd_cep"));
                usuario.setNmCidade(rs.getString("nm_cidade"));
                usuario.setSgEstado(rs.getString("sg_estado"));
                usuario.setDsEmail(rs.getString("ds_email"));
                usuario.setDsObservacao(rs.getString("ds_observacao"));

                lstUsuario.add(usuario);
            }

            rs.close();
            ps.close();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return lstUsuario;
    }


    /**
     * Método que retorna todos os usuários cadastrados
     *
     * @return usuario
     */
    public Usuario obterUsuarioPorId(int idUsuario) throws SQLException, Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {

             String sql = "SELECT "                         +
                                "u.id_usuario       ,"      +
                                "u.tp_perfil        ,"      +
                                "u.ds_login         ,"      +
                                "u.ds_senha         ,"      +
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
                                "p.ds_observacao    ,"      +
                                "p.ds_senha          "      +
                          "FROM "                           +
                              "tb_usuario u "               +
                          "INNE JOIN tb_pessoa p ON "       +
                              "u.id_usuario = p.id_pessoa " +
                          "WHERE "                          +
                              "u.id_usuario = ?"            ;

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            ps.setInt(1, idUsuario);

            rs = ps.executeQuery();

            // Gerando lista de objetos Usuario
            while(rs.next()) {

                usuario = new Usuario();
                
                usuario.setIdPessoa(rs.getInt("id_usuario"));
                
                usuario.setTpPerfil(rs.getString("tp_perfil").charAt(0));
                usuario.setDsLogin(rs.getString("ds_login"));
                usuario.setDsSenha(rs.getString("ds_senha"));
                
                usuario.setCdCPF(rs.getString("cd_cpf"));
                usuario.setCdRG(rs.getString("cd_rg"));
                usuario.setNmPessoa(rs.getString("nm_pessoa"));
                usuario.setTpSexo(rs.getString("tp_sexo").charAt(0));
                usuario.setDtNascimento(rs.getDate("dt_nascimento"));
                usuario.setDsNaturalidade(rs.getString("ds_naturalidade"));
                usuario.setDsNacionalidade(rs.getString("ds_nacionalidade"));
                usuario.setTpEstadoCivil(rs.getString("tp_estado_civil").charAt(0));
                usuario.setNmProfissao(rs.getString("nm_profissao"));
                usuario.setDsEndereco(rs.getString("ds_endereco"));
                usuario.setNoEndereco(rs.getString("no_endereco"));
                usuario.setDsComplemento(rs.getString("ds_complemento"));
                usuario.setNmBairro(rs.getString("nm_bairro"));
                usuario.setCdCEP(rs.getString("cd_cep"));
                usuario.setNmCidade(rs.getString("nm_cidade"));
                usuario.setSgEstado(rs.getString("sg_estado"));
                usuario.setDsEmail(rs.getString("ds_email"));
                usuario.setDsObservacao(rs.getString("ds_observacao"));
            }

            rs.close();
            ps.close();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return usuario;
    }


    /**
     * Método que retorna todos os usuários cadastrados
     *
     * @return ArrayList<Usuario>
     */
    public ArrayList<Usuario> obterUsuarioPorPerfil(char tp_perfil) throws SQLException, Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;
        ArrayList<Usuario> lstUsuario = null;

        try {

             String sql = "SELECT "                         +
                                "u.id_usuario       ,"      +
                                "u.tp_perfil        ,"      +
                                "u.ds_login         ,"      +
                                "u.ds_senha         ,"      +
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
                              "tb_usuario u "               +
                          "INNE JOIN tb_pessoa p ON "       +
                              "u.id_usuario = p.id_pessoa " +
                          "WHERE "                          +
                              "u.tp_perfil = ?"             ;

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            ps.setInt(1, tp_perfil);

            rs = ps.executeQuery();

            // Gerando lista de objetos Usuario
            while(rs.next()) {

                usuario = new Usuario();
                
                usuario.setIdPessoa(rs.getInt("id_usuario"));

                usuario.setTpPerfil(rs.getString("tp_perfil").charAt(0));
                usuario.setDsLogin(rs.getString("ds_login"));
                usuario.setDsSenha(rs.getString("ds_senha"));

                usuario.setCdCPF(rs.getString("cd_cpf"));
                usuario.setCdRG(rs.getString("cd_rg"));
                usuario.setNmPessoa(rs.getString("nm_pessoa"));
                usuario.setTpSexo(rs.getString("tp_sexo").charAt(0));
                usuario.setDtNascimento(rs.getDate("dt_nascimento"));
                usuario.setDsNaturalidade(rs.getString("ds_naturalidade"));
                usuario.setDsNacionalidade(rs.getString("ds_nacionalidade"));
                usuario.setTpEstadoCivil(rs.getString("tp_estado_civil").charAt(0));
                usuario.setNmProfissao(rs.getString("nm_profissao"));
                usuario.setDsEndereco(rs.getString("ds_endereco"));
                usuario.setNoEndereco(rs.getString("no_endereco"));
                usuario.setDsComplemento(rs.getString("ds_complemento"));
                usuario.setNmBairro(rs.getString("nm_bairro"));
                usuario.setCdCEP(rs.getString("cd_cep"));
                usuario.setNmCidade(rs.getString("nm_cidade"));
                usuario.setSgEstado(rs.getString("sg_estado"));
                usuario.setDsEmail(rs.getString("ds_email"));
                usuario.setDsObservacao(rs.getString("ds_observacao"));

                lstUsuario.add(usuario);
            }

            rs.close();
            ps.close();

        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return lstUsuario;
    }
    
}