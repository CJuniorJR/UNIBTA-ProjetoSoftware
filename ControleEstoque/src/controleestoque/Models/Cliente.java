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
public class Cliente extends Endereco {
     private int ID;
     private Venda Venda;
     private String Nome;
     
     
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    } 
    
     public Venda getVenda() {
        return this.Venda;
    }

    public void setVenda(Venda Venda) {
        this.Venda = Venda;
    }
     
       public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
     
           
}
