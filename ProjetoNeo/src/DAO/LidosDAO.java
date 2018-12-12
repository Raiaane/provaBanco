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
            ps.setInt(3,f.getCategoria());
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
                f.setCodigo(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setAutor(rs.getString(3));
                f.setCategoria(rs.getInt(4));
                
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
                f.setCategoria(rs.getInt(4));
                
               
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
      public List<Lidos> ListarComboLidos(){
    String sql = "SELECT Nome FROM lidos";
    List<Lidos> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           if(rs!=null){
           while(rs.next()){
           Lidos c = new Lidos();
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
        public List<Lidos> ConsultaCodigoLidos(String nome){
    String sql = "SELECT id FROM lidos WHERE nome ='"+nome+"'";
    List<Lidos> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs!=null){
            while (rs.next()) {                
            Lidos c = new Lidos();
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
       public String ExcluirLidos(Lidos c){
   String sql = "DELETE FROM lidos WHERE id = ?";
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
       public boolean Testar_Lidos(int cod){
   boolean result = false;
   
       try{
          String sql = "SELECT * FROM lidos WHERE id = '"+cod+"'";
           
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs!= null){
          while(rs.next()){
          result = true;
          }
          }
          
       }catch(SQLException ex) {
          ex.getMessage();
       }
       return result;
   }
       public List<Lidos> CapturarLidos(int cod){
    String sql = "SELECT * FROM lidos WHERE id = '"+cod+"'";
    List<Lidos> lista = new ArrayList<>();
        try {
            PreparedStatement pr = getCon().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs!=null){
                while(rs.next()){
                Lidos f = new Lidos();
                f.setCodigo(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setAutor(rs.getString(3));
                f.setCategoria(rs.getInt(4));
                f.setDataT(rs.getString(5));
                f.setCapa(rs.getString(6));
                lista.add(f);
                }
                return lista;
            }else{
                return null;
            }                    
        } catch (SQLException ex) {
            return null;
        }
       }
       public String Alterar_Lidos(Lidos f){
   String sql = "UPDATE lidos SET nome = ? ,autor = ? ,categoria = ? ,datat = ? ,capa = ? WHERE id = ?";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           ps.setString(1,f.getNome());
           ps.setString(2,f.getAutor());
           ps.setInt(3,f.getCategoria());
           ps.setString(4, f.getDataT());
           ps.setString(5,f.getCapa());
           ps.setInt(6,f.getCodigo());
           if (ps.executeUpdate() >0) {
               return "livro Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   
   }
}

