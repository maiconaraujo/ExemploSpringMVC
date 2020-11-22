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
        <form action="cadastrar" method="post" enctype="multipart/form-data">
            <br> <br>
            <label>Imagem</label>
            <input type="file" name="imagem" accept="image/jpeg; image/gif; image/bmp; image/png" /> 
            
            <button type="submit">Salvar</button>
        </form>


    </body>
</html>
