/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Models;

import java.util.ArrayList;

/**
 *
 * @author Rogério
 */
public class Venda {
    
     private int ID;
     private double Total;
     private Cliente Cliente;
     private String FormaPagamento;
     private String Data;  
     private ArrayList<Produto> produtos;

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
     
     public Venda() {
         
     }
     
     public Venda(int id, Cliente cliente, String formaPagamento, String data, Double total) {
         this.ID = id;
         this.Cliente = cliente;
         this.FormaPagamento = formaPagamento;
         this.Data = data;
         this.Total = total;
     }
     
     
 public int getID() {
     return this.ID;
    }

public void setID(int ID) {
        this.ID = ID;
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
