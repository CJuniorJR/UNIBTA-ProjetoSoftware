/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;
import controleestoque.Models.Cliente;
import controleestoque.Models.Venda;
import controleestoque.Models.Produto;
import controleestoque.Models.ProdutoVenda;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author guilhermemarques
 */
public class VendaController {
    Connection conn;
    
    public void SalvarProdutoVenda(String produto, int quantidade, Double total, int idVenda) throws SQLException {
        String sql = "INSER INTO tbProdutoVenda (IdProduto, Quantidade, Total, IdVenda) VALUES(?, ?, ?, ?)";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, produto);
        statement.setInt(2, quantidade);
        statement.setDouble(3, total);
        statement.setInt(4, idVenda);
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            //SalvarProdutoVenda(); 
            System.out.println("ProdutoVenda salva com sucesso!");
             
        } else {
            System.out.println("Erro ao salvar a venda.");
        }
       Conexao.FecharConexao();
    }
    
     public void Salvar(Venda venda, int quantidade, double total) throws SQLException {
        String sql = "INSERT INTO tbVenda ( Total, IdCliente, FormaPagamento, Data) VALUES (?,?,?,?)";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, venda.getTotal());
        statement.setString(2, venda.getCliente().getNome());
        statement.setString(3, venda.getFormaPagamento());
        statement.setString(4, venda.getData());
        
        int rowsInserted = statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (rowsInserted > 0) {
            for (Produto produto : venda.getProdutos()) {
                SalvarProdutoVenda(produto.getNome(), quantidade, total, rs.getInt(1)); 
            }
            
            System.out.println("Venda salva com sucesso!");
             
        } else {
            System.out.println("Erro ao salvar a venda.");
        }
       Conexao.FecharConexao();
    }
    
    public ArrayList<Venda> Consultar() throws SQLException {
        String sql = "SELECT * FROM tbVenda";
 
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        ArrayList<Venda> vendas = new ArrayList<Venda>();
        while (result.next()){
            vendas.add(
                    new Venda(
                            result.getInt("IdVenda"), 
                            result.getString("IdCliente"),
                            result.getString("FormaPagamento"),
                            result.getString("Data"),
                            result.getDouble("Total")
                    )
            );
        }
        
        Conexao.FecharConexao();
       return vendas;
   }
    
    public Venda Consultar(int idVenda) throws SQLException {
        String sql = "SELECT * from tbVenda WHERE IdVenda=?;";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idVenda);
        
        ResultSet result = statement.executeQuery();
        Venda venda = new Venda();
        while (result.next()){
            venda.setID(result.getInt("IdVenda"));
            venda.setTotal(result.getDouble("Total"));
            venda.setCliente(new Cliente(result.getString("IdCliente")));
            venda.setFormaPagamento(result.getString("FormaPagamento"));
            venda.setData(result.getString("Data"));
        }
        
        Conexao.FecharConexao();
       return venda;
    }
    
       public void Excluir(int id) throws SQLException {
        String sql = "DELETE FROM tbVenda WHERE IdVenda=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Venda excluido com sucesso!");
        } else {
            System.out.println("Erro ao excluir a venda.");
        }
    }
}
