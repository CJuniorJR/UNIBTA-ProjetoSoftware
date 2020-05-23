/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Controllers;

import java.sql.Connection;
import controleestoque.Models.Categoria;

/**
 *
 * @author sedden
 */
public class CategoriaController {
   Connection conn;
   public static void main(String[] args) {
       Conexao con = new Conexao();
       
       con.getConexaoMySQL();
       System.out.println(Conexao.statusConection());
    }
    
}
