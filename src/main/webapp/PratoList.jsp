<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cardápio</title>
    <style><%@include file="/WEB-INF/css/lista.css"%></style>
</head>
<body>
    <center>
        <h1>Gerenciamento do cardápio</h1>
        <h4>
            <a class="btn btn-grande" href="new">Adicionar novo prato</a>
            &nbsp;&nbsp;&nbsp;
            <a class="btn btn-grande" href="list">Lista de pratos</a>
             
        </h4>
    </center>
    <div align="center">
        <table border="1">
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
                        <a class="btn btn-pequeno" href="edit?id=<c:out value='${prato.id}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-pequeno" href="delete?id=<c:out value='${prato.id}' />">Apagar</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>