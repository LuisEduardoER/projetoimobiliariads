/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prjimobiliaria.dao;

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

            String sql = "INSERT INTO tbusuario VALUES ('"+usr.getDsLogin()+"','"+ usr.getDsLogin()+"',"+usr.getIdPessoa()+")";

            ConexaoDao con = new ConexaoDao();
            result = con.executarCud(sql);

        } catch (Exception ex) {
             ex.printStackTrace();
        }

        return result;
    }

    /**
     *
     * Método que atualiza um usuário, específicado pelo id
     * @return int
     */
    public int atualizarUsuario(Usuario usr) {

        int result = 0;

        try {
            
            String sql = "UPDATE tbusuario SET " +
                               "dsLogin = '"+ usr.getDsLogin()+"','"+
                               "dsSenha = '"+ usr.getDsSenha()+"' "+
                         "WHERE " +
                               "idPessoa = "+usr.getIdPessoa();
            
            ConexaoDao con = new ConexaoDao();
            result = con.executarCud(sql);

        } catch (Exception ex) {
             ex.printStackTrace();
        }

        return result;
    }

    /**
     *
     * Método que exclui um usuário, especificado pelo id
     * @return int
     */
    public int excluirUsuario(Usuario usr) {

        int result = 0;

        try {

            String sql = "DELET FROM tbusuario WHERE idPessoa = "+usr.getIdPessoa();

            ConexaoDao con = new ConexaoDao();
            result = con.executarCud(sql);

        } catch (Exception ex) {
             ex.printStackTrace();
        }

        return result;
    }

    /**
     *
     * Método que retorna todos os usuários cadastrados
     * @return ResultSet
     */
    public ResultSet obterUsuario() throws SQLException {

        ResultSet result = null;

        try {

            String sql = "SELECT * " +
                         "FROM " +
                              "tbusuario u " +
                         "INNE JOIN tbpessoa p ON " +
                              "u.idPessoa = p.idPessoa";
                         
            ConexaoDao con = new ConexaoDao();
            result = con.executarRead(sql);

        } catch (Exception ex) {
             ex.printStackTrace();
        }

        return result;
    }
    
}
