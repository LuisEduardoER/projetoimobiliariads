package prjimobiliaria.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Elissandro
 */
public class ConexaoDao {
    
    private Connection _conexao;
    
    
    // Construtor
    public ConexaoDao() {

        try {

            _conexao = abrirConexao();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    /**
     * @param conexao the _conexao to set
     */
    public void setConexao(Connection conexao) {
        this._conexao = conexao;
    }

    /**
     * @return the _conexao
     */
    public Connection getConexao() {
        return _conexao;
    }


    //Método que realiza e retorna conexão com o banco
    public Connection abrirConexao() throws Exception {

        try {

            Class.forName ("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/dbimobiliaria";
            setConexao(DriverManager.getConnection(url, "sysdba", "masterkey"));
        }
        catch(ClassNotFoundException ex) {

            throw new Exception("[ERRO_DRIVER] Driver JDBC-ODBC não encontrado!" + ex.getMessage());
        }
        catch(SQLException ex){

            throw new Exception("[ERRO_ABRIR_CONEXAO] " + ex.getMessage());
        }

        return getConexao();
    }

    //Método que fecha conexão com o banco
    public void fecharConexao() throws Exception {

        try {

            getConexao().close();

        } catch (SQLException ex) {

            throw new Exception("[ERRO_FECHAR_CONEXAO] " + ex.getMessage());
        }
    }
    
    //Método de Persistência para Create(Insert), Update e Delete
    public int executarCud(String sql) throws Exception {
        
        int result = 0;
        
        try {
            
            Statement st = getConexao().createStatement();
            result = st.executeUpdate(sql);
        
        } catch (SQLException ex) {
        
            ex.printStackTrace();
            
        } finally {
        
            fecharConexao();
        }

        return result;
    }
    
    //Método de Persistência para Read(Select)
    public ResultSet executarRead(String sql) throws Exception {

        ResultSet result = null;
        
        try {

            Statement st = getConexao().createStatement();
            result = st.executeQuery(sql);
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            fecharConexao();
        }

        return result;
    }

}