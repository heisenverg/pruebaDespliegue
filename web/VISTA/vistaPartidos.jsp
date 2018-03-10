<%-- 
    Document   : vistaPartidos
    Created on : 15-feb-2018, 13:49:22
    Author     : antonio
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Partido"%>
<%@page import="modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <title>partidos</title>
    </head>
    <body>
        <jsp:include page="menuInicial.jsp" />
        <div id = "contenedor" class="container-fluid">
            <article>
                <h6>Ciudadano</h6>
                <div class="row justify-content-md-center">
                    <div class="col-6">
                        <table class="table table-dark">
                            <tr>
                                <td>NIF</td><td>Nombre</td><td>Apellidos</td><td>Fecha Nacimiento</td>
                            </tr>
                            <% HttpSession arraySession = request.getSession(true);
                            Votante votante = (Votante)arraySession.getAttribute("votante");
                            ArrayList<Partido> partidos = (ArrayList<Partido>)arraySession.getAttribute("partidos");%>
                            <tr>
                                <td><%= votante.getNif() %></td>
                                <td><%= votante.getNombre() %></td>
                                <td><%= votante.getApellidos() %></td>
                                <td><%= votante.getFechaNac() %></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <h5>Elija un partido</h5>
                <div class="row justify-content-md-center">
                    <div class="col-3">
                        <form method="post" action="../controlVotar">
                            <table class="table table-dark table-bordered">
                                <tr><td>Partido</td><td>Voto</td>
                                <% for(Partido valor: partidos){%>
                                <tr><td><%= valor.getDenominacion()%></td>
                                    <td><input type="radio" name="partidos" value="<%= valor.getSiglas()%>" required></tr>
                            <%}; %>
                            <tr><td colspan="2"><input type="submit" class="btn" value="Votar"></td></tr>
                            </table>
                        </form>
            </article>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/aa49406086.js"></script>
    </body>
</html>
