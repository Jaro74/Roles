/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.persistencia;

import com.mycompany.login.logica.Rol;
import com.mycompany.login.logica.Usuario;
import com.mycompany.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author emili
 */
public class ControladoraPersistencia {
    
    //crear instancias para tener accesos a los CRUD
    UsuarioJpaController usuJpa = new UsuarioJpaController ();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
        //return usuJpa.findUsuarioEntities();
        //SELECT * FROM usuarios
        List <Usuario> listaUsuario = usuJpa.findUsuarioEntities();
        return listaUsuario;
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
        
    }

    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
        
    }

    public void borrarUsuario(int id_usuario) {
        try {
            usuJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
       
    }

    public Usuario traerUsuario(int id_usuario) {
        return usuJpa.findUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
    
    
}
