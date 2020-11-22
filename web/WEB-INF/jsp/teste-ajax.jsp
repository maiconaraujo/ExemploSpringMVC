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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script>

            /* $.ajax({
             type: 'get',
             dataType: 'json',
             data: $("#form2").serialize(),
             contentType: 'application/json',
             mimeType: 'application/json',     
             
             
             url:'<c:url value="/inserir" />',
             
             success: function(data, textStatus) {
             console.log(data);
             $('#msg').html(data);
             }
             });*/
            $(document).ready(function () {
                $("#preco").blur(function () {
                    $.ajax({

                        url: '<c:url value="/inserir" />',
                        data: $("#cep").val(),
                        success: function (endereco) {
                            console.log(endereco);
                            $('#rua').val(endereco.rua);
                            $('#bairro').val(endereco.bairro);
                            
                        }
                    });
                });

            });
        </script>
    </head>
    <body>
        <div id="msg"></div>
        <form action="" id="form1">
            <label>Descrição</label>
            <input type="text" name="descricao" value="" /> 

            <br> <br>
            <label>Valor:</label>
            <input type="text" name="valor" value="" id="preco"/>
 <br> <br> <br> <br>
            <label>Código</label>
            <input type="text" name="codigo" value="" id="codigo"/> 
 <br> <br>
            <label>Nome</label>
            <input type="text" name="nome" value="" id="nome"/> 
        </form>
 <br> <br>
        <button>Serialize form values</button>

        <div></div>

    </body>
</html>
