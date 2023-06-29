/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteServicio;

import Dao.CitasDAO;
import Modelo.Citas;
import Modelo.Usuario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Grupo 5
 */
@WebService(serviceName = "ServicioCita")
public class ServicioCita {

    CitasDAO citDao = new CitasDAO();
    
    @WebMethod(operationName = "validarCita")
    public Citas validarCita(String pacienteID){
        Citas us = citDao.validar(pacienteID);
        return us;
    }
    @WebMethod(operationName = "listarCitas")
    public List<Citas> listarCitas(){
        List<Citas> ci = citDao.listar();
        return ci;
    }
     @WebMethod(operationName = "agregarCita")
    public int agregar(Citas cit){
        int ci = citDao.agregar(cit);
        return ci;
    }
    @WebMethod(operationName = "listarIdCita")
    public Citas listarId(int id){
        Citas ci = citDao.listarId(id);
        return ci;
    }
    @WebMethod(operationName = "editarCita")
    public boolean editar(Citas cit){
        boolean ci = citDao.editar(cit);
        return ci;
    }
    @WebMethod(operationName = "eliminarCita")
    public boolean eliminar(int cit){
        citDao.eliminar(cit);
        return true;
    }
}
