<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 06.07.2021
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Lista autorów
<br><br>
<a href="/form/author/add">Dodaj autora</a>
<br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td></td>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="/form/author/edit/${author.id}">Edytuj</a> <a href="/form/author/confirm/${author.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
