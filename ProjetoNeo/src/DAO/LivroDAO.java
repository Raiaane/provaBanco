
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Livro;
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
     public List<Livro> ListarLivro(){
   String sql = "SELECT * FROM produto";
   List<Livro> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Livro f = new Livro();
                f.setCodigo(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setAutor(rs.getString(3));
                f.setCategoria(rs.getString(4));
                f.setSinopse(rs.getString(5));
                f.setQuantidade(rs.getString(6));
                f.setDataC(rs.getString(7));
                f.setDataT(rs.getString(8));
                f.setCapa(rs.getString(9));
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
   //Consultar
   public List<Livro> Listar_Nome_Livro(String nome){
   String sql = "SELECT * FROM produto WHERE nome LIKE '%"+nome+"%'";
   List<Livro> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Livro f = new Livro();
                f.setCodigo(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setAutor(rs.getString(3));
                f.setCategoria(rs.getString(4));
                f.setSinopse(rs.getString(5));
                f.setQuantidade(rs.getString(6));
                f.setDataC(rs.getString(7));
                f.setDataT(rs.getString(8));
                
                f.setCapa(rs.getString(9));
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
    public String ExcluirLivro(Livro c){
   String sql = "DELETE FROM produto WHERE id = ?";
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
     public List<Livro> ListarComboLivro(){
    String sql = "SELECT Nome FROM produto";
    List<Livro> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           if(rs!=null){
           while(rs.next()){
           Livro c = new Livro();
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
     public List<Livro> ConsultaCodigoLivro(String nome){
    String sql = "SELECT id FROM produto WHERE nome ='"+nome+"'";
    List<Livro> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs!=null){
            while (rs.next()) {                
            Livro c = new Livro();
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
       public boolean Testar_Livro(int cod){
   boolean result = false;
   
       try{
          String sql = "SELECT * FROM produto WHERE id = '"+cod+"'";
           
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
       public List<Livro> CapturarLivro(int cod){
    String sql = "SELECT * FROM produto WHERE id = '"+cod+"'";
    List<Livro> lista = new ArrayList<>();
        try {
            PreparedStatement pr = getCon().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Livro f = new Livro();
                    f.setCodigo(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setAutor(rs.getString(3));
                    f.setCategoria(rs.getString(4));
                    f.setSinopse(rs.getString(5));
                    f.setQuantidade(rs.getString(6));
                    f.setDataC(rs.getString(7));
                    f.setDataT(rs.getString(8));
                     f.setCapa(rs.getString(9));
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
       //Alterar
     public String Alterar_Livro(Livro f){
   String sql = "UPDATE produto SET nome = ? ,autor = ? ,categoria = ?, sinopse = ? ,qnt = ? ,dataC = ? ,dataT = ? ,Capa = ? WHERE idfilme = ?";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           ps.setString(1,f.getNome());
           ps.setString(2,f.getAutor());
           ps.setString(3,f.getCategoria());
           ps.setString(4, f.getSinopse());
           ps.setString(5, f.getQuantidade());
           ps.setString(6, f.getDataC());
           ps.setString(7, f.getDataT());
           ps.setString(8,f.getCapa());
           ps.setInt(9,f.getCodigo());
           if (ps.executeUpdate() >0) {
               return "Filme Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   
   }
}


