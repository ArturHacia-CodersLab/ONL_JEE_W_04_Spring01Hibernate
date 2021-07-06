<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 27.06.2021
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    Tytuł: <form:input path="title"/><br>
    Rating: <form:input path="rating" type="number"/><br>
    Opis: <form:textarea path="description"/><br>
    Wydawca: <form:select path="publisher.id">
        <form:option value="0">--- Wybierz ---</form:option>
        <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
    </form:select><br>
    Autorzy: <form:select path="authors" items="${authorList}" itemValue="id" itemLabel="fullName"/><br>
    <input type="submit">
</form:form>
</body>
</html>
