/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raiane
 */
public class LivroDAO extends ExecuteSQL {
    public LivroDAO(Connection con){
    super(con);
    }
    
    public String InserirLivro(Livro f){
      String sql = "INSERT INTO produto VALUES (0,?,?,?,?,?,?,?,?)";  
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,f.getNome());
            ps.setString(2,f.getAutor());
            ps.setString(3,f.getCategoria());
            ps.setString(4,f.getSinopse());
            ps.setString(5,f.getQuantidade());
            ps.setString(6,f.getDataC());
            ps.setString(7,f.getDataT());
            ps.setString(8,f.getCapa());
            if(ps.executeUpdate()>0){
            return "iInserido com sucesso";            
            }else{
            return "Erro ao inserir";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
}

