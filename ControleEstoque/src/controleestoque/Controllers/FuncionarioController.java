/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;

import controleestoque.Models.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sedden
 */
public class FuncionarioController {
    Connection conn;
    
    public void Salvar(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO tbFuncionario (Nome, RG, Cpf, DataNascimento, Email, Rua, Logradouro, Cep, Numero, Bairro, Cidade, Senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, funcionario.getNome());
        statement.setString(2, funcionario.getRg());
        statement.setString(3, funcionario.getCpf());
        statement.setString(4, funcionario.getDataNascimento());
        statement.setString(5, funcionario.getEmail());
        statement.setString(6, funcionario.getRua());
        statement.setString(7, funcionario.getLogradouro());
        statement.setString(8, funcionario.getCep());
        statement.setString(9, funcionario.getNumero());
        statement.setString(10, funcionario.getBairro());
        statement.setString(11, funcionario.getCidade());
        statement.setString(12, funcionario.getSenha());
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
             System.out.println("Funcionario salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar o funcionario.");
        }
       Conexao.FecharConexao();
    }
    
    public ArrayList<Funcionario> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbFuncionario";
 
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        while (result.next()){
            funcionarios.add(
                    new Funcionario(
                            result.getInt("IdFuncionario"), 
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
                            result.getString("Cidade"),
                            result.getString("Senha")
                    )
            );
        }
        
        Conexao.FecharConexao();
       return funcionarios;
   }
    
    public Funcionario Consultar(int idFuncionario) throws SQLException {
        String sql = "SELECT * from tbFuncionario WHERE IdFuncionario=?;";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idFuncionario);
        
        ResultSet result = statement.executeQuery();
        Funcionario funcionario = new Funcionario();
        while (result.next()){
            funcionario.setID(result.getInt("IdFuncionario"));
            funcionario.setEmail(result.getString("Email"));
            funcionario.setNome(result.getString("Nome"));
            funcionario.setRg(result.getString("RG"));
            funcionario.setCpf(result.getString("Cpf"));
            funcionario.setDataNascimento(result.getString("DataNascimento"));
            funcionario.setRua(result.getString("Rua"));
            funcionario.setLogradouro(result.getString("Logradouro"));
            funcionario.setCep(result.getString("Cep"));
            funcionario.setNumero(result.getString("Numero"));
            funcionario.setBairro(result.getString("Bairro"));
            funcionario.setCidade(result.getString("Cidade"));
            funcionario.setSenha(result.getString("Senha"));
        }
        
        Conexao.FecharConexao();
       return funcionario;
    }
    
    public void Editar(Funcionario funcionario) throws SQLException {
       String sql = "UPDATE tbFuncionario SET "
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
               + "Cidade=?, "
               + "Senha=?"
               + "WHERE IdFuncionario=?";
       
       conn = Conexao.getConexaoMySQL();
       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, funcionario.getNome());
        statement.setString(2, funcionario.getRg());
        statement.setString(3, funcionario.getCpf());
        statement.setString(4, funcionario.getDataNascimento());
        statement.setString(5, funcionario.getEmail());
        statement.setString(6, funcionario.getRua());
        statement.setString(7, funcionario.getLogradouro());
        statement.setString(8, funcionario.getCep());
        statement.setString(9, funcionario.getNumero());
        statement.setString(10, funcionario.getBairro());
        statement.setString(11, funcionario.getCidade());
        statement.setString(12, funcionario.getSenha());
        statement.setInt(13, funcionario.getID());
       
       int rowsUpdated = statement.executeUpdate();
       if (rowsUpdated > 0) {
            System.out.println("Funcionario atualizado!");
       } else {
            System.out.println("Erro ao atualizar o funcionario.");
       }
       
       Conexao.FecharConexao();
   }
    
       public void Excluir(int id) throws SQLException {
        String sql = "DELETE FROM tbFuncionario WHERE IdFuncionario=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Funcionario excluido com sucesso!");
        } else {
            System.out.println("Erro ao excluir o funcionario.");
        }
    }
}
