<%-- 
    Document   : vistaIdentificacion
    Created on : 15-feb-2018, 1:44:18
    Author     : antonio
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <title>identificacion</title>
    </head>
    <body>
        <jsp:include page="menuInicial.jsp" />
        <div id = "contenedor" class="container-fluid">
            <article>
                <h1>Identificación</h1>
                <div class="row justify-content-md-center">
                    <div class="col-3">
                        <form method="post" action="../controlIdentificacion">
                            <table class="table table-dark">
                                <tr><td>NIF</td>
                                    <td><input class="form-control" name="nif" type="text" required></td>
                                </tr>
                                <tr><td>contraseña</td>
                                    <td><input class="form-control" name="password" type="password" required></td>
                                </tr>
                                <tr><td colspan="2"><input type="submit" class="btn" value="Comprobar"</tr>
                            </table>
                        </form>
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
