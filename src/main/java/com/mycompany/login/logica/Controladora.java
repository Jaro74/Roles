/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author emili
 */
public class Controladora {
    
    //da error ya que no está encontrando la instancia por eso pone en el error no encuentra el símbolo
    
    ControladoraPersistencia controlPersis; // = new ControladoraPersistencia();

    public Controladora() {
        
        controlPersis = new ControladoraPersistencia();
    }
    
    

    public Usuario validarUsuario(String usuario, String contrasenia) {
        
        //String mensaje = "";
        Usuario usr = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        for(Usuario uso: listaUsuarios){
            if(uso.getNombreUsuario().equals(usuario))
                if (uso.getContrasenia().equals(contrasenia)){
                    //mensaje = "Usuario y contraseña correctos. Bienvenido/a";
                    usr = uso;
                    return usr;
                }
                else{
                    //mensaje = "La contraseña no es correcta";
                    usr = null;
                    return usr;
                }
            else{
                //mensaje = "Usuario no encontrado";
                usr = null;
                //return usr; lo quito para que no siga el bucle
            }
        }
        return usr;
    }

    public List<Usuario> traerUsuario() {
        return controlPersis.traerUsuarios();
        
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);
        //tenemos un string tenemos que traer un objeto
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null){
            usu.setUnRol(rolEncontrado);
        }
        
        // como tenemos datos en la base de datos tenemos que crear un método para buscar el id anterior
        int id = this.buscarUltimaIdUsuarios();
        
        usu.setId(id + 1); //sumarle uno para que no haya duplicado porque me gehera con el anterior 
        // poner en la base de datos primero a la persistencia 
        controlPersis.crearUsuario(usu);
    }
    // traer un metodo a parte para tener funciones mas atómicas
    private Rol traerRol(String rolRecibido) {
        List <Rol> listaRoles = controlPersis.traerRoles();
        
        for (Rol rol : listaRoles){
            if (rol.getNombreRol().equals(rolRecibido)){
                return rol;
            }
        
        }
        return null;
    }

    private int buscarUltimaIdUsuarios() {
        List <Usuario> listaUsuarios = this.traerUsuario();
        // buscamos la última posición con el size()-1
        Usuario usu = listaUsuarios.get(listaUsuarios.size()-1);
        //retornamos el id
        return usu.getId();
    }

    public void borrarUsuario(int id_usuario) {
        controlPersis.borrarUsuario(id_usuario);
    }

    public Usuario traerUsuario(int id_usuario) {
        return controlPersis.traerUsuario (id_usuario);
    }

    public void editarUsuario(Usuario usu, String usuario, String contra, String rolRecibido) {
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null){
            usu.setUnRol(rolEncontrado);   
        }
        controlPersis.editarUsuario(usu);

    
    }
}
