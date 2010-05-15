package prjimobiliaria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import prjimobiliaria.negocio.*;
import java.sql.PreparedStatement;

/**
 *
 * @author Elissandro
 */
public class UsuarioDao {

    /**
     *
     * Método que insere novo
     * @return int
     */
    public int inserirUsuario(Usuario usr) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        
        try {

            String sql = "INSERT INTO TbUsuario VALUES (?,?,?)";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1,usr.getDsLogin());
            ps.setString(2,usr.getDsSenha());
            ps.setInt(3,usr.getIdPessoa());

            result = ps.executeUpdate();

        } catch (Exception ex) {
             ex.printStackTrace();
        } finally {

            conDao.fecharConexao();
        }

        return result;
    }

    /**
     *
     * Método que atualiza um usuário, específicado pelo id
     * @return int
     */
    public int atualizarUsuario(Usuario usr) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            String sql = "UPDATE tbusuario SET dsLogin = ?, dsSenha = ? WHERE idPessoa = ?";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            ps.setString(1,usr.getDsLogin());
            ps.setString(2,usr.getDsSenha());
            ps.setInt(3,usr.getIdPessoa());

            result = ps.executeUpdate();
 
        } catch (Exception ex) {
             ex.printStackTrace();
        } finally {
            conDao.fecharConexao();
        }

        return result;
    }

    /**
     *
     * Método que exclui um usuário, especificado pelo id
     * @return int
     */
    public int excluirUsuario(Usuario usr) throws Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            String sql = "DELET FROM tbusuario WHERE idPessoa = ?";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            ps.setInt(1,usr.getIdPessoa());

            result = ps.executeUpdate();

        } catch (Exception ex) {
             ex.printStackTrace();
        } finally {

            conDao.fecharConexao();
        }
       
        return result;
    }

    /**
     *
     * Método que retorna todos os usuários cadastrados
     * @return ResultSet
     */
    public ResultSet obterUsuario() throws SQLException, Exception {

        ConexaoDao conDao = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet result = null;

        try {

             String sql = "SELECT * " +
                          "FROM " +
                              "tbusuario u " +
                          "INNE JOIN tbpessoa p ON " +
                              "u.idPessoa = p.idPessoa";

            conDao = new ConexaoDao();
            con = conDao.abrirConexao();

            ps = con.prepareStatement(sql);

            result = ps.executeQuery();

        } catch (Exception ex) {
             ex.printStackTrace();
        } finally {

            conDao.fecharConexao();
        }

        return result;
    }
    
}
