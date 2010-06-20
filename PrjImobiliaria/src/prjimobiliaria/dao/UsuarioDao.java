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
     * @return int
     */
    public int inserirUsuario(Usuario usuario) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        
        try {

            String sql = "INSERT INTO tb_usuario VALUES (?,?,?)";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, usuario.getDsLogin());
            ps.setString(2, usuario.getDsSenha());
            ps.setInt(3, usuario.getPessoa().getIdPessoa());

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
     * Método que atualiza um usuário, específicado pelo id
     * 
     * @return int
     */
    public int atualizarUsuario(Usuario usuario) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            String sql = "UPDATE tb_usuario SET ds_login = ?, ds_senha = ? WHERE id_usuario = ?";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            // Início da Transação
            con.setAutoCommit(false);

            ps = con.prepareStatement(sql);

            ps.setString(1,usuario.getDsLogin());
            ps.setString(2,usuario.getDsSenha());
            ps.setInt(3,usuario.getIdUsuario());

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
     * Método que exclui um usuário, especificado pelo id
     * 
     * @return int
     */
    public int excluirUsuario(int idUsuario) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;


        try {

            String sql = "DELETE FROM tb_usuario WHERE id_usuario = ?";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            // Início da Transação
            con.setAutoCommit(false);
            
            ps = con.prepareStatement(sql);

            ps.setInt(1, idUsuario);

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
     * Método que retorna todos os usuários cadastrados
     * 
     * @return ArrayList<Usuario>
     */
    public ArrayList<Usuario> obterUsuarios() throws SQLException, Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;
        ArrayList<Usuario> lstUsuario = null;
        Pessoa pessoa = null;
        PessoaDao pessoaDao = null;


        try {

             String sql = "SELECT * " +
                          "FROM " +
                              "tb_usuario u " +
                          "INNE JOIN tb_pessoa p ON " +
                              "u.id_pessoa = p.id_pessoa";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            // Gerando lista de objetos Pessoa
            lstUsuario = new ArrayList<Usuario>();
            while(rs.next()) {

                usuario = new Usuario();
                usuario.setDsLogin(rs.getString("tp_perfil"));
                usuario.setDsLogin(rs.getString("ds_login"));
                usuario.setDsSenha(rs.getString("ds_senha"));

                pessoaDao = new PessoaDao();
                pessoa = pessoaDao.obterPessoa(rs.getInt("id_usuario"));

                usuario.setPessoa(pessoa);

                lstUsuario.add(usuario);
            }


        } catch (Exception ex) {

             ex.printStackTrace();

        } finally {

            conDao.fecharConexao();
        }

        return lstUsuario;
    }
    
}
