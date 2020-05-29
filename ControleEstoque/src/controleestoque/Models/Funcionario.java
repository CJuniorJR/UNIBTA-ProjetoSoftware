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
public class Funcionario extends Pessoa {
    private int ID;
    private String Email;
    private String Senha;
    
    public Funcionario () {}
    
    public Funcionario(int id, String email, String nome, String rg, String cpf, String dataNascimento, String rua, String logradouro, String cep, String numero, String bairro, String cidade, String senha) {
         this.ID = id;
         this.Email = email;
         this.setNome(nome);
         this.setRg(rg);
         this.setCpf(cpf);
         this.setDataNascimento(dataNascimento);
         this.setRua(rua);
         this.setLogradouro(logradouro);
         this.setCep(cep);
         this.setNumero(numero);
         this.setBairro(bairro);
         this.setCidade(cidade);
         this.setSenha(senha);
     }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSenha() {
        return this.Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
