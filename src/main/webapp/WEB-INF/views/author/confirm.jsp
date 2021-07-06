<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 06.07.2021
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Czy na pewno chcesz usunąc autora o id ${id} wraz z jego książkami?
<br><br>
<a href="/author/all">Nie</a> <a href="/form/author/delete/${id}">Tak</a>
</body>
</html>
