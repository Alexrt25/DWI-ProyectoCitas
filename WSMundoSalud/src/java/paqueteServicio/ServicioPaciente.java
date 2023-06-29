/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteServicio;

import Dao.EstadoDAO;
import Dao.PacienteDAO;
import Dao.UsuarioDAO;
import Modelo.Estado;
import Modelo.Paciente;
import Modelo.Usuario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Grupo 5
 */
@WebService(serviceName = "ServicioPaciente")
public class ServicioPaciente {

    UsuarioDAO usDao = new UsuarioDAO();
    EstadoDAO estDao = new EstadoDAO();
    PacienteDAO pacDao = new PacienteDAO();
    
    
    @WebMethod(operationName = "validarUsuario")
    public Usuario validarUsuario(String correo, String contrasenia){
        Usuario us = usDao.validar(correo,contrasenia);
        return us;
    }
    
    @WebMethod(operationName = "validarCorreo")
    public Usuario validarCorreo(String correo){
        Usuario us = usDao.validarCorreo(correo);
        return us;
    }
    
    @WebMethod(operationName = "buscarIDPaciente")
    public int buscarIDPaciente(int id){
        int us = usDao.buscarCliente(id);
        return us;
    }
    
    @WebMethod(operationName = "agregarUsuarioPaciente")
    public int agregarUsuarioPaciente(Usuario usu){
        int us = usDao.agregar(usu);
        return us;
    }
    
    @WebMethod(operationName = "editarUsuarioPaciente")
    public int editarUsuarioPaciente(Usuario usu){
        int us = usDao.editar(usu);
        return us;
    }
    
    @WebMethod(operationName = "eliminarUsuarioPaciente")
    public boolean eliminarUsuarioPaciente(int usu){
         usDao.eliminar(usu);
         return true;
    }
    
    @WebMethod(operationName = "listarUsuario")
    public Usuario listarUsuario(int id){
        Usuario datos = usDao.listarId(id);
        return datos;
    }
   
     @WebMethod(operationName = "agregarPaciente")
    public int agregarPaciente(Paciente pac){
        int paci = pacDao.agregar(pac);
        return paci;
    }
    @WebMethod(operationName = "editarPaciente")
    public boolean editarPaciente(Paciente pac){
        boolean paci = pacDao.editar(pac);
        return paci;
    }
    
     @WebMethod(operationName = "eliminarPaciente")
    public boolean eliminarPaciente(int pac){
        boolean paci = pacDao.eliminar(pac);
        return paci;
    }
}
