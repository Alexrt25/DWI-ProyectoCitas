/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteServicio;

import Dao.EspecialidadDAO;
import Modelo.Especialidad;
import Modelo.Horario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Grupo 5
 */
@WebService(serviceName = "ServicioEspecialidad")
public class ServicioEspecialidad {

    EspecialidadDAO espDAO = new EspecialidadDAO();
    
    @WebMethod(operationName = "listarEspecialidad")
    public List<Especialidad> listarEspecialidad(){
        List<Especialidad> esp = espDAO.listar();
        return esp;
    }
}
