/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;
import java.sql.Time;
/**
 *
 * 
 */
public class Actividades {
    //Declaracion de Variables o Atributos para la Clase Actividades (estos datos deben coincidir con las columnas de la tabla)
    int id_actividad;
    int id_evento;
    String nombre_actividad;
    Date fecha;
    Time hora;

    //Encapsular los atributos y generar sus metodos get (obtener datos) y set (setear datos)
    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    //Metodo para sobreescribir. Aquí obtenemos los datos que necesitamos
    @Override
    public String toString() {
        return "Actividad: "+getNombre_actividad();
    }
}
