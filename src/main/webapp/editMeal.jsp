<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Meal</title>
</head>
<body>
<form method="post" action="/meal?action=edit">
    <input name="id" id="id" type="hidden" value="${meal.id}">
    <div class="row">
        <div class="row">
            <label for="description">description: </label>
            <input name="description" type="text" value="${meal.description}" id="description"/>
        </div>
        <div class="row">
            <label for="calories">calories: </label>
            <input name="calories" value="${meal.calories}" type="number" id="calories"/>
        </div>
        <div class="row">
            <label for="date">date: </label>
            <input value="${meal.dateTime}"  name="date" type="datetime-local" id="date"/>
        </div>
    </div>
    <button type="submit">Submit</button>
</form>
</body>
</html>
