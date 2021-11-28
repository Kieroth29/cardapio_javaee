<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Cardápio</title>
	<style><%@include file="/WEB-INF/css/form.css"%></style>
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
		<c:if test="${prato != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${prato == null}">
            <form action="insert" method="post">
        </c:if>
        <table>
			<h4>
				<c:if test="${prato != null}">
					<span style="margin-left: 80px;">Editar prato</span>
				</c:if>
				<c:if test="${prato == null}">
					<span style="margin-left: 80px;">Cadastrar novo prato</span>
				</c:if>
			</h4>
			<c:if test="${prato != null}">
				<input type="hidden" name="id" value="<c:out value='${prato.id}' />" />
			</c:if>
            <tr>
                <th>Nome: </th>
                <td>
                    <input type="text" placeholder="Nome" name="nome" size="45" max="50" value="<c:out value='${prato.nome}' />"/>
                </td>
            </tr>
            <tr>
                <th>Ingredientes: </th>
                <td>
                    <input type="text" placeholder="Ingredientes" name="ingredientes" size="45" max="200" value="<c:out value='${prato.ingredientes}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Preço: </th>
                <td>
					<span style="margin-left: 65px;">R$ </span>
					<input type="number" placeholder="Preço" name="preco" size="5" step=".02f" min="0" value="<c:out value='${prato.preco}'/>"/>
                </td>
            </tr>
            <tr>
				<td></td>
                <td align="center">
                    <input class="btn btn-pequeno" type="submit" value="Salvar" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>