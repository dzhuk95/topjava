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
<div class="row">
    <a href="meal?action=create">Create Entity</a>
</div>
<div>
    <table>
        <thead>
        <tr>
            <td>Description</td>
            <td>Calories</td>
            <td>Date</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="meal" items="${mealList}">
            <c:if test="${meal.exceed}">
                <%--<c:out value="${meal.exceed ?  somevariable: 'empty'}" />--%>
                <tr style="color: red">
                    <td>${meal.description}</td>
                    <td>${meal.calories}</td>
                    <td>${meal.date}</td>
                    <td><a href="meal?action=delete&id=${meal.id}">Delete</a>
                        <a href="meal?action=edit&id=${meal.id}">Edit</a>
                    </td>
                </tr>
            </c:if>
            <c:if test="${!meal.exceed}">
                <tr>
                    <td>${meal.description}</td>
                    <td>${meal.calories}</td>
                    <td>${meal.date}</td>
                    <td><a href="meal?action=delete&id=${meal.id}">Delete</a>
                        <a href="meal?action=edit&id=${meal.id}">Edit</a>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
