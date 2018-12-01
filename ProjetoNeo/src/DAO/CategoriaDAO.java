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
         public String ExcluirCategoria(Categoria c){
   String sql = "DELETE FROM categoria WHERE id = ?";
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1,c.getCodigo());
           if(ps.executeUpdate()>0){
           return "Excluido com sucesso";
           }else{
           return "Erro ao excluir";
           }           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   }
   public List<Categoria> Pesquisar_Nome_Categoria(String nome){
        String sql = "select idcategoria, nome from categoria where nome Like '"+nome+ "%'";
         List <Categoria> lista = new ArrayList<>();
        
        try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                  Categoria a = new Categoria();
                  a.setCodigo(rs.getInt(1));
                  a.setNome(rs.getString(2));
                  
                  
                  lista.add(a);
                  
              }
              return lista;
          }else{
              return null;
          }
          
 
        }catch (SQLException e){
            return null;
        
        }
    
    }
    public List<Categoria> Pesquisar_Cod_Categoria(int cod){
   String sql = "SELECT * FROM categoria WHERE idcategoria ='"+cod+"'";
   List<Categoria> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Categoria a = new Categoria();
                a.setCodigo(rs.getInt(1));
                a.setNome(rs.getString(2));
               
                lista.add(a);
                
               }   
               return lista;
           }else{
           return null;
           }
       }catch (SQLException e) {
       return null;
       }
   }
    
}


