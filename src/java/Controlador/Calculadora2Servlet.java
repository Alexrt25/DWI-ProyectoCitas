// Rody Fernandez
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Calculadora2Servlet", urlPatterns={"/Calculadora2Servlet"})
public class Calculadora2Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Entrada
        int rpmMotor = Integer.parseInt(request.getParameter("rpmMotor"));
        int rpmDeseadas = Integer.parseInt(request.getParameter("rpmDeseadas"));
        int pinonConducido = Integer.parseInt(request.getParameter("pinonConducido"));
        //Proceso
         
        int pinonMotriz = Math.round((pinonConducido * rpmDeseadas ) / rpmMotor);
        
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
        out.println("<h4 class=\"page-title text-center\">Calculadora de número de dientes del piñón motriz</h4>");
        out.println("<div class=\"align-items-center\">");
        out.println("<div class=\"card-title text-center\">A continuación se presentan los detalles del cálculo realizado</div>");
        out.println("</div><br><div class=\"border-top border-dark border-1\">");
        out.println("<br>DATOS INGRESADOS<br><br>");
        out.println("RPM (revoluciones por minuto) del motor: " + rpmMotor + " (rpm)<br>");
        out.println("RPM (revoluciones por minuto) del eje conducido: " + rpmDeseadas + " (rpm)<br>");
        out.println("Piñón conducido: " + pinonConducido + " dientes<br><br>");
        out.println("<div class=\"alert alert-primary\">");
        out.println("<strong>RESPUESTA<br><br>Usted necesita un piñón motriz de  " + pinonMotriz + " dientes, de acuerdo con los datos ingresados</strong></div>");
        out.println("Si necesita cotizar escríbanos:<br><br>");
        out.println("<a href=\"https://api.whatsapp.com/send?phone=51960635895&text=Quiero%20cotizar%20un%20pinon%20de%20" + pinonMotriz + "%20dientes%20para%20pinon%20motriz\" target=\"_blank\">");
        out.println("<button class=\"btn btn-success\">Cotice por WhatsApp</button></a>");
        out.println("</div></div></div></div></div></div></div></div></body></html>");
    }
}
