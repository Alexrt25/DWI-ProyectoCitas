/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteServicio;

import Dao.HorarioDAO;
import Modelo.Citas;
import Modelo.Horario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Grupo 5
 */
@WebService(serviceName = "ServicioHorario")
public class ServicioHorario {

    HorarioDAO horDAO = new HorarioDAO();
    
    @WebMethod(operationName = "listarHorario")
    public List<Horario> listarHorario(){
        List<Horario> hor = horDAO.listar();
        return hor;
    }
    
     @WebMethod(operationName = "agregarHorario")
    public int agregarHorario(Horario hor){
        int ho = horDAO.agregar(hor);
        return ho;
    }
     @WebMethod(operationName = "editarHorario")
    public boolean editarHorario(Horario hor){
        boolean ho = horDAO.editar(hor);
        return ho;
    }
}
