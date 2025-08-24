/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.logica;

import jakarta.persistence.Entity;
/*import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;*/
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author emili
 */

@Entity
public class Rol implements Serializable {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombreRol;
    private String descripcion;
    // mapear con la clase usuario de la lista de usuarios de abajo la mapeo referencio a unRol
    @OneToMany (mappedBy = "unRol")
    private List<Usuario> listaUsuarios;
    
    public Rol() {
    }

    public Rol(int id, String nombreRol, String descripcion, List<Usuario> listaUsuarios) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.listaUsuarios = listaUsuarios;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
