<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 27.06.2021
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/form/book/add">Dodaj książkę</a>
<br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Tytul</td>
        <td>Rating</td>
        <td>Opis</td>
        <td>Wydawca</td>
        <td>Autorzy</td>
        <td></td>
    </tr>
<c:forEach items="${books}" var="book">
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.rating}</td>
        <td>${book.publisher}</td>
        <td>${book.authors}</td>
        <td><a href="/form/book/edit/${book.id}">Edytuj</a> <a href="/form/book/confirm/${book.id}">Usuń</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
