/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;
import controleestoque.Models.Origem;
import controleestoque.Models.Cliente;
import controleestoque.Models.Fornecedor;
import controleestoque.Views.OrigemView;


import java.sql.*;
import java.util.ArrayList;
import java.time.*;
/**
 *
 * @author guilhermemarques
 */
public class OrigemController extends javax.swing.JFrame {
    Connection conn;

    public void Salvar(Origem origem) throws SQLException {
        String sql = "INSERT INTO tbOrigem (Nome, Fornecedor, Cliente, Produto, Quantidade, Total, Data) VALUES (?,?,?,?,?,?,?)";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, origem.getNome());
        statement.setString(2, origem.getDescricao());
        statement.setDouble(3, origem.getPreco());
        statement.setString(4, origem.getTipoOrigem().getDescricao());
        statement.setString(5, origem.getCategoria().getDescricao());
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
             System.out.println("Origem salva com sucesso!");
        } else {
            System.out.println("Erro ao salvar a origem.");
        }
       Conexao.FecharConexao();
    }
    
    public ArrayList<Origem> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbOrigem";
 
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        ArrayList<Origem> origens = new ArrayList<Origem>();
        while (result.next()){
            origems.add(
                    new Origem(
                            result.getInt("IdOrigem"), 
                            result.getString("Nome"),
                            result.getString("Descricao"),
                            result.getDouble("Preco"),
                            result.getString("IdCategoria"),
                            result.getString("IdTipoOrigem")
                    )
            );
        }
        
        Conexao.FecharConexao();
       return origems;
   }
    
    public Origem Consultar(int idOrigem) throws SQLException {
        String sql = "SELECT * from tbOrigem WHERE IdOrigem=?;";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idOrigem);
        
        ResultSet result = statement.executeQuery();
        Origem origem = new Origem();
        while (result.next()){
            origem.setID(result.getInt("IdOrigem"));
            origem.setNome(result.getString("Nome"));
            origem.setDescricao(result.getString("Descricao"));
            origem.setPreco(result.getDouble("Preco"));
            origem.setCategoria(new Categoria(result.getString("IdCategoria")));
            origem.setTipoOrigem(new TipoOrigem(result.getString("IdTipoOrigem")));
        }
        
        Conexao.FecharConexao();
       return origem;
    }
    
    public void Editar(Origem origem) throws SQLException {
       String sql = "UPDATE tbOrigem SET "
               + "Nome=?, "
               + "Descricao=?, "
               + "Preco=?, "
               + "IdCategoria=?, "
               + "IdTipoOrigem=? "
               + "WHERE IdOrigem=?";
       
       conn = Conexao.getConexaoMySQL();
       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, origem.getNome());
        statement.setString(2, origem.getDescricao());
        statement.setDouble(3, origem.getPreco());
        statement.setString(4, origem.getCategoria().getDescricao());
        statement.setString(5, origem.getTipoOrigem().getDescricao());
        statement.setInt(6, origem.getID());
       
       int rowsUpdated = statement.executeUpdate();
       if (rowsUpdated > 0) {
            System.out.println("Origem atualizado!");
       } else {
            System.out.println("Erro ao atualizar a origem.");
       }
       
       Conexao.FecharConexao();
   }
    
       public void Excluir(int id) throws SQLException {
        String sql = "DELETE FROM tbOrigem WHERE IdOrigem=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Origem excluido com sucesso!");
        } else {
            System.out.println("Erro ao excluir a origem.");
        }
    }
    
}
