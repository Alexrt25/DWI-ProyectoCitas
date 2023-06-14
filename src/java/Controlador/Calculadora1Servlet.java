// Rody Fernandez
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Calculadora1Servlet", urlPatterns={"/Calculadora1Servlet"})
public class Calculadora1Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Entrada
        String miCadena = "";
        double longitudCadena = 0.0;
        int tipoCadena = Integer.parseInt(request.getParameter("tipoCadena"));
        int pinonMotriz = Integer.parseInt(request.getParameter("pinonMotriz"));
        int pinonConducido = Integer.parseInt(request.getParameter("pinonConducido"));
        int distanciaCentros = Integer.parseInt(request.getParameter("distanciaCentros"));
        //Proceso
         
        if(tipoCadena == 1) {
            longitudCadena = 9.525 * (pinonMotriz/2 + pinonConducido/2) + 2*distanciaCentros;
            miCadena = "ASA35/06B";
        } else if (tipoCadena == 2) {
            longitudCadena = 12.7 * (pinonMotriz/2 + pinonConducido/2) + 2*distanciaCentros;
            miCadena = "ASA40/08B";
        } else if (tipoCadena == 3) {
            longitudCadena = 15.875 * (pinonMotriz/2 + pinonConducido/2) + 2*distanciaCentros;
            miCadena = "ASA50/10B";
        } else if (tipoCadena == 4) {
            longitudCadena = 19.05 * (pinonMotriz/2 + pinonConducido/2) + 2*distanciaCentros;
            miCadena = "ASA60/12B";
        } else if (tipoCadena == 5) {
            longitudCadena = 25.4 * (pinonMotriz/2 + pinonConducido/2) + 2*distanciaCentros;
            miCadena = "ASA80/16B";
        } else if (tipoCadena == 6) {
            longitudCadena = 31.75 * (pinonMotriz/2 + pinonConducido/2) + 2*distanciaCentros;
            miCadena = "ASA100/20B";
        }
        
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
        out.println("<h4 class=\"page-title text-center\">Calculadora de longitud de cadena</h4>");
        out.println("<div class=\"align-items-center\">");
        out.println("<div class=\"card-title text-center\">A continuación se presentan los detalles del cálculo realizado</div>");
        out.println("</div><br><div class=\"border-top border-dark border-1\">");
        out.println("<br>DATOS INGRESADOS<br><br>");
        out.println("Tipo cadena: " + miCadena + "<br>");
        out.println("Piñón motriz: " + pinonMotriz + " dientes<br>");
        out.println("Piñón conducido: " + pinonConducido + " dientes<br>");
        out.println("Distancia entre centros de ejes: " + distanciaCentros + " mm<br><br>");
        out.println("<div class=\"alert alert-primary\">");
        out.println("<strong>RESPUESTA<br><br>Usted necesita un total de " + longitudCadena + " mm de la cadena " + miCadena + "</strong></div>");
        out.println("Si necesita mayor información contáctenos:<br><br>");
        out.println("<a href=\"https://api.whatsapp.com/send?phone=51960635895&text=Quiero%20cotizar%20"+ longitudCadena +"%20mm%20de%20cadena%20"+ miCadena +"\" target=\"_blank\">");
        out.println("<button class=\"btn btn-success\">Contáctenos por WhatsApp</button></a>");
        out.println("</div></div></div></div></div></div></div></div></body></html>");
    }
}
