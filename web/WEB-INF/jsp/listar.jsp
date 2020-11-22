<%-- 
    Document   : listar
    Created on : 20/05/2019, 08:32:53
    Author     : sala302b
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="prodDAO" class="br.senac.es.loja.dao.ProdutoDAO" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listar!!</h1>

        <table>
            <thead>
                <th>Codigo</th>
                <th>Descrição</th>
                <th>Imagem</th>
            </thead>
            <tbody>
                <c:forEach var="p" items="${prodDAO.listar()}">
                    <tr>
                        <td>${p.getCodigo()}</td>
                        <td>${p.getDescricao()}</td>
                        <td><img src="<c:url value="/carregarImagem?codigo=${p.codigo}" />" width="200" height="200"></td>   
                    </tr>
                </c:forEach>
            </tbody>
        </table>
       
    </body>
</html>
