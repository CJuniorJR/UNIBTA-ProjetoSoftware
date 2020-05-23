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
public class Categoria {
    private int ID;
    private String Descricao;
    
    public Categoria(String descricao) {
        this.Descricao = descricao;
    }
    
    public Categoria(int id, String descricao) {
        this.ID = id;
        this.Descricao = descricao;
    }
   
    public int getID() {
        return this.ID;
    }
    
    public String getDescricao() {
        return this.Descricao;
    }
    
    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }
}
