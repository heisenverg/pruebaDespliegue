<%-- 
    Document   : vistaCenso
    Created on : 16-feb-2018, 9:48:52
    Author     : antonio
--%>


<%@page import="modelo.Votante"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <title>censo</title>
    </head>
    <body>
        <jsp:include page="menuInicial.jsp" />
        <div id = "contenedor" class="container-fluid">
            <article>
                <h1>Censo</h1>
                <div class="row justify-content-md-center">
                    <div class="col-6">
                        <table class="table table-hover table-dark">
                            <tr>
                                <td>NIF</td><td>Nombre</td><td>Apellidos</td><td>Fecha Nacimiento</td><td>Votado</td>
                            </tr>
                            <% HttpSession arraySesion = request.getSession(true);
                            ArrayList<Votante> votantes = (ArrayList<Votante>)arraySesion.getAttribute("listadoVotantes");
                            for(Votante key: votantes){%>
                            <tr>
                                <td><%= key.getNif() %></td>
                                <td><%= key.getNombre() %></td>
                                <td><%= key.getApellidos() %></td>
                                <td><%= key.getFechaNac() %></td>
                                <td><%= key.getVotado() %></td>
                            </tr>
                            <%}%>
                        </table>
                    </div>
                </div>       
            </article>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/aa49406086.js"></script>
    </body>
</html>
