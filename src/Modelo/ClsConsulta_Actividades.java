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
public class ClsConsulta_Actividades extends ClsConexion{ //aqui se hace un extends de la clase conexion para usar el metodo de conectar
     public boolean Guardar(Actividades actividades){
          PreparedStatement ps =null;
            Connection con= (Connection)getConexion();
            String sql="INSERT INTO actividades(id_evento,nombre_actividad,fecha,hora) VALUES (?,?,?,?)";
            
        try {    
            ps=con.prepareStatement(sql);
            ps.setInt(1,actividades.getId_evento());
            ps.setString(2, actividades.getNombre_actividad());
            ps.setDate(3, new java.sql.Date(actividades.getFecha().getTime()));
            ps.setTime(4, new java.sql.Time(actividades.getHora().getTime()));
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
     //Metodo Para Editar
     public boolean Modificar(Actividades actividades){
           PreparedStatement ps =null;
           Connection con= (Connection)getConexion();
           String sql="UPDATE actividades SET id_evento=?,nombre_actividad=?,fecha=?,hora=? WHERE id_actividad=?";
            
        try {    
            ps=con.prepareStatement(sql);
            
            ps.setInt(1,actividades.getId_evento());
            ps.setString(2, actividades.getNombre_actividad());
            ps.setDate(3, new java.sql.Date(actividades.getFecha().getTime()));
            ps.setTime(4, new java.sql.Time(actividades.getHora().getTime()));
            ps.setInt(5, actividades.getId_actividad());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
     //Metodo Para Eliminar
     public boolean Eliminar(Actividades actividades){
            PreparedStatement ps =null;
            Connection con= (Connection)getConexion();
            String sql="DELETE FROM actividades WHERE id_actividad=?";
            
        try {    
            ps=con.prepareStatement(sql);
            ps.setInt(1, actividades.getId_actividad());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
     //Metodo Para Mostrar Todos Los Actividadess
    public List MostrarActividades()throws Exception{
         ResultSet res;
         List obList = new ArrayList();
         PreparedStatement ps =null;
         Connection con= (Connection)getConexion();
         String sql="SELECT a.id_actividad,a.id_evento,e.nombre_evento as evento,a.nombre_actividad,a.fecha,a.hora FROM actividades a,"
                 + " eventos e WHERE e.id_evento=a.id_evento";
         try {
             ps=con.prepareStatement(sql);
             res = ps.executeQuery();
             while (res.next()) {                 
                Actividades obj = new Actividades();
                obj.setId_actividad(res.getInt("id_actividad"));
                obj.setId_evento(res.getInt("id_evento"));
                obj.setEvento(res.getString("evento"));
                obj.setNombre_actividad(res.getString("nombre_actividad"));
                obj.setFecha(res.getDate("fecha"));
                obj.setHora(res.getTime("hora"));
                obList.add(obj);
             }
         } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
                }
        }return obList;
     }
    //Metodo par obtener el evento correcto
    public  Eventos BuscarEventos(Actividades am){
    Eventos eventos = new Eventos();
    PreparedStatement ps =null;
    Connection con= (Connection)getConexion();
    ResultSet rs=null;
    String sql="SELECT * FROM eventos WHERE id_evento=?";
            
        try {    
            ps=con.prepareStatement(sql);
            ps.setInt(1, am.getId_evento());
            rs=ps.executeQuery();
            //paso el resultado de la consulta modelo
           if(rs.next())
            {
                eventos.setId_evento(rs.getInt("id_evento"));
                eventos.setNombre_evento(rs.getString("nombre_evento"));
                eventos.setFecha_inicio(rs.getDate("fecha_inicio"));
                eventos.setFecha_fin(rs.getDate("fecha_fin"));
                eventos.setLugar(rs.getString("lugar"));
                
                return eventos;  
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
   
    }
      //Metodo Para Buscar Actividades por su descripcion
    public boolean BuscarActividades(Actividades obj){
    PreparedStatement ps =null;
    Connection con= (Connection)getConexion();
    ResultSet res=null;
   String sql="SELECT a.id_actividad,a.id_evento,e.nombre_evento as evento,a.nombre_actividad,a.fecha,a.hora FROM actividades a,"
                 + " eventos e WHERE a.nombre_actividad=? and e.id_evento=a.id_evento";
            
        try {    
            ps=con.prepareStatement(sql);
             ps.setString(1, obj.getNombre_actividad());
            res=ps.executeQuery();
            //paso el resultado de la consulta al modelo
           if(res.next())
            {
                obj.setId_actividad(res.getInt("id_actividad"));
                obj.setId_evento(res.getInt("id_evento"));
                obj.setEvento(res.getString("evento"));
                obj.setNombre_actividad(res.getString("nombre_actividad"));
                obj.setFecha(res.getDate("fecha"));
                obj.setHora(res.getTime("hora"));
                return true;  
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    //Metodo Para Listar Mi Busqueda de Eventoss Por su Nombre
    public List ListarBussqueda(String nombre)throws Exception{
         ResultSet res;
         List obList = new ArrayList();
         PreparedStatement ps =null;
         Connection con= (Connection)getConexion();
         String sql="SELECT * FROM actividades WHERE nombre_actividad=?";
         try {
             
             ps=con.prepareStatement(sql);
             ps.setString(1, nombre);
             res = ps.executeQuery();
             while (res.next()) {                 
                Actividades obj = new Actividades();
                obj.setId_actividad(res.getInt("id_actividad"));
                obj.setId_evento(res.getInt("id_evento"));
                obj.setNombre_actividad(res.getString("nombre_actividad"));
                obj.setFecha(res.getDate("fecha"));
                obj.setHora(res.getTime("hora"));
                obList.add(obj);
             }
         } catch (SQLException ex) {
            Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClsConsulta_Actividades.class.getName()).log(Level.SEVERE, null, ex);
                }
        }return obList;
    }
}
