/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Models;

/**
 *
 * @author Rogério
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
  
      public ProdutoVenda getProdutoVenda() {
        return this.ProdutoVenda;
    }

  public void setProdutoVenda(ProdutoVenda ProdutoVenda) {
        this.ProdutoVenda = ProdutoVenda;
    }
     
  
   public double getTotal() {
        return this.Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;      
    } 
    
    
       public Cliente getCliente() {
        return this.Cliente;
    }      

  public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }  
  
  
   public Funcionario getFuncionario() {
        return this.Funcionario;
    }

    public void setFuncionario(Funcionario Funcionario) {
        this.Funcionario = Funcionario;
    }
    
    
       public String getFormaPagamento() {
        return this.FormaPagamento;
    }

    public void setFormaPagamento(String FormaPagamento) {
        this.FormaPagamento = FormaPagamento;
    } 
    
     public String getData() {
        return this.Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }  
}
