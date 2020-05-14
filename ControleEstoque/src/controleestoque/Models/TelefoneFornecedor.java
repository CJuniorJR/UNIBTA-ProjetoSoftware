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
public class TelefoneFornecedor {
    private int ID;
    private String NumTelefone;
    private Fornecedor Fornecedor;

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNumTelefone() {
        return this.NumTelefone;
    }

    public void setNumTelefone(String NumTelefone) {
        this.NumTelefone = NumTelefone;
    }

    public Fornecedor getFornecedor() {
        return this.Fornecedor;
    }

    public void setFornecedor(Fornecedor Fornecedor) {
        this.Fornecedor = Fornecedor;
    }
    
    
}
