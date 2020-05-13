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
public class Produto {
    private int ID;
    private String Descricao;
    private double Preco;
    private Categoria Categoria;
    private TipoProduto TipoProduto;
    private int Quantidade;
    private String Nome;
    
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public double getPreco() {
        return this.Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public TipoProduto getTipoProduto() {
        return TipoProduto;
    }

    public void setTipoProduto(TipoProduto TipoProduto) {
        this.TipoProduto = TipoProduto;
    }


    public int getQuantidade() {
        return this.Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    
}