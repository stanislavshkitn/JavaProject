<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: stanislav
  Date: 19.02.18
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    Тестовый список юзеров!
    <c:forEach items="${userList}" var="user">
        <div>
            ${user.id}
            ${user.first_name}
            ${user.last_name}
            ${user.age}
            ${user.number}
            ${user.group}
        </div>
    </c:forEach>
    <br>
    <br>
    Добавить юзера:
    <form action="/test" method="post">
        <div>
            Имя:<br>
            <input type="text" name="first_name"  />
        </div>
        <div>
            Фамилия:<br>
            <input type="text" name="last_name" />
        </div>
        <div>
            Возраст:<br>
            <input type="text" name="age" />
        </div>
        <div>
            Номер телефона:<br>
            <input type="text" name="number" />
        </div>
        <div>
            Группа:<br>
            <input type="text" name="group" />
        </div>
        <div><input type="submit" name="submit" value="Добавить" /></div>
    </form>
</body>
</html>
