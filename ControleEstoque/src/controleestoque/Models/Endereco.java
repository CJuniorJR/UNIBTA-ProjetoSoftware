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
public class Endereco {
    private String Rua;
    private String Logradouro;
    private String Cep;
    private String Numero;
    private String Bairro;
    private String Cidade;

    public String getRua() {
        return this.Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getLogradouro() {
        return this.Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public String getCep() {
        return this.Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public String getNumero() {
        return this.Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getBairro() {
        return this.Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return this.Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }
    
    
}
