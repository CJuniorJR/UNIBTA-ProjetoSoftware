/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Models;

/**
 *
 * @author sedden
 */
public class ProdutoVenda {
    private int ID;
    private Venda Venda;
    private Produto Produto;
    private int Quantidade;
    private double Total;
    
    public ProdutoVenda() {}
    
    public ProdutoVenda(Produto produto, int quantidade, double total) {
        this.Produto = produto;
        this.Quantidade = quantidade;
        this.Total = total;
    }
    
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public Venda getVenda() {
        return Venda;
    }

    public void setVenda(Venda Venda) {
        this.Venda = Venda;
    }
    
    public Produto getProduto() {
        return this.Produto;
    }
    
    public void setProduto(Produto produto) {
        this.Produto = produto;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
}
