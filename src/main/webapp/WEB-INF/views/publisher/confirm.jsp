<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 06.07.2021
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Czy na pewno chcesz usunąc wydawcę o id ${id} wraz z jego książkami?
<br><br>
<a href="/publisher/all">Nie</a> <a href="/form/publisher/delete/${id}">Tak</a>
</body>
</html>
