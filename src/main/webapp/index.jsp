<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="save" method="post">
Username : <input type="text" name="name"/><br>
Age : <input type="text" name="age"/><br>
<input type="submit" name="value"/>   
</form>

<form action="get" method="post">
Enter input : <input type="text" name="id"/><br>
<input type="submit" name="value"/>   
</form>
</body>
</html>