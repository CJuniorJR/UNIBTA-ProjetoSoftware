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
public class Cliente extends Pessoa {
     private int ID;
     private String Email;
     private Venda Venda;
     
     public Cliente() {}
     public Cliente(String nome) {
         this.setNome(nome);
     }
  
     public Cliente(int id, String email, String nome, String rg, String cpf, String dataNascimento, String rua, String logradouro, String cep, String numero, String bairro, String cidade) {
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
     }
     
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Venda getVenda() {
        return Venda;
    }

    public void setVenda(Venda Venda) {
        this.Venda = Venda;
    }
    
     
     
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    } 
    
}