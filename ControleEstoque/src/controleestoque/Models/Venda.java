/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Models;

/**
 *
 * @author Junior
 */
public class Venda {
     private int ID;
     private ProdutoVenda ProdutoVenda;
     private double Total;
     private Cliente Cliente;
     private Funcionario Funcionario;
     private String FormaPagamento;
     private String Data;  
     
     
 public int getID() {
     return this.ID;
    }

public void setID(int ID) {
        this.ID = ID;
  }
  
      public ProdutoVenda ProdutoVenda() {
        return this.ProdutoVenda;
    }

  public void ProdutoVenda(ProdutoVenda ProdutoVenda) {
        this.ProdutoVenda = ProdutoVenda;
    }
     
  
   public double Total() {
        return this.Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;      
    } 
    
    
       public Cliente Cliente() {
        return this.Cliente;
    }      

  public void Cliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }  
  
  
   public Funcionario getFuncionario() {
        return this.Funcionario;
    }

    public void setFuncionario(Funcionario Funcionario) {
        this.Funcionario = Funcionario;
    }
    
    
       public String FormaPagamento() {
        return this.FormaPagamento;
    }

    public void setFormaPagamento(String FormaPagamento) {
        this.FormaPagamento = FormaPagamento;
    } 
    
     public String Data() {
        return this.Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }  
}