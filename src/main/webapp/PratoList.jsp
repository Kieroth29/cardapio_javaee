<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cardápio</title>
</head>
<body>
    <center>
        <h1>Gerenciamento do cardápio</h1>
        <h2>
            <a href="new">Adicionar novo prato</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">Lista de pratos</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de pratos</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Ingredientes</th>
                <th>Preço</th>
                <th></th>
            </tr>
            <c:forEach var="prato" items="${listPrato}">
                <tr>
                    <td><c:out value="${prato.id}" /></td>
                    <td><c:out value="${prato.nome}" /></td>
                    <td><c:out value="${prato.ingredientes}" /></td>
                    <td><c:out value="${prato.preco}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${prato.id}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${prato.id}' />">Apagar</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>