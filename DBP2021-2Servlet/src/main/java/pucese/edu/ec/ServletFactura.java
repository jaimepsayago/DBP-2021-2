package pucese.edu.ec;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletfactura")
public class ServletFactura extends HttpServlet implements Servlet  {
	private static final long serialVersionUID = 1L;
       
    
    public ServletFactura() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//obtener los parametrosdel formulario factura
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String subtotal = request.getParameter("subtotal");
		String porcentajeIva = request.getParameter("porcentajeIva");
		
		//operaciones de una factura
		double dsubtotal = Double.parseDouble(subtotal);
		int porcentaje = Integer.parseInt(porcentajeIva);
		
		double montoIva = dsubtotal * porcentaje/100;
		double total = dsubtotal+montoIva;
		
		//terminamoslas operaciones de factura
		
		//como muestro la informacion creada aqui?
		//mostrar la informacion procesada en una pagina web
		StringBuilder sb = new StringBuilder();
		sb.append("<html> <head> <title>")
		.append("Resumen de la Factura")
		.append("</title></head>")
		.append("<body><h1>FACTURA</h1>")
		.append("<p>Cliente Nombre: ").append(nombre).append("</p>")
		.append("<p>Cliente Apellido: ").append(apellido).append("</p>")
		.append("<table>")
		.append("<tr><td>Subtotal:</td><td>").append(dsubtotal).append("</td></tr>")
		.append("<tr><td>Subtotal:</td><td>").append(montoIva).append("</td></tr>")
		.append("<tr><td>Subtotal:</td><td>").append(total).append("</td></tr>")
		.append("</table></body></html>");
		
		//imprimir datos con el formato
		out.print(sb.toString());
		out.flush();
		
	}

}
