/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteServicio;

import Dao.MedicoDAO;
import Modelo.Horario;
import Modelo.Medico;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Grupo 5
 */
@WebService(serviceName = "ServicioMedico")
public class ServicioMedico {

    MedicoDAO medDAO =new MedicoDAO();
    
   @WebMethod(operationName = "listarMedico")
    public List<Medico> listarMedico(){
        List<Medico> med = medDAO.listar();
        return med;
    }
    
     @WebMethod(operationName = "agregarMedico")
    public int agregar(Medico medico) {
        int med = medDAO.agregar(medico);
        return med;
    }
    
     @WebMethod(operationName = "editarMedico")
    public boolean editar(Medico medico) {
        boolean med = medDAO.editar(medico);
        return med;
    }
}
