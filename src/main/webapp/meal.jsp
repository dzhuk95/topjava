<%--
  Created by IntelliJ IDEA.
  User: BelongToMe
  Date: 04.03.2018
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meal</title>
</head>
<body>
<a href="index.html">Home</a>
<h2>Meal</h2>
<div>
    <ul>
        <%--<jsp:useBean id="mealList" scope="request" type="java.util.List"/>--%>
        <c:forEach var="meal" items="${mealList}">
            <c:if test="${meal.exceed}">
                <li style="color: red">${meal.description} ${meal.calories} ${meal.date} </li>
            </c:if>
            <c:if test="${!meal.exceed}">
                <li>${meal.description} ${meal.calories} ${meal.date} </li>
            </c:if>
        </c:forEach>
    </ul>
</div>
</body>
</html>
