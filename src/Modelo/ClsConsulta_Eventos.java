/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
//Importar librerias necesarias
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * 
 */
public class ClsConsulta_Eventos extends ClsConexion{ //aqui se hace un extends de la clase conexion para usar el metodo de conectar
    //Metodo Para Guardar
     public boolean Guardar(Eventos eventos){
            PreparedStatement ps =null; 
            Connection con= (Connection)getConexion();
            String sql="INSERT INTO eventos(nombre_evento, fecha_inicio, fecha_fin, lugar) VALUES (?,?,?,?)";
            
        try {    
            ps=con.prepareStatement(sql);
            ps.setString(1, eventos.getNombre_evento());
            ps.setDate(3, new java.sql.Date(eventos.getFecha_inicio().getTime()));
            ps.setDate(2, new java.sql.Date(eventos.getFecha_fin().getTime()));
            ps.setString(4, eventos.getLugar());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
     //Metodo Para Editar
     public boolean Modificar(Eventos eventos){
           PreparedStatement ps =null;
           Connection con= (Connection)getConexion();
           String sql="UPDATE eventos SET nombre_evento=?,fecha_inicio=?,fecha_fin=?,lugar=? WHERE id_evento=? ";
            
        try {    
            ps=con.prepareStatement(sql);
            ps.setString(1, eventos.getNombre_evento());
            ps.setDate(3, new java.sql.Date(eventos.getFecha_inicio().getTime()));
            ps.setDate(2, new java.sql.Date(eventos.getFecha_fin().getTime()));
            ps.setString(4, eventos.getLugar());
            ps.setInt(5, eventos.getId_evento());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
     //Metodo Para Eliminar
     public boolean Eliminar(Eventos eventos){
            PreparedStatement ps =null;
            Connection con= (Connection)getConexion();
            String sql="DELETE FROM eventos WHERE id_evento=?";
            
        try {    
            ps=con.prepareStatement(sql);
            ps.setInt(1, eventos.getId_evento());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
     //Metodo Para Mostrar Todos Los Eventos
    public List MostrarEventos()throws Exception{
         ResultSet res;
         List obList = new ArrayList();
         PreparedStatement ps =null;
         Connection con= (Connection)getConexion();
         String sql="select * from eventos";
         try {
             ps=con.prepareStatement(sql);
             res = ps.executeQuery();
             while (res.next()) {                 
                Eventos obj = new Eventos();
                obj.setId_evento(res.getInt("id_evento"));
                obj.setNombre_evento(res.getString("nombre_evento"));
                obj.setFecha_inicio(res.getDate("fecha_inicio"));
                obj.setFecha_fin(res.getDate("fecha_fin"));
                obj.setLugar(res.getString("lugar"));
                
                obList.add(obj);
             }
         } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
                }
        }return obList;
     }
    //Metodo Para Buscar Eventos
    public boolean BuscarEventos(Eventos obj){
    PreparedStatement ps =null;
    Connection con= (Connection)getConexion();
    ResultSet res=null;
    String sql="SELECT * FROM eventos WHERE nombre_evento=?";
            
        try {    
            ps=con.prepareStatement(sql);
             ps.setString(1, obj.getNombre_evento());
            res=ps.executeQuery();
            //paso el resultado de la consulta al modelo
           if(res.next())
            {
                obj.setId_evento(res.getInt("id_evento"));
                obj.setNombre_evento(res.getString("nombre_evento"));
                obj.setFecha_inicio(res.getDate("fecha_inicio"));
                obj.setFecha_fin(res.getDate("fecha_fin"));
                obj.setLugar(res.getString("lugar"));
                return true;  
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    //Metodo Para Listar Mi Busqueda de Eventos
    public List ListarBussqueda(String nombre)throws Exception{
         ResultSet res;
         List listaemp = new ArrayList();
         PreparedStatement ps =null;
         Connection con= (Connection)getConexion();
         String sql="SELECT * FROM eventos WHERE nombre_evento=?";
         try {
             
             ps=con.prepareStatement(sql);
             ps.setString(1, nombre);
             res = ps.executeQuery();
             while (res.next()) {                 
                Eventos obj = new Eventos();
                obj.setId_evento(res.getInt("id_evento"));
                obj.setNombre_evento(res.getString("nombre_evento"));
                obj.setFecha_inicio(res.getDate("fecha_inicio"));
                obj.setFecha_fin(res.getDate("fecha_fin"));
                obj.setLugar(res.getString("lugar"));
                listaemp.add(obj);
             }
         } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
                }
        }return listaemp;
    }
}
