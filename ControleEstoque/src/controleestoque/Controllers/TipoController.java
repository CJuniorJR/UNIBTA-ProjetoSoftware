/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;

import controleestoque.Models.TipoProduto;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author guilhermemarques
 */
public class TipoController extends javax.swing.JFrame {
       Connection conn;

   public void Salvar(TipoProduto tipo) throws SQLException {
       String sql = "INSERT INTO tbTipoProduto (Descricao) VALUES (?)";
       
       conn = Conexao.getConexaoMySQL();
       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, tipo.getDescricao());
       
       int rowsInserted = statement.executeUpdate();
       if (rowsInserted > 0) {
            System.out.println("Tipo salvo com sucesso!");
       } else {
           System.out.println("Erro ao salvar o tipo.");
       }
       Conexao.FecharConexao();
   }
   
      public ArrayList<TipoProduto> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbTipoProduto";
 
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        ArrayList<TipoProduto> tipos = new ArrayList<TipoProduto>();
        while (result.next()){
            tipos.add(new TipoProduto(result.getInt("IdTipoProduto"), result.getString("Descricao")));
        }
        
        Conexao.FecharConexao();
       return tipos;
   }
      
      public void Editar(TipoProduto tipo) throws SQLException {
       String sql = "UPDATE tbTipoProduto SET Descricao=? WHERE IdTipoProduto=?";
       
       conn = Conexao.getConexaoMySQL();
       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, tipo.getDescricao());
       statement.setInt(2, tipo.getID());
       
       int rowsUpdated = statement.executeUpdate();
       if (rowsUpdated > 0) {
            System.out.println("Tipo atualizado!");
       } else {
            System.out.println("Erro ao atualizar o tipo do produto.");
       }
       
       Conexao.FecharConexao();
   }
      
         public void Excluir(TipoProduto tipoProduto) throws SQLException {
        String sql = "DELETE FROM tbTipoProduto WHERE IdTipoProduto=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, tipoProduto.getID());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Tipo excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir o tipo.");
        }
    }
}
