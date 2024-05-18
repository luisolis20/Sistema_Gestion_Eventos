/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 *
 */
public class Tipo_Usuario {
    //Declaracion de Variables o Atributos para la Clase Tipo_Usuario (estos datos deben coincidir con las columnas de la tabla)
    int id_tipo_usuario;
    String nombre_tipo_usuario;

    //Encapsular los atributos y generar sus metodos get (obtener datos) y set (setear datos)
    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }
    
    //Metodo para sobreescribir. Aquí obtenemos los datos que necesitamos
     @Override
    public String toString() {
        return getNombre_tipo_usuario();
    }
    
}
