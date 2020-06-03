/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;
import controleestoque.Models.Produto;
import controleestoque.Models.Categoria;
import controleestoque.Models.TipoProduto;
import controleestoque.Views.FormProdutoView;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author guilhermemarques
 */
public class ProdutoController extends javax.swing.JFrame {
    Connection conn = Conexao.getConexaoMySQL();
    
     public void Salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO tbProduto (Nome, Descricao, Preco, IdTipoProduto, IdCategoria) VALUES (?,?,?,?,?)";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getDescricao());
        statement.setDouble(3, produto.getPreco());
        statement.setString(4, produto.getTipoProduto().getDescricao());
        statement.setString(5, produto.getCategoria().getDescricao());
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
             System.out.println("Produto salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar o produto.");
        }
        
        conn.close();
       Conexao.FecharConexao();
    }
    
    public ArrayList<Produto> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbProduto";
 
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        while (result.next()){
            produtos.add(
                    new Produto(
                            result.getInt("IdProduto"), 
                            result.getString("Nome"),
                            result.getString("Descricao"),
                            result.getDouble("Preco"),
                            result.getString("IdCategoria"),
                            result.getString("IdTipoProduto"),
                            result.getInt("Quantidade")
                    )
            );
        }
        
        conn.close();
       return produtos;
   }
    
    public Produto Consultar(int idProduto) throws SQLException {
        String sql = "SELECT * from tbProduto WHERE IdProduto=?;";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idProduto);
        
        ResultSet result = statement.executeQuery();
        Produto produto = new Produto();
        while (result.next()){
            produto.setID(result.getInt("IdProduto"));
            produto.setNome(result.getString("Nome"));
            produto.setDescricao(result.getString("Descricao"));
            produto.setPreco(result.getDouble("Preco"));
            produto.setCategoria(new Categoria(result.getString("IdCategoria")));
            produto.setTipoProduto(new TipoProduto(result.getString("IdTipoProduto")));
        }
        
        conn.close();
       return produto;
    }
    
    public void Editar(Produto produto) throws SQLException {
       String sql = "UPDATE tbProduto SET "
               + "Nome=?, "
               + "Descricao=?, "
               + "Preco=?, "
               + "IdCategoria=?, "
               + "IdTipoProduto=? "
               + "WHERE IdProduto=?";
       
       conn = Conexao.getConexaoMySQL();
       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, produto.getNome());
        statement.setString(2, produto.getDescricao());
        statement.setDouble(3, produto.getPreco());
        statement.setString(4, produto.getCategoria().getDescricao());
        statement.setString(5, produto.getTipoProduto().getDescricao());
        statement.setInt(6, produto.getID());
       
       int rowsUpdated = statement.executeUpdate();
       if (rowsUpdated > 0) {
            System.out.println("Produto atualizado!");
       } else {
            System.out.println("Erro ao atualizar o produto.");
       }
       
       conn.close();
   }
    
       public void Excluir(int id) throws SQLException {
        String sql = "DELETE FROM tbProduto WHERE IdProduto=?";
 
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Produto excluido com sucesso!");
        } else {
            System.out.println("Erro ao excluir o produto.");
        }
        
        conn.close();
    }
}
