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
public class Fornecedor extends Endereco {
    private int ID;
    private String Nome;
    private String Email;
    private String Cnpj;

    public Fornecedor() {}
    
    public Fornecedor(String nome) {
        this.Nome = nome;
    }
    
    public Fornecedor(int id, String email, String nome, String cnpj,  String rua, String logradouro, String cep, String numero, String bairro, String cidade) {
         this.ID = id;
         this.Email = email;
         this.setNome(nome);
         this.setCnpj(cnpj);
         this.setRua(rua);
         this.setLogradouro(logradouro);
         this.setCep(cep);
         this.setNumero(numero);
         this.setBairro(bairro);
         this.setCidade(cidade);
     }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }
}
