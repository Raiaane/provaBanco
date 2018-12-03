/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Lidos;
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
public class LidosDAO extends ExecuteSQL {
    public LidosDAO(Connection con){
    super(con);
    }
    
    public String InserirLivro(Lidos f){
      String sql = "INSERT INTO lidos VALUES (0,?,?,?,?,?)";  
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,f.getNome());
            ps.setString(2,f.getAutor());
            ps.setString(3,f.getCategoria());
            ps.setString(4,f.getDataT());
            ps.setString(5,f.getCapa());
            if(ps.executeUpdate()>0){
            return "iInserido com sucesso";            
            }else{
            return "Erro ao inserir";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
        
    }
     public List<Lidos> ListarLivro(){
   String sql = "SELECT * FROM lidos";
   List<Lidos> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Lidos f = new Lidos();
                f.setCodigo(rs.getInt(0));
                f.setNome(rs.getString(1));
                f.setAutor(rs.getString(2));
                f.setCategoria(rs.getString(3));
                
                f.setDataT(rs.getString(4));
                f.setCapa(rs.getString(5));
                lista.add(f);
               }   
               return lista;
           }else{
           return null;
           }
       }catch (SQLException ex) {
       return null;
       }
   }
     public List<Lidos> Listar_Nome_Livro(String nome){
   String sql = "SELECT * FROM lidos WHERE nome LIKE '%"+nome+"%'";
   List<Lidos> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Lidos f = new Lidos();
                f.setCodigo(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setAutor(rs.getString(3));
                f.setCategoria(rs.getString(4));
                
               
                f.setDataT(rs.getString(5));
                
                f.setCapa(rs.getString(6));
                lista.add(f);
               }   
               return lista;
           }else{
           return null;
           }
       }catch (SQLException ex) {
       return null;
       }
   }
}
