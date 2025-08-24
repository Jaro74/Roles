/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.logica;

import jakarta.persistence.Entity;
/*import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;*/
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author emili
 */

@Entity
public class Usuario implements Serializable {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id; 
    private String nombreUsuario;
    private String contrasenia;
    //mapear la realación bidireccional
    @ManyToOne
    @JoinColumn(name = "fk_rol")  //tener cuidado ya que si pongo id no puede generar una nueva columna con el mismo nombre
    private Rol unRol;

    public Usuario() {
    }

    public Usuario(int id, String nombreUsuario, String contrasenia, Rol unRol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.unRol = unRol;
    }

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
}
