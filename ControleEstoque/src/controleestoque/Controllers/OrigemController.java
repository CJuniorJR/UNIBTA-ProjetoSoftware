/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;
import controleestoque.Models.Origem;
import controleestoque.Models.Cliente;
import controleestoque.Models.Produto;
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
    Connection conn = Conexao.getConexaoMySQL();

    public void Salvar(Origem origem) throws SQLException {
        String sql = "INSERT INTO tbOrigem (IdFornecedor, IdCliente, IdProduto, Quantidade, Total, Data) VALUES (?,?,?,?,?,?)";
        

        
        PreparedStatement statement = conn.prepareStatement(sql);
        if (!origem.getFornecedor().getNome().equals("")) { // origem.getCliente().getNome() != null
            statement.setString(2, "");
            statement.setString(1, origem.getFornecedor().getNome());
        } else {
            statement.setString(2, origem.getCliente().getNome());
            statement.setString(1, "");        
        }
        statement.setString(3, origem.getProduto().getNome());
        statement.setInt(4, origem.getQuantidade());
        statement.setDouble(5, origem.getTotal());
        statement.setString(6, origem.getData());
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
    
            String sqlProduto = "UPDATE tbProduto SET Quantidade = ? WHERE Nome = ?";
    
            statement = conn.prepareStatement(sqlProduto);
            statement.setInt(1, origem.getQuantidade());
            statement.setString(2, origem.getProduto().getNome());
            int rowsProdutoInserted = statement.executeUpdate();
            if (rowsProdutoInserted > 0) {
        
                System.out.println("Quantidade do produto salva com sucesso!");
                this.AdicionarQuantidadeProduto(origem);
            }
            System.out.println("Origem salva com sucesso!");
        } else {
            System.out.println("Erro ao salvar a origem.");
        }
    }
    
    public ArrayList<Origem> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbOrigem";
 

        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        ArrayList<Origem> origens = new ArrayList<Origem>();
        while (result.next()){
            origens.add(
                    new Origem(
                            result.getInt("IdOrigem"), 
                            result.getString("IdFornecedor") != null ? result.getString("IdFornecedor") : "",
                            result.getString("IdCliente") != null ? result.getString("IdCliente") : "",
                            result.getString("IdProduto"),
                            result.getInt("Quantidade"),
                            result.getDouble("Total"),
                            result.getString("Data")
                    )
            );
        }
        

       return origens;
   }
    
    public Origem Consultar(int idOrigem) throws SQLException {
        String sql = "SELECT * from tbOrigem WHERE IdOrigem=?;";
        

        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idOrigem);
        
        ResultSet result = statement.executeQuery();
        Origem origem = new Origem();
        while (result.next()){
            origem.setID(result.getInt("IdOrigem"));
            if (result.getString("IdFornecedor") != null) {
                origem.setFornecedor(new Fornecedor(result.getString("IdFornecedor")));
            } else {
                origem.setFornecedor(new Fornecedor(""));
            }
            if (result.getString("IdCliente") != null) {
                origem.setCliente(new Cliente(result.getString("IdCliente")));
            } else {
                origem.setCliente(new Cliente(""));
            }
            origem.setProduto(new Produto(result.getString("IdProduto")));
            origem.setQuantidade(result.getInt("Quantidade"));
            origem.setTotal(result.getDouble("Total"));
            origem.setData(result.getString("Data"));
        }
        

       return origem;
    }
    
    public void AdicionarQuantidadeProduto(Origem origem) throws SQLException {
        String sql = "UPDATE tbProduto SET Quantidade = Quantidade + ? WHERE Nome = ?";

        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, origem.getQuantidade());
        statement.setString(2, origem.getProduto().getNome());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0){
            System.out.println("Quantidade de produto atualizada com sucesso!");
        } else{
            System.out.println("Erro ao atualizar a quantidade de produtos!");
        }
    }
    
}
