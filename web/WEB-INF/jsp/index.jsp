<%-- 
    Document   : index
    Created on : 06/06/2019, 02:36:25
    Author     : MAICON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! 123</h1>
       
                <form action=" <c:url value="/adicionaProduto" />" method="post">
            
            <label>Descrição</label>
            <input type="text" name="descricao" value="" /> 
            
            <br>
            <label>Valor:</label>
            <input type="text" name="valor" value="" />
            
            <label>Categoria</label>
            <input type="text" name="categoria.codigo" value="" />            
            
            <br>
            <label>Data</label>
            <input type="date" name="dataCadastro" value="" />
            <br>
            <input type="submit" value="Salvar" />
        </form>
    </body>
</html>
