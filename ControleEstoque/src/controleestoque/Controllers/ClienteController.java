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
    Connection conn;
    
    public void Salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO tbCliente (Nome, RG, Cpf, DataNascimento, Email, Rua, Logradouro, Cep, Numero, Bairro, Cidade) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
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
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
             System.out.println("Cliente salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar o cliente.");
        }
       Conexao.FecharConexao();
    }
    
    public ArrayList<Cliente> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbCliente";
 
        conn = Conexao.getConexaoMySQL();
        
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
        }
        
        Conexao.FecharConexao();
       return clientes;
   }
}
