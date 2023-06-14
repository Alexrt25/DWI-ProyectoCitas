package Controlador;

import Modelo.Asesor;
import Modelo.AsesorDAO;
import Modelo.Cita;
import Modelo.CitaDAO;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Usuario;
import Modelo.UsuarioCliente;
import Modelo.UsuarioDAO;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rody Fernandez
 */
public class ControladorValidar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UsuarioDAO udao = new UsuarioDAO();
    Usuario us = new Usuario();
    ClienteDAO clidao = new ClienteDAO();
    Cliente cli = new Cliente();
    AsesorDAO asedao = new AsesorDAO();
    Asesor ase = new Asesor();
    CitaDAO cidao = new CitaDAO();
    Cita ci = new Cita();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        String mensaje, error;
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Registrar")) {
            String name = request.getParameter("name");
            String dni = request.getParameter("dni");
            String email = request.getParameter("email");
            String clave = request.getParameter("clave");
            String clave2 = request.getParameter("clave2");
            String telef = request.getParameter("telef");
            String raso = request.getParameter("raso");
            String ruc = request.getParameter("ruc");

            us = udao.validarCorreo(email);
            if (us.getCorreo() != null) {
                error = "¡El correo ya existe!";
                //request.setAttribute("usuario", us);
                request.setAttribute("error", error);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                //request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } else {
                if (Integer.parseInt(clave) == Integer.parseInt(clave2)) {
                    Usuario usu = new Usuario(0, name, email, clave, 1, 3);
                    Integer idUsuario = udao.agregar(usu);
                    if (idUsuario > 0) {
                        cli = new Cliente(0, dni, telef, raso, ruc, idUsuario);
                        Integer IdCliente = clidao.agregar(cli);
                        if (IdCliente > 0) {
                            mensaje = "¡Usuario registrado satisfactoriamente!";
                            //request.setAttribute("usuario", us);
                            request.setAttribute("mensaje", mensaje);
                        } else {
                            error = "¡Ocurrio un error al registrar!";
                            //request.setAttribute("usuario", us);
                            request.setAttribute("error", error);
                        }
                    } else {
                        error = "¡Ocurrio un error al registrar!";
                        //request.setAttribute("usuario", us);
                        request.setAttribute("error", error);
                    }
                    request.getRequestDispatcher("registro.jsp").forward(request, response);
                } else {
                    error = "¡Las contraseñas no coincidieron!";
                    //request.setAttribute("usuario", us);
                    request.setAttribute("error", error);
                }
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
        } else if (accion.equalsIgnoreCase("RegistrarCliente")) {
            String name = request.getParameter("txtNombre");
            String dni = request.getParameter("txtDocumento");
            String email = request.getParameter("txtCorreo");
            String telef = request.getParameter("txtTelefono");
            String raso = request.getParameter("txtRazonSocial");
            String ruc = request.getParameter("txtRuc");
            String clave = request.getParameter("txtPaswd");
            String clave2 = request.getParameter("txtPaswd2");
            us = udao.validarCorreo(email);
            if (us.getCorreo() != null) {
                error = "¡El correo ya existe!";
                //request.setAttribute("usuario", us);
                request.setAttribute("error", error);
                //request.getRequestDispatcher("registro.jsp").forward(request, response);
            } else {
                if (Integer.parseInt(clave) == Integer.parseInt(clave2)) {
                    Usuario usu = new Usuario(0, name, email, clave, 1, 3);
                    Integer idUsuario = udao.agregar(usu);
                    if (idUsuario > 0) {
                        cli = new Cliente(0, dni, telef, raso, ruc, idUsuario);
                        Integer IdCliente = clidao.agregar(cli);
                        if (IdCliente > 0) {
                            mensaje = "¡Usuario registrado satisfactoriamente!";
                            //request.setAttribute("usuario", us);
                            request.setAttribute("mensaje", mensaje);

                        } else {
                            error = "¡Ocurrio un error al registrar!";
                            //request.setAttribute("usuario", us);
                            request.setAttribute("error", error);
                        }
                    } else {
                        error = "¡Ocurrio un error al registrar!";
                        //request.setAttribute("usuario", us);
                        request.setAttribute("error", error);
                    }
                } else {
                    error = "¡Las contraseñas no coincidieron!";
                    //request.setAttribute("usuario", us);
                    request.setAttribute("error", error);
                }
            }
            request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

        } else if (accion.equalsIgnoreCase("RegistrarAsesor")) {
            String name = request.getParameter("txtNombre");
            String dni = request.getParameter("txtDocumento");
            String email = request.getParameter("txtCorreo");
            String telef = request.getParameter("txtTelefono");

            us = udao.validarCorreo(email);
            if (us.getCorreo() != null) {
               error = "¡El correo ya existe!";
                        //request.setAttribute("usuario", us);
                        request.setAttribute("error", error);
                //request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } else {

                Usuario usu = new Usuario(0, name, email, dni, 1, 2);
                Integer idUsuario = udao.agregar(usu);
                if (idUsuario > 0) {
                    ase = new Asesor(0, dni, telef, idUsuario);
                    Integer IdAsesor = asedao.agregar(ase);
                    if (IdAsesor > 0) {
                        mensaje = "¡Asesor registrado satisfactoriamente!";
                        //request.setAttribute("usuario", us);
                        request.setAttribute("mensaje", mensaje);
                    } else {
                        error = "¡Ocurrio un error al registrar!";
                        //request.setAttribute("usuario", us);
                        request.setAttribute("error", error);
                    }

                } else {
                    error = "¡Ocurrio un error al registrar!";
                    //request.setAttribute("usuario", us);
                    request.setAttribute("error", error);
                }
                //request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                //request.getRequestDispatcher("Clientes.jsp").forward(request, response);
            }
            request.getRequestDispatcher("Controlador?menu=Asesores&accion=Listar").forward(request, response);

        } else if (accion.equalsIgnoreCase("EditarCliente")) {
            request.setAttribute("idCliente", request.getParameter("idCliente"));
            request.setAttribute("nomCliente", request.getParameter("nomCliente"));
            request.setAttribute("docuCliente", request.getParameter("docuCliente"));
            request.setAttribute("correoCliente", request.getParameter("correoCliente"));
            request.setAttribute("rsCliente", request.getParameter("rsCliente"));
            request.setAttribute("rucCliente", request.getParameter("rucCliente"));
            request.setAttribute("tlfCliente", request.getParameter("tlfCliente"));

            request.getRequestDispatcher("Controlador?menu=Clientes&accion=Editar").forward(request, response);
        } else if (accion.equalsIgnoreCase("ActualizarCliente")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String name = request.getParameter("txtNombre");
            // String dni=request.getParameter("txtDocumento");
            String email = request.getParameter("txtCorreo");
            String telef = request.getParameter("txtTelefono");
            String raso = request.getParameter("txtRazonSocial");
            String ruc = request.getParameter("txtRuc");

            cli = new Cliente(id, "", telef, raso, ruc, 0);
            boolean resul = clidao.editar(cli);
            us = udao.validarCorreo(email);

            if (resul) {
                boolean resulUs = udao.editarNombre(name, us.getIdUsuario());
                if (resulUs) {
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                }

            }
            //    mensaje = "¡Cliente actualizado satisfactoriamente!";
            //request.setAttribute("usuario", us);
            //     request.setAttribute("mensaje", mensaje);
            // }else
            // {
            //    error = "¡Ocurrio un error al actualizar!";
            //request.setAttribute("usuario", us);
            //    request.setAttribute("error", error); 
            // }

        } else if (accion.equalsIgnoreCase("EliminarCliente")) {
            //request.setAttribute("idCliente", request.getParameter("idCliente"));

            int id = Integer.parseInt(request.getParameter("idCliente"));

            boolean resul = clidao.eliminar(id);

            if (resul) {
                request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
            }
            //     mensaje = "¡Cliente deshabilitado satisfactoriamente!";
            //request.setAttribute("usuario", us);
            //     request.setAttribute("mensaje", mensaje);
            // }else
            // {
            //    error = "¡Ocurrio un error al deshabilitar!";
            //request.setAttribute("usuario", us);
            //    request.setAttribute("error", error); 
            // }

        } else if (accion.equalsIgnoreCase("EliminarAsesor")) {
            //request.setAttribute("idCliente", request.getParameter("idCliente"));

            int id = Integer.parseInt(request.getParameter("idAsesor"));

            boolean resul = asedao.eliminar(id);

            if (resul) {
                request.getRequestDispatcher("Controlador?menu=Asesores&accion=Listar").forward(request, response);
            }
            //  mensaje = "¡Asesor deshabilitado satisfactoriamente!";
            //request.setAttribute("usuario", us);
            //   request.setAttribute("mensaje", mensaje);
            // }else
            // {
            //   error = "¡Ocurrio un error al deshabilitar!";
            //request.setAttribute("usuario", us);
            //   request.setAttribute("error", error); 
            // }

        } else if (accion.equalsIgnoreCase("ActualizarAsesor")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String name = request.getParameter("txtNombre");
            // String dni=request.getParameter("txtDocumento");
            String email = request.getParameter("txtCorreo");
            String telef = request.getParameter("txtTelefono");
            // String raso=request.getParameter("txtRazonSocial");
            // String ruc=request.getParameter("txtRuc");

            ase = new Asesor(id, "", telef, 0);
            boolean resul = asedao.editar(ase);
            us = udao.validarCorreo(email);

            if (resul) {
                boolean resulUs = udao.editarNombre(name, us.getIdUsuario());
                if (resulUs) {
                    request.getRequestDispatcher("Controlador?menu=Asesores&accion=Listar").forward(request, response);
                }
            }
            //    mensaje = "¡Asesor actualizado satisfactoriamente!";
            //request.setAttribute("usuario", us);
            //     request.setAttribute("mensaje", mensaje);
            // }else
            // {
            //   error = "¡Ocurrio un error al actualizar!";
            //request.setAttribute("usuario", us);
            //   request.setAttribute("error", error); 
            // }

        } else if (accion.equalsIgnoreCase("EditarAsesor")) {
            request.setAttribute("idAsesor", request.getParameter("idAsesor"));
            request.setAttribute("nomAsesor", request.getParameter("nomAsesor"));
            request.setAttribute("docuAsesor", request.getParameter("docuAsesor"));
            request.setAttribute("correoAsesor", request.getParameter("correoAsesor"));
            request.setAttribute("tlfAsesor", request.getParameter("tlfAsesor"));

            request.getRequestDispatcher("Controlador?menu=Asesores&accion=Editar").forward(request, response);

        } else if (accion.equalsIgnoreCase("RegistrarCita")) { //Cita
            String inicio = request.getParameter("txtInicio");
            String motivo = request.getParameter("cbomotivo");
            String asesor = request.getParameter("cboAsesor");
            String horario = request.getParameter("cborHorario");
            int idUsuario = Integer.parseInt(request.getParameter("idCliente"));

            //UsuarioCliente cli = new UsuarioCliente();
            UsuarioDAO clidao = new UsuarioDAO();
            int idRealCliente = clidao.buscarCliente(idUsuario);

            if (inicio != null) {
                ci = new Cita(idRealCliente, Integer.parseInt(asesor), inicio, " ", 1, Integer.parseInt(motivo), Integer.parseInt(horario));
                Integer idCita = cidao.addCita(ci);

                if (idCita > 0) {
                    mensaje = "¡Cita registrada satisfactoriamente!";
                    //request.setAttribute("usuario", us);
                    request.setAttribute("mensaje", mensaje);
                } else {
                    error = "¡Ocurrio un error al registrar!";
                    //request.setAttribute("usuario", us);
                    request.setAttribute("error", error);
                }
            } else {
                error = "¡Ocurrio un error al registrar!";
                //request.setAttribute("usuario", us);
                request.setAttribute("error", error);
            }

            //request.getRequestDispatcher("Clientes.jsp").forward(request, response);
            request.getRequestDispatcher("Controlador?menu=CitasCliente&accion=Listar&idCliente=" + Integer.toString(idUsuario)).forward(request, response);
            //request.getRequestDispatcher("Clientes.jsp").forward(request, response);

        } else if (accion.equalsIgnoreCase("EditarCitas")) {
            request.setAttribute("idAsesor", request.getParameter("idAsesor"));
            request.setAttribute("nomAsesor", request.getParameter("nomAsesor"));
            request.setAttribute("nomEstado", request.getParameter("nomEstado"));
            request.setAttribute("enlaceMeet", request.getParameter("enlaceMeet"));

            request.getRequestDispatcher("Controlador?menu=Citas&accion=Editar").forward(request, response);

        } else if (accion.equalsIgnoreCase("EditarCitasAsesor")) {
            request.setAttribute("idAsesor", request.getParameter("idAsesor"));
            request.setAttribute("nomAsesor", request.getParameter("nomAsesor"));
            request.setAttribute("nomEstado", request.getParameter("nomEstado"));
            request.setAttribute("enlaceMeet", request.getParameter("enlaceMeet"));

            request.getRequestDispatcher("Controlador?menu=CitasAsesor&accion=Editar").forward(request, response);

        } else if (accion.equalsIgnoreCase("ActualizarCitas")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            int estado = Integer.parseInt(request.getParameter("cboNuevoEstado"));
            // String dni=request.getParameter("txtDocumento");
            int asesor = Integer.parseInt(request.getParameter("cboNuevoAsesor"));
            String enlaceMeet = request.getParameter("txtEnlaceMeet");
            if (enlaceMeet == null) {
                enlaceMeet = "";
            }
            // String raso=request.getParameter("txtRazonSocial");
            // String ruc=request.getParameter("txtRuc");

            ci = new Cita(id, asesor, enlaceMeet, estado);
            boolean resul = cidao.editar(ci);

            if (resul) {
                request.getRequestDispatcher("Controlador?menu=Citas&accion=Listar").forward(request, response);
            }
        } else if (accion.equalsIgnoreCase("ActualizarCitasAsesor")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            int estado = Integer.parseInt(request.getParameter("cboNuevoEstado"));
            // String dni=request.getParameter("txtDocumento");
            int asesor = Integer.parseInt(request.getParameter("cboNuevoAsesor"));
            String enlaceMeet = request.getParameter("txtEnlaceMeet");
            if (enlaceMeet == null) {
                enlaceMeet = "";
            }
            // String raso=request.getParameter("txtRazonSocial");
            // String ruc=request.getParameter("txtRuc");

            ci = new Cita(id, asesor, enlaceMeet, estado);
            boolean resul = cidao.editarPorAsesor(ci);

            if (resul) {
                request.getRequestDispatcher("Controlador?menu=CitasAsesor&accion=Listar&idAsesor=" + Integer.toString(asesor)).forward(request, response);
            }
        } else if (accion.equalsIgnoreCase("CerrarCitas")) {
            request.getRequestDispatcher("Controlador?menu=Citas&accion=Listar").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
        String error;
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            String correo = request.getParameter("txtcorreo");
            String contrasenia = request.getParameter("txtcontrasenia");
            us = udao.validar(correo, contrasenia);
            if (us.getCorreo() != null) {
                request.setAttribute("usuario", us);
                HttpSession session1 = request.getSession(); // creo la variable Sesion
                session1.setAttribute("IdPerfil", us.getIdPerfil()); // guardo el IdPerfil
                session1.setAttribute("NombreUsuario", us.getNombre()); // guardo el NombreUsuario
                session1.setAttribute("NombrePerfil", us.getNombrePerfil()); // guardo el NombrePerfil
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } else {
                error = "¡Correo y/ clave incorrecto!";
                request.setAttribute("error", error);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
