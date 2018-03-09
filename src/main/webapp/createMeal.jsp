<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Meal</title>
</head>
<body>
<form method="post" action="/meal?action=create">
    <div class="row">
        <div class="row">
            <label for="description">description: </label>
            <input name="description" type="text" id="description"/>
        </div>
        <div class="row">
            <label for="calories">calories: </label>
            <input name="calories" type="number" id="calories"/>
        </div>
        <div class="row">
            <label for="date">date: </label>
            <input name="date" type="datetime-local" id="date"/>
        </div>
    </div>
    <button type="submit">Submit</button>
</form>
</body>
</html>
