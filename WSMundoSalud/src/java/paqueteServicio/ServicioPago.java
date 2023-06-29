/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteServicio;

import Dao.PagoDAO;
import Modelo.Citas;
import Modelo.Pago;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Grupo 5
 */
@WebService(serviceName = "ServicioPago")
public class ServicioPago {

    PagoDAO pagDao = new PagoDAO();
    
    @WebMethod(operationName = "agregarPago")
    public int agregar(Pago pag){
        int pa = pagDao.agregar(pag);
        return pa;
    }
    @WebMethod(operationName = "editarPago")
    public boolean editar(Pago pag){
        boolean pa = pagDao.editar(pag);
        return pa;
    }
    @WebMethod(operationName = "eliminarPago")
    public boolean eliminar(int pag){
        boolean pa = pagDao.eliminar(pag);
        return pa;
    }
}
