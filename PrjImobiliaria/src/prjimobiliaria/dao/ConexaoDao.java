package prjimobiliaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Elissandro
 */
public class ConexaoDao {

    Connection _conexao;

    // Construtor
    public ConexaoDao() {

    }

    //Método que realiza e retorna conexão com o banco
    public Connection abrirConexao() throws Exception {

        try {
            Class.forName ("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/db_imobiliaria";
            _conexao = DriverManager.getConnection(url, "postgres", "12345");
           
        }
        catch(ClassNotFoundException ex) {

            throw new Exception("[ERRO_DRIVER] Driver JDBC-ODBC não encontrado! " + ex.getMessage());
        }
        catch(SQLException ex) {
           
            throw new Exception("[ERRO_ABRIR_CONEXAO] " );
        }

        return _conexao;
    }

    //Método que fecha conexão com o banco
    public void fecharConexao() throws Exception {

        try {

            _conexao.close();

        } catch (SQLException ex) {

            throw new Exception("[ERRO_FECHAR_CONEXAO] " + ex.getMessage());
        }
    }
    
}