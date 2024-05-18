/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * 
 */
public class Asistentes {
    //Declaracion de Variables o Atributos para la Clase Asistentes (estos datos deben coincidir con las columnas de la tabla)
    int id_asistente;
    String nombre_asistente;
    String email;
    String telefono;
    
    //Encapsular los atributos y generar sus metodos get (obtener datos) y set (setear datos)
    public int getId_asistente() {
        return id_asistente;
    }

    public void setId_asistente(int id_asistente) {
        this.id_asistente = id_asistente;
    }

    public String getNombre_asistente() {
        return nombre_asistente;
    }

    public void setNombre_asistente(String nombre_asistente) {
        this.nombre_asistente = nombre_asistente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Metodo para sobreescribir. Aquí obtenemos los datos que necesitamos
    @Override
    public String toString() {
        return "Asistente "+getNombre_asistente()+" Correo: "+getEmail();
    }
}
