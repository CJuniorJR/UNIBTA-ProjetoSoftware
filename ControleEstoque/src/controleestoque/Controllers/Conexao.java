//Nome do nosso pacote //                
 
package controleestoque.Controllers;                   
 
  
 
//Classes necessárias para uso de Banco de dados //
 
import java.sql.Connection;
 
import java.sql.DriverManager;
 
import java.sql.SQLException;
 
  
 
//Início da classe de conexão//
 
public class Conexao {
 
    public static String status = "Não conectou...";
 
    //Método Construtor da Classe//
 
    public Conexao() {

    }
 
  
 
    //Método de Conexão//

    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;          //atributo do tipo Connection

        try {

            // Carregando o JDBC Driver padrão

            String driverName = "com.mysql.cj.jdbc.Driver";                        

            Class.forName(driverName);



            // Configurando a nossa conexão com um banco de dados//

            String serverName = "remotemysql.com";    //caminho do servidor do BD

            String mydatabase = "LYXl3rFK1T";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "LYXl3rFK1T";        //nome de um usuário de seu BD      

            String password = "zsZEhcwic3";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);



            //Testa sua conexão//  

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }



            return connection;



        } catch (ClassNotFoundException e) {  //Driver não encontrado

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }
    }
 
  
 
    //Método que retorna o status da sua conexão//
 
    public static String statusConection() {
 
        return status;
 
    }
 
   
 
   //Método que fecha sua conexão//
 
    public static boolean FecharConexao() {
 
        try {
            getConexaoMySQL().close();
 
            return true;
 
        } catch (SQLException e) {
 
            return false;
 
        }
 
  
 
    }
 
   
 
   //Método que reinicia sua conexão//
 
    public java.sql.Connection ReiniciarConexao() {
 
        this.FecharConexao();
 
  
 
        return this.getConexaoMySQL();
 
    }
 
}