//Test
package Controlador;

import Modelo.Usuario;
import Dao.UsuarioDAO;
import Modelo.Cita;
import Dao.CitaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Grupo 5
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Usuario us = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    Cita ci = new Cita();
    CitaDAO cidao = new CitaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Citas")) {
            switch (accion) {
                case "Listar":
                    List lista = cidao.listar();
                    request.setAttribute("citas", lista);
                    List listaA = udao.listarAsesor();
                    request.setAttribute("asesor", listaA);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    List listaAsesor = udao.listarAsesor();
                    request.setAttribute("asesor", listaAsesor);
                    request.getRequestDispatcher("CitasEditar.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Citas.jsp").forward(request, response);
        }

        if (menu.equals("CitasAsesor")) {
            switch (accion) {
                case "Listar"://Debería ir el id del asesor para listar solo sus citas OTRO METODO Select po Id Asesor
                    int asesor = Integer.parseInt(request.getParameter("idAsesor"));
                    List lista = cidao.listarParaAsesor(asesor);
                    request.setAttribute("citas", lista);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    List listaAsesor = udao.listarAsesor();
                    request.setAttribute("asesor", listaAsesor);
                    request.getRequestDispatcher("CitasEditarAsesor.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("CitasAsesor.jsp").forward(request, response);
        }

        if (menu.equals("CitasCliente")) {
            switch (accion) {
                case "Listar"://Debería ir el id del asesor para listar solo sus citas OTRO METODO Select po Id Asesor
                    int cliente = Integer.parseInt(request.getParameter("idCliente"));
                    List lista = cidao.listarParaClientes(cliente);
                    request.setAttribute("citas", lista);
                    List listaA = udao.listarAsesor();
                    request.setAttribute("asesor", listaA);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    List listaAsesor = udao.listarAsesor();
                    request.setAttribute("asesor", listaAsesor);
                    request.getRequestDispatcher("CitasEditarCliente.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("CitasCliente.jsp").forward(request, response);
        }

        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    List lista = udao.listar();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    request.getRequestDispatcher("ClientesEditar.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }
        }

        if (menu.equals("ClientesVistaAsesor")) {
            switch (accion) {
                case "Listar":
                    List lista = udao.listar();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("ClientesVistaAsesor.jsp").forward(request, response);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }
        }

        if (menu.equals("Asesores")) {
            switch (accion) {
                case "Listar":
                    List lista = udao.listarAsesor();
                    request.setAttribute("asesor", lista);
                    request.getRequestDispatcher("Asesores.jsp").forward(request, response);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    request.getRequestDispatcher("AsesoresEditar.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
