/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;
import controleestoque.Models.Funcionario;
import java.sql.*;
/**
 *
 * @author sedden
 */
public class LoginController {
    Connection conn = Conexao.getConexaoMySQL();
    
    public Funcionario Login(String email, String senha) throws SQLException {
        String sql = "SELECT * from tbFuncionario WHERE Email=? AND Senha=?";
        

        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, senha);
        
        ResultSet result = statement.executeQuery();
        Funcionario funcionario = new Funcionario();
        while (result.next()){
            funcionario.setID(result.getInt("IdFuncionario"));
            funcionario.setEmail(result.getString("Email"));
            funcionario.setNome(result.getString("Nome"));
            funcionario.setRg(result.getString("RG"));
            funcionario.setCpf(result.getString("Cpf"));
            funcionario.setDataNascimento(result.getString("DataNascimento"));
            funcionario.setRua(result.getString("Rua"));
            funcionario.setLogradouro(result.getString("Logradouro"));
            funcionario.setCep(result.getString("Cep"));
            funcionario.setNumero(result.getString("Numero"));
            funcionario.setBairro(result.getString("Bairro"));
            funcionario.setCidade(result.getString("Cidade"));
            funcionario.setSenha(result.getString("Senha"));
        }
        

       return funcionario;
    }
}
