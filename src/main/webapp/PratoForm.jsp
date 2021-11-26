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
        <c:if test="${prato != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${prato == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
			<caption>
                <h2>
                    <c:if test="${prato != null}">
                        Editar prato
                    </c:if>
                    <c:if test="${prato == null}">
                        Cadastrar novo prato
                    </c:if>
                </h2>
            </caption>
				<c:if test="${prato != null}">
                    <input type="hidden" name="id" value="<c:out value='${prato.id}' />" />
                </c:if>           
            <tr>
                <th>Nome: </th>
                <td>
                    <input type="text" name="nome" size="45"
                            value="<c:out value='${prato.nome}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Ingredientes: </th>
                <td>
                    <input type="text" name="ingredientes" size="45"
                            value="<c:out value='${prato.ingredientes}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Preço: </th>
                <td>
                    <input type="text" name="preco" size="5"
                            value="<c:out value='${prato.preco}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>