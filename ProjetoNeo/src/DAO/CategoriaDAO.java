/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raiane
 */
public class CategoriaDAO extends ExecuteSQL{
     public CategoriaDAO(Connection con) {
        super(con);
    }
     //inserir
    public String InserirCategoria(Categoria c){
    
    String sql = "insert into categoria VALUES(0,?)";

    try {
       
        PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, c.getNome());
            
        if(ps.executeUpdate()>0){
        return "Cadastrado com sucesso";
        }else{
        return "Erro ao cadastrar";
        }
        
    } catch (SQLException e) {
        return e.getMessage();
    }
    }
      public List<Categoria> ListarComboCategoria(){
    String sql = "SELECT Nome FROM categoria";
    List<Categoria> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           if(rs!=null){
           while(rs.next()){
           Categoria c = new Categoria();
           c.setNome(rs.getString(1));
           lista.add(c);
           }
           
           }else{
           return null;
           }       
           return lista;
       } catch (SQLException ex) {
         return null;
       }
   
   }
       public List<Categoria> ConsultaCodigoCategoria(String nome){
    String sql = "SELECT id FROM categoria WHERE nome ='"+nome+"'";
    List<Categoria> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs!=null){
            while (rs.next()) {                
            Categoria c = new Categoria();
            c.setCodigo(rs.getInt(1));
            lista.add(c);            
            }
        }else{
        return null;
        }        
        return lista;
       } catch (SQLException ex) {
       return null;
       }
    
   }
}


