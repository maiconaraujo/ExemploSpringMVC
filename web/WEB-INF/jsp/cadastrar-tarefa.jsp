<%-- 
    Document   : form
    Created on : 13/06/2019, 06:29:55
    Author     : MAICON
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <div id="msg"></div>
        <form action="cadastrar" method="post">
            <label for="txtdescricao">descricao</label><br>
            <input type="text" name="descricao" id="txtNome" required><br><br>

            <label for="txtfinalizado">finalizado</label><br>
            <input type="text" name="finalizado" value="true"><br><br>
            
            <button type="submit">Salvar</button>
        </form>


    </body>
</html>
