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
public class ClsConsultas_Asistentes extends ClsConexion { //aqui se hace un extends de la clase conexion para usar el metodo de conectar
    //Metodo Para Guardar
     public boolean Guardar(Asistentes asistentes){
            PreparedStatement ps =null; 
            Connection con= (Connection)getConexion();
            String sql="INSERT INTO asistentes(nombre_asistente, email, telefono) VALUES (?,?,?)";
            
        try {    
            ps=con.prepareStatement(sql);
            ps.setString(1, asistentes.getNombre_asistente());
            ps.setString(2, asistentes.getEmail());
            ps.setString(3, asistentes.getTelefono());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
     //Metodo Para Editar
     public boolean Modificar(Asistentes asistentes){
           PreparedStatement ps =null;
           Connection con= (Connection)getConexion();
           String sql="UPDATE asistentes SET nombre_asistente=?,email=?,telefono=? WHERE id_asistente=? ";
            
        try {    
            ps=con.prepareStatement(sql);
            ps.setString(1, asistentes.getNombre_asistente());
            ps.setString(2, asistentes.getEmail());
            ps.setString(3, asistentes.getTelefono());
            ps.setInt(4, asistentes.getId_asistente());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
     //Metodo Para Eliminar
     public boolean Eliminar(Asistentes asistentes){
            PreparedStatement ps =null;
            Connection con= (Connection)getConexion();
            String sql="DELETE FROM asistentes WHERE id_asistente=?";
            
        try {    
            ps=con.prepareStatement(sql);
            ps.setInt(1, asistentes.getId_asistente());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
     //Metodo Para Mostrar Todos Los Asistentes
    public List MostrarAsistentes()throws Exception{
         ResultSet res;
         List obList = new ArrayList();
         PreparedStatement ps =null;
         Connection con= (Connection)getConexion();
         String sql="select * from asistentes";
         try {
             ps=con.prepareStatement(sql);
             res = ps.executeQuery();
             while (res.next()) {                 
                Asistentes obj = new Asistentes();
                obj.setId_asistente(res.getInt("id_asistente"));
                obj.setNombre_asistente(res.getString("nombre_asistente"));
                obj.setEmail(res.getString("email"));
                obj.setTelefono(res.getString("telefono"));
                
                obList.add(obj);
             }
         } catch (SQLException ex) {
            Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
                }
        }return obList;
     }
    //Metodo Para Buscar Asistentes
    public boolean BuscarAsistentes(Asistentes obj){
    PreparedStatement ps =null;
    Connection con= (Connection)getConexion();
    ResultSet res=null;
    String sql="SELECT * FROM asistentes WHERE nombre_asistente=?";
            
        try {    
            ps=con.prepareStatement(sql);
             ps.setString(1, obj.getNombre_asistente());
            res=ps.executeQuery();
            //paso el resultado de la consulta al modelo
           if(res.next())
            {
                obj.setId_asistente(res.getInt("id_asistente"));
                obj.setNombre_asistente(res.getString("nombre_asistente"));
                obj.setEmail(res.getString("email"));
                obj.setTelefono(res.getString("telefono"));
                return true;  
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    //Metodo Para Listar Mi Busqueda de Asistentes
    public List ListarBussqueda(String nombre)throws Exception{
         ResultSet res;
         List listaemp = new ArrayList();
         PreparedStatement ps =null;
         Connection con= (Connection)getConexion();
         String sql="SELECT * FROM asistentes WHERE nombre_asistente=?";
         try {
             
             ps=con.prepareStatement(sql);
             ps.setString(1, nombre);
             res = ps.executeQuery();
             while (res.next()) {                 
                Asistentes obj = new Asistentes();
                obj.setId_asistente(res.getInt("id_asistente"));
                obj.setNombre_asistente(res.getString("nombre_asistente"));
                obj.setEmail(res.getString("email"));
                obj.setTelefono(res.getString("telefono"));
                listaemp.add(obj);
             }
         } catch (SQLException ex) {
            Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsultas_Asistentes.class.getName()).log(Level.SEVERE, null, ex);
                }
        }return listaemp;
    }
}
