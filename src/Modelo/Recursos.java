/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * 
 */
public class Recursos {
    //Declaracion de Variables o Atributos para la Clase Recursos (estos datos deben coincidir con las columnas de la tabla)
    int id_recurso;
    int id_evento;
    String nombre_recurso;
    int cantidad;

    //Encapsular los atributos y generar sus metodos get (obtener datos) y set (setear datos)
    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre_recurso() {
        return nombre_recurso;
    }

    public void setNombre_recurso(String nombre_recurso) {
        this.nombre_recurso = nombre_recurso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    //Metodo para sobreescribir. Aquí obtenemos los datos que necesitamos
    @Override
    public String toString() {
        return "Recurso: "+getNombre_recurso()+" Cantidad: "+getCantidad();
    }
    
}
