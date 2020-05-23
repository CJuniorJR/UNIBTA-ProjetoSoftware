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
public class TipoProduto {
    private int ID;
    private String Descricao;
//TODO    
    
    TipoProduto(int id, String descricao) {
        this.ID = id;
        this.Descricao = descricao;
    }

    public int getID() {
        return ID;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
}
