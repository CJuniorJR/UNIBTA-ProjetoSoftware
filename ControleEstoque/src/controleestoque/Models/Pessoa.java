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
public class Pessoa extends Endereco {
    private static String Nome;
    private String Rg;
    private String Cpf;
    private String DataNascimento;

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRg() {
        return this.Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getCpf() {
        return this.Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }
    
    public String getDataNascimento() {
        return this.DataNascimento;
    }
    
    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }
    
}
