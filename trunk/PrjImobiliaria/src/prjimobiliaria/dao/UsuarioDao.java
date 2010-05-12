/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prjimobiliaria.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import prjimobiliaria.negocio.*;

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
    public int inserirUsuario(Usuario usr) {

        int result = 0;

        try {
        ConexaoDao conDao = new ConexaoDao();
        Connection con = conDao.abrirConexao();

        Statement st = con.createStatement();

        String sql = "insert into tbusuario values ('"+usr.getDsLogin()+"','"+ usr.getDsLogin()+"',"+usr.getIdPessoa()+")";
        
        result = st.executeUpdate(sql);

        st.close();
        conDao.fecharConexao();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     *
     * Método que atualiza um usuário específicado pelo id
     * @return int
     */
    public int atualizarUsuario(Usuario usr) {

        int result = 0;

        try {
        ConexaoDao conDao = new ConexaoDao();
        Connection con = conDao.abrirConexao();

        Statement st = con.createStatement();

        String sql = "update usuario set dsLogin = '"+usr.getDsLogin()+"','"+ usr.getDsLogin()+"' where idPessoa = "+usr.getIdPessoa();

        result = st.executeUpdate(sql);

        st.close();
        conDao.fecharConexao();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     *
     * Método que exclui um usuário específicado pelo id
     * @return int
     */
    public int excluirUsuario(Usuario usr) {

        int result = 0;

        try {
        ConexaoDao conDao = new ConexaoDao();
        Connection con = conDao.abrirConexao();

        Statement st = con.createStatement();

        String sql = "delete from usuario where idPessoa = "+usr.getIdPessoa();

        result = st.executeUpdate(sql);

        st.close();
        conDao.fecharConexao();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    /**
     *
     * Método que retorna todos os usuários cadastrados
     * @return ResultSet
     */
    public ResultSet obterUsuario() throws SQLException {

        ResultSet rs = null;

        try {
        ConexaoDao conDao = new ConexaoDao();
        Connection con = conDao.abrirConexao();

        Statement st = con.createStatement();

        rs = st.executeQuery("select * from usuario");
        
        st.close();
        conDao.fecharConexao();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
}
