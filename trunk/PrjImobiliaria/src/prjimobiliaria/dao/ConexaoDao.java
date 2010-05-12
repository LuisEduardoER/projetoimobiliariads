/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prjimobiliaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Elissandro
 */
public class ConexaoDao {

    private Connection conexao;

    public Connection abrirConexao() {

        try {

            Class.forName ("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/dbimobiliaria";
            this.conexao = DriverManager.getConnection(url,"sysdba","masterkey");
        }
        catch(ClassNotFoundException ex) {

            System.out.println("[ERRO_DRIVER] Driver JDBC-ODBC não encontrado!");
        }
        catch(SQLException ex){

            System.out.println("[ERRO_ABRIR_CONEXAO] " + ex.getMessage());
        }

        return this.conexao;
    }

    public void fecharConexao() {

        try {

            this.conexao.close();

        } catch (SQLException ex) {

            System.out.println("[ERRO_FECHAR_CONEXAO] " + ex.getMessage());
        }
    }
    
}
