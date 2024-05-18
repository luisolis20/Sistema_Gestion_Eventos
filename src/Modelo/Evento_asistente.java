/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * 
 */
public class Evento_asistente {
     //Declaracion de Variables o Atributos para la Clase Evento_asistente (estos datos deben coincidir con las columnas de la tabla)
    int id_evento;
    int id_asistente;

    //Encapsular los atributos y generar sus metodos get (obtener datos) y set (setear datos)
    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getId_asistente() {
        return id_asistente;
    }

    public void setId_asistente(int id_asistente) {
        this.id_asistente = id_asistente;
    }
    
    
}
