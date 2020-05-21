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
public class TelefoneFuncionario {

    private int ID;
    private String NumTelefone;
    private Funcionario Funcionario;
    
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

    public Funcionario getFuncionario() {
        return this.Funcionario;
    }

    public void setFuncionario(Funcionario Funcionario) {
        this.Funcionario = Funcionario;
    }

    
}
