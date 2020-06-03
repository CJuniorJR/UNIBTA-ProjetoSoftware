/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;

import controleestoque.Models.Categoria;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author sedden
 */
public class CategoriaController {
   Connection conn = Conexao.getConexaoMySQL();
   
   
   public void Salvar(Categoria categoria) throws SQLException {
       String sql = "INSERT INTO tbCategoria (Descricao) VALUES (?)";
       

       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, categoria.getDescricao());
       
       int rowsInserted = statement.executeUpdate();
       if (rowsInserted > 0) {
            System.out.println("Categoria salva com sucesso!");
       } else {
           System.out.println("Erro ao salvar a categoria.");
       }

   }
   
   public ArrayList<Categoria> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbCategoria";
 
 
        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        while (result.next()){
            categorias.add(new Categoria(result.getInt("IdCategoria"), result.getString("Descricao")));
        }
        
 
       return categorias;
   }
   
   public void Editar(Categoria categoria) throws SQLException {
       String sql = "UPDATE tbCategoria SET Descricao=? WHERE IdCategoria=?";
       

       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, categoria.getDescricao());
       statement.setInt(2, categoria.getID());
       
       int rowsUpdated = statement.executeUpdate();
       if (rowsUpdated > 0) {
            System.out.println("Categoria atualizada!");
       } else {
            System.out.println("Erro ao atualizar a categoria.");
       }
       

   }
   
   public void Excluir(Categoria categoria) throws SQLException {
        String sql = "DELETE FROM tbCategoria WHERE IdCategoria=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, categoria.getID());

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Categoria excluida com sucesso!");
        } else {
            System.out.println("Erro ao excluir a categoria.");
        }
    }
}
