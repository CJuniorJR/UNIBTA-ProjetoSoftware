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
    Connection conn;

    public void Salvar(Origem origem) throws SQLException {
        String sql = "INSERT INTO tbOrigem (Fornecedor, Cliente, Produto, Quantidade, Total, Data) VALUES (?,?,?,?,?,?)";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, origem.getFornecedor().getNome());
        statement.setString(2, origem.getCliente().getNome());
        statement.setString(3, origem.getProduto().getNome());
        statement.setInt(4, origem.getQuantidade());
        statement.setDouble(5, origem.getTotal());
        statement.setString(6, origem.getData());
        
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
            origens.add(
                    new Origem(
                            result.getInt("IdOrigem"), 
                            result.getString("Fornecedor"),
                            result.getString("Cliente"),
                            result.getString("Produto"),
                            result.getInt("Quantidade"),
                            result.getDouble("Total"),
                            result.getString("Data")
                    )
            );
        }
        
        Conexao.FecharConexao();
       return origens;
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
            origem.setFornecedor(new Fornecedor(result.getString("IdFornecedor")));
            origem.setCliente(new Cliente(result.getString("IdCliente")));
            origem.setProduto(new Produto(result.getString("IdProduto")));
            origem.setQuantidade(result.getInt("Quantidade"));
            origem.setTotal(result.getDouble("Total"));
            origem.setData(result.getString("Data"));
        }
        
        Conexao.FecharConexao();
       return origem;
    }
    
}
