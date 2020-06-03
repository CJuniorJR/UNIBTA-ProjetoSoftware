/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;
import controleestoque.Models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.time.*;
/**
 *
 * @author sedden
 */
public class ClienteController {
   Connection conn = Conexao.getConexaoMySQL();
    
    public void Salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO tbCliente (Nome, RG, Cpf, DataNascimento, Email, Rua, Logradouro, Cep, Numero, Bairro, Cidade) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        

        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getRg());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getDataNascimento());
        statement.setString(5, cliente.getEmail());
        statement.setString(6, cliente.getRua());
        statement.setString(7, cliente.getLogradouro());
        statement.setString(8, cliente.getCep());
        statement.setString(9, cliente.getNumero());
        statement.setString(10, cliente.getBairro());
        statement.setString(11, cliente.getCidade());
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
             System.out.println("Cliente salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar o cliente.");
        }

    }
    
    public ArrayList<Cliente> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbCliente";
 

        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        while (result.next()){
            clientes.add(
                    new Cliente(
                            result.getInt("IdCliente"), 
                            result.getString("Email"),
                            result.getString("Nome"),
                            result.getString("RG"),
                            result.getString("Cpf"),
                            result.getString("DataNascimento"),
                            result.getString("Rua"),
                            result.getString("Logradouro"),
                            result.getString("Cep"),
                            result.getString("Numero"),
                            result.getString("Bairro"),
                            result.getString("Cidade")
                    )
            );
            System.out.println(result.getString("Nome"));
        }
        
 
       return clientes;
   }
    
    public Cliente Consultar(int idCliente) throws SQLException {
        String sql = "SELECT * from tbCliente WHERE IdCliente=?;";
        

        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idCliente);
        
        ResultSet result = statement.executeQuery();
        Cliente cliente = new Cliente();
        while (result.next()){
            cliente.setID(result.getInt("IdCliente"));
            cliente.setEmail(result.getString("Email"));
            cliente.setNome(result.getString("Nome"));
            cliente.setRg(result.getString("RG"));
            cliente.setCpf(result.getString("Cpf"));
            cliente.setDataNascimento(result.getString("DataNascimento"));
            cliente.setRua(result.getString("Rua"));
            cliente.setLogradouro(result.getString("Logradouro"));
            cliente.setCep(result.getString("Cep"));
            cliente.setNumero(result.getString("Numero"));
            cliente.setBairro(result.getString("Bairro"));
            cliente.setCidade(result.getString("Cidade"));
        }
        
 
       return cliente;
    }
    
    public void Editar(Cliente cliente) throws SQLException {
       String sql = "UPDATE tbCliente SET "
               + "Nome=?, "
               + "RG=?, "
               + "Cpf=?, "
               + "DataNascimento=?, "
               + "Email=?, "
               + "Rua=?, "
               + "Logradouro=?, "
               + "Cep=?, "
               + "Numero=?, "
               + "Bairro=?, "
               + "Cidade=? "
               + "WHERE IdCliente=?";
       
       conn = Conexao.getConexaoMySQL();
       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getRg());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getDataNascimento());
        statement.setString(5, cliente.getEmail());
        statement.setString(6, cliente.getRua());
        statement.setString(7, cliente.getLogradouro());
        statement.setString(8, cliente.getCep());
        statement.setString(9, cliente.getNumero());
        statement.setString(10, cliente.getBairro());
        statement.setString(11, cliente.getCidade());
        statement.setInt(12, cliente.getID());
       
       int rowsUpdated = statement.executeUpdate();
       if (rowsUpdated > 0) {
            System.out.println("Cliente atualizado!");
       } else {
            System.out.println("Erro ao atualizar o cliente.");
       }
       

   }
    
       public void Excluir(int id) throws SQLException {
        String sql = "DELETE FROM tbCliente WHERE IdCliente=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Cliente excluido com sucesso!");
        } else {
            System.out.println("Erro ao excluir o cliente.");
        }
    }
}
