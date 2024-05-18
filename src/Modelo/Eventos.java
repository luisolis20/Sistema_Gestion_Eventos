/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;//importar librerias necesarias, esta libreria sirve para trabajar con varianle de tipo fecha
/**
 *
 * 
 */
public class Eventos {
    //Declaracion de Variables o Atributos para la Clase eventos (estos datos deben coincidir con las columnas de la tabla)
    int id_evento;
    String nombre_evento;
    Date fecha_inicio;
    Date fecha_fin;
    String lugar;
    
    //Encapsular los atributos y generar sus metodos get (obtener datos) y set (setear datos)
    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    //Metodo para sobreescribir. Aquí obtenemos los datos que necesitamos
    @Override
    public String toString() {
        return "Evento "+getNombre_evento()+" Lugar: "+getLugar();
    }
}
