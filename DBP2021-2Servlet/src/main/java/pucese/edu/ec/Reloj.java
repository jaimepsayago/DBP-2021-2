package pucese.edu.ec;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reloj")
public class Reloj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Reloj() {
        super();
        
    }

    //ruta en la web
    //http://localhost:8080/DBP2021-2Servlet/reloj?formato=12
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Calendar calendar = GregorianCalendar.getInstance(); //un ojbeto de tipo calendario y obteniendo la fecha actual
		//obtener parametro desde la pagina web
		String formato = request.getParameter("formato"); //obtener los parametros desde la url o vista/pagina web
		String hora; //formato
		
		if ("12".equals(formato)) {
				hora = String.format(" %s: %s: %s: %s",
				calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE),
				calendar.get(Calendar.SECOND),
				calendar.get(Calendar.AM_PM) == 0 ? "am" : "pm");
		}else {
			hora = String.format(" %s: %s: %s:",
					calendar.get(Calendar.HOUR_OF_DAY),
					calendar.get(Calendar.MINUTE),
					calendar.get(Calendar.SECOND));
		}

		//imprimri los datos con formato
		out.print(hora);
		out.flush(); //obliga al servidor a mostrar la informacion

		
	}

	

}
