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
    Connection conn = Conexao.getConexaoMySQL();
    
    public void SalvarProdutoVenda(ProdutoVenda produtoVenda, int idVenda) throws SQLException {
        String sql = "INSERT INTO tbProdutoVenda (IdProduto, Quantidade, Total, IdVenda) VALUES(?, ?, ?, ?)";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, produtoVenda.getProduto().getNome());
        statement.setInt(2, produtoVenda.getQuantidade());
        statement.setDouble(3, produtoVenda.getTotal());
        statement.setInt(4, idVenda);
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            //SalvarProdutoVenda(); 
            System.out.println("ProdutoVenda salva com sucesso!");
             
        } else {
            System.out.println("Erro ao salvar a venda.");
        }
        
        conn.close();
    }
    
     public void Salvar(Venda venda, ArrayList<ProdutoVenda> produtosVenda) throws SQLException {
        String sql = "INSERT INTO tbVenda (Total, IdCliente, FormaPagamento, Data) VALUES (?,?,?,?)";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, venda.getTotal());
        statement.setString(2, venda.getCliente().getNome());
        statement.setString(3, venda.getFormaPagamento());
        statement.setString(4, venda.getData());
        
        statement.execute();
        ResultSet rs = statement.executeQuery("SELECT LAST_INSERT_ID()");
        if (rs.next()) {
            for (ProdutoVenda produtoVenda : produtosVenda) {
                SalvarProdutoVenda(produtoVenda, rs.getInt("LAST_INSERT_ID()")); 
                SubtrairQuantidadeProduto(produtoVenda);
            }
            
            System.out.println("Venda salva com sucesso!");
             
        } else {
            System.out.println("Erro ao salvar a venda.");
        }
        
        conn.close();
    }
     
    public void SubtrairQuantidadeProduto(ProdutoVenda produto) throws SQLException {
        String sql = "UPDATE tbProduto SET Quantidade = Quantidade - ? WHERE Nome = ?";

        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, produto.getQuantidade());
        statement.setString(2, produto.getProduto().getNome());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0){
            System.out.println("Quantidade de produto atualizada com sucesso!");
        } else{
            System.out.println("Erro ao atualizar a quantidade de produtos!");
        }
        
        conn.close();
         
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
                            new Cliente(result.getString("IdCliente")),
                            result.getString("FormaPagamento"),
                            result.getString("Data"),
                            result.getDouble("Total")
                    )
            );
        }
        

        conn.close();
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
        
        conn.close();
       return venda;
    }
    
       public void Excluir(int id) throws SQLException {
        String sql = "DELETE FROM tbVenda WHERE IdVenda=?";
 
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Venda excluido com sucesso!");
        } else {
            System.out.println("Erro ao excluir a venda.");
        }
        
        conn.close();
    }
       
    public ArrayList<ProdutoVenda> ConsultarProdutosVenda(int idVenda) throws SQLException {
        String sql = "SELECT * from tbProdutoVenda WHERE IdVenda=?;";
        
        conn = Conexao.getConexaoMySQL();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idVenda);
        
        ResultSet result = statement.executeQuery();
        ArrayList<ProdutoVenda> produtosVenda = new ArrayList<ProdutoVenda>();
        while (result.next()){
            produtosVenda.add(
                    new ProdutoVenda(
                            result.getInt("IdProdutoVenda"), 
                            result.getString("IdProduto"),
                            result.getDouble("Total")
                    )
            );
        }
        
        conn.close();
       return produtosVenda;
    }
}
