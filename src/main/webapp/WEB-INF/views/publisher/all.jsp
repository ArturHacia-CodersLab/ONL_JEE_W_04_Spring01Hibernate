<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 06.07.2021
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Lista wydawców
<br><br>
<a href="/form/publisher/add">Dodaj wydawcę</a>
<br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Nazwa</td>
        <td></td>
    </tr>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.id}</td>
            <td>${publisher.name}</td>
            <td><a href="/form/publisher/edit/${publisher.id}">Edytuj</a> <a href="/form/publisher/confirm/${publisher.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
