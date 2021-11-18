<%@page import="java.util.ArrayList"%>
<%@page import="puce.web.edu.Contactos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!

ArrayList<Contactos> contactos;

%>

<body>

<%
//aqui en el scriplet puedo programar en java como consola
//objeto contactos que lo declaramos en la linea 13 y obtener los parametros de la sessiones contactos

contactos = (ArrayList<Contactos>)session.getAttribute("contactos");

//si esta vacio creamos un nuevo objeto o sino agregamos los datos
	if(contactos == null){
		contactos = new ArrayList<Contactos>(); //estamos un ojbeto llamado contactos de tipos Contactos
		session.setAttribute("contactos", contactos); // la session creada con el nuevo obj se llamara contactos
	}
//luego vamos a obtener los atributos de la pagina web
String metodo = request.getMethod();

//se obtienen los atributos de la pagina web
if ("POST".equals(metodo)){
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String telefono = request.getParameter("telefono");
	
	//agregar estos datos obtenidos a mi clase contactos para que se guarden
	Contactos c = new Contactos();
	c.setNombre(nombre);
	c.setApellido(apellido);
	c.setTelefono(telefono);
	
	//agrego los objetos de tipo Contacto a mi lista
	contactos.add(c);
}



%>

<h1>LIBRETA DE DIRECCIONES</h1>
<form method="post">
<label>Nombre</label>
<input type="text" name="nombre"/> 
<label>Apellido</label>
<input type="text" name="apellido"/> 
<label>Telefono</label>
<input type="text" name="telefono"/> 

<button type="submit">Guardar</button>


</form>


<!-- generando la salida del arraylist Contactos -->
<h1>Contactos Registrados</h1>
<table>
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Telefono</th>
		</tr>
	</thead>
	<tbody>
	<% for (Contactos c:contactos){ %>
	
		<tr>
			<th><%=c.getNombre() %></th>
			<th><%=c.getApellido() %></th>
			<th><%=c.getTelefono()%></th>
		</tr>
	<%
	}
	%>
	</tbody>
</table>


</body>
</html>