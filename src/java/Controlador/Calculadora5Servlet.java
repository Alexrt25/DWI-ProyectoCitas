// Rody Fernandez
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Calculadora5Servlet", urlPatterns={"/Calculadora5Servlet"})
public class Calculadora5Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Entrada
        String miMotor = "";
        String miCarga = "";
        double potenciaNominal = 0.0;
        double longitudCadena = 0.0;
        int motor = Integer.parseInt(request.getParameter("motor"));
        int carga = Integer.parseInt(request.getParameter("carga"));
        int potenciaMotor = Integer.parseInt(request.getParameter("potenciaMotor"));
        int rpmMotor = Integer.parseInt(request.getParameter("rpmMotor"));
        int pinonMotriz = Integer.parseInt(request.getParameter("pinonMotriz"));
        //Proceso
         
        if(motor == 1) {
            if (carga == 1) {
                potenciaNominal = potenciaMotor * 1.0;
                miCarga = "carga uniforme";
            } else if (carga == 2) {
                potenciaNominal = potenciaMotor * 1.2;
                miCarga = "carga con choques moderados";
            } else if (carga == 3) {
                potenciaNominal = potenciaMotor * 1.4;
                miCarga = "carga con choques fuertes";
            }
            miMotor = "motor de combustión interna con acoplamiento hidráulico";
        } else if (motor == 2) {
            if (carga == 1) {
                potenciaNominal = potenciaMotor * 1.0;
                miCarga = "carga uniforme";
            } else if (carga == 2) {
                potenciaNominal = potenciaMotor * 1.3;
                miCarga = "carga con choques moderados";
            } else if (carga == 3) {
                potenciaNominal = potenciaMotor * 1.5;
                miCarga = "carga con choques fuertes";
            }
            miMotor = "motor eléctrico o turbina";
        } else if (motor == 3) {
            if (carga == 1) {
                potenciaNominal = potenciaMotor * 1.2;
                miCarga = "carga uniforme";
            } else if (carga == 2) {
                potenciaNominal = potenciaMotor * 1.4;
                miCarga = "carga con choques moderados";
            } else if (carga == 3) {
                potenciaNominal = potenciaMotor * 1.7;
                miCarga = "carga con choques fuertes";
            }
            miMotor = "motor de combustión interna con acoplamiento mecánico";
        }
        
        if(pinonMotriz == 17) {
            potenciaNominal = potenciaNominal * 1.13;
            miCarga = "carga uniforme";
        } else if (pinonMotriz == 19) {
            potenciaNominal = potenciaNominal * 1.0;
            miCarga = "carga con choques moderados";
        }
        
        potenciaNominal = Math.round(potenciaNominal*100.0)/100.0;
        
        
        //Salida
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head>");
        out.println("<link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"assets/css/atlantis.min.css\">");
        out.println("</head><body>");
        out.println("<div class=\"content\">");
        out.println("<div class=\"page-inner\">");
        out.println("<div class=\"page-header\">");
        out.println("<h4 class=\"page-title\">Calculadoras</h4>");
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-md-12\">");
        out.println("<div class=\"card\">");
        out.println("<div class=\"row-md-12 m-5\">");
        out.println("<h4 class=\"page-title text-center\">Calculadora de cadena idónea</h4>");
        out.println("<div class=\"align-items-center\">");
        out.println("<div class=\"card-title text-center\">A continuación se presentan los detalles del cálculo realizado</div>");
        out.println("</div><br><div class=\"border-top border-dark border-1\">");
        out.println("<br>DATOS INGRESADOS<br><br>");
        out.println("Motor: " + miMotor + "<br>");
        out.println("Carga: " + miCarga + "<br>");
        out.println("Potencia Motor (Eje motriz): " + potenciaMotor + " HP<br>");
        out.println("Velocidad motor (r.p.m.): " + rpmMotor  + " r.p.m. (Revoluciones por minuto)<br>");
        out.println("Piñón motriz: " + pinonMotriz + " dientes<br><br>");
        out.println("<div class=\"alert alert-primary\">");
        out.println("<strong>RESPUESTA</strong><br><br>");
        out.println("<strong>POTENCIA NOMINAL EN HP: " + potenciaNominal + " HP<br>");
        out.println("RPM DEL EJE MOTRIZ: " + rpmMotor + " r.p.m.<br><br></strong<");
        out.println("Por favor, tome nota de los valores que se muestran en la respuesta y haga clic en el siguiente botón:<br><br>");
        out.println("<div class=\"text-center\"><a class=\"text-center\" href=\"https://drive.google.com/file/d/1o0O3axOMp7celupOVQN4tJRTwpJBL0dY/preview\" target=\"_blank\">");
        out.println("<button class=\"btn btn-info\">Ver gráfica de selección</button></a></div></div>");
        out.println("Si necesita mayor información contáctenos:<br><br>");
        out.println("<a href=\"https://api.whatsapp.com/send?phone=51960635895&text=Quiero%20consultar%20por%20la%20cadena%20idonea%20para%20mi%20sistema%20de%20potencia\" target=\"_blank\">");
        out.println("<button class=\"btn btn-success\">Contáctenos por WhatsApp</button></a>");
        out.println("</div></div></div></div></div></div></div></div></div></body></html>");;
    }
}
