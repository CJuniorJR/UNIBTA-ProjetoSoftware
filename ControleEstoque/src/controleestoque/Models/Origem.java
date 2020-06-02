/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Models;

/**
 *
 * @author guilhermemarques
 */
public class Origem {
    private int ID;
    private Fornecedor Fornecedor;
    private Cliente Cliente;
    private Produto Produto;
    private int Quantidade;
    private double Total;
    private String Data;
    private double PrecoCompra;
    
    public Origem (int id, String fornecedor, String cliente, String produto, int quantidade, double total, String data){
        this.ID = id;
        this.setFornecedor(new Fornecedor(fornecedor));
        this.setCliente(new Cliente(cliente));
        this.setProduto(new Produto(produto));
        this.Quantidade = quantidade;
        this.Total = total;
        this.Data = data;
    }

    public Origem() {
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Fornecedor getFornecedor() {
        return this.Fornecedor;
    }

    public void setFornecedor(Fornecedor Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    public Cliente getCliente() {
        return this.Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Produto getProduto() {
        return this.Produto;
    }

    public void setProduto(Produto Produto) {
        this.Produto = Produto;
    }

    public int getQuantidade() {
        return this.Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public double getTotal() {
        return this.Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getData() {
        return this.Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public double getPrecoCompra() {
        return this.PrecoCompra;
    }

    public void setPrecoCompra(double PrecoCompra) {
        this.PrecoCompra = PrecoCompra;
    }
    
}
