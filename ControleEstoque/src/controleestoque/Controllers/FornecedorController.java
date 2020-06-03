/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;
import controleestoque.Models.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author sedden
 */
public class FornecedorController {
   Connection conn = Conexao.getConexaoMySQL();
    
    public void Salvar(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO tbFornecedor (Nome, CNPJ, Email, Rua, Logradouro, Cep, Numero, Bairro, Cidade) VALUES (?,?,?,?,?,?,?,?,?)";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, fornecedor.getNome());
        statement.setString(2, fornecedor.getCnpj());
        statement.setString(3, fornecedor.getEmail());
        statement.setString(4, fornecedor.getRua());
        statement.setString(5, fornecedor.getLogradouro());
        statement.setString(6, fornecedor.getCep());
        statement.setString(7, fornecedor.getNumero());
        statement.setString(8, fornecedor.getBairro());
        statement.setString(9, fornecedor.getCidade());
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
             System.out.println("Fornecedor salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar o fornecedor.");
        }
        
        conn.close();
       Conexao.FecharConexao();
    }
    
    public ArrayList<Fornecedor> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbFornecedor";
 
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        while (result.next()){
            fornecedores.add(
                    new Fornecedor(
                            result.getInt("IdFornecedor"), 
                            result.getString("Email"),
                            result.getString("Nome"),
                            result.getString("Cnpj"),
                            result.getString("Rua"),
                            result.getString("Logradouro"),
                            result.getString("Cep"),
                            result.getString("Numero"),
                            result.getString("Bairro"),
                            result.getString("Cidade")
                    )
            );
        }
        
        conn.close();

       return fornecedores;
   }
    
    public Fornecedor Consultar(int idFornecedor) throws SQLException {
        String sql = "SELECT * from tbFornecedor WHERE IdFornecedor=?;";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idFornecedor);
        
        ResultSet result = statement.executeQuery();
        Fornecedor fornecedor = new Fornecedor();
        while (result.next()){
            fornecedor.setID(result.getInt("IdFornecedor"));
            fornecedor.setEmail(result.getString("Email"));
            fornecedor.setNome(result.getString("Nome"));
            fornecedor.setCnpj(result.getString("Cnpj"));
            fornecedor.setRua(result.getString("Rua"));
            fornecedor.setLogradouro(result.getString("Logradouro"));
            fornecedor.setCep(result.getString("Cep"));
            fornecedor.setNumero(result.getString("Numero"));
            fornecedor.setBairro(result.getString("Bairro"));
            fornecedor.setCidade(result.getString("Cidade"));
        }
        
        conn.close();

       return fornecedor;
    }
    
    public void Editar(Fornecedor fornecedor) throws SQLException {
       String sql = "UPDATE tbFornecedor SET "
               + "Nome=?, "
               + "Cnpj=?, "
               + "Email=?, "
               + "Rua=?, "
               + "Logradouro=?, "
               + "Cep=?, "
               + "Numero=?, "
               + "Bairro=?, "
               + "Cidade=? "
               + "WHERE IdFornecedor=?";
       
       conn = Conexao.getConexaoMySQL();
       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, fornecedor.getNome());
        statement.setString(2, fornecedor.getCnpj());
        statement.setString(3, fornecedor.getEmail());
        statement.setString(4, fornecedor.getRua());
        statement.setString(5, fornecedor.getLogradouro());
        statement.setString(6, fornecedor.getCep());
        statement.setString(7, fornecedor.getNumero());
        statement.setString(8, fornecedor.getBairro());
        statement.setString(9, fornecedor.getCidade());
        statement.setInt(10, fornecedor.getID());
       
       int rowsUpdated = statement.executeUpdate();
       if (rowsUpdated > 0) {
            System.out.println("Fornecdor atualizado!");
       } else {
            System.out.println("Erro ao atualizar o fornecedor.");
       }
       
       conn.close();
       Conexao.FecharConexao();
   }
    
       public void Excluir(int id) throws SQLException {
        String sql = "DELETE FROM tbFornecedor WHERE IdFornecedor=?";
 
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Fornecedor excluido com sucesso!");
        } else {
            System.out.println("Erro ao excluir o fornecedor.");
        }
        
        conn.close();
    }
}
