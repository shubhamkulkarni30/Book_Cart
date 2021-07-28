<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2 style='float:right;'>Welcome ${sessionScope.user} </h2>
<br><br>
<h3>Select Book Category</h3>
<form action="BookServ">
<table border="3">
<c:forEach var="bc" items="${requestScope.bcat}">
<tr>
<td><input type="checkbox" name="bcat" value="${bc}"></td>
<td> ${bc} </td>
</tr>

</c:forEach>

</table>
<br>
<input type="submit" value="Get Books">

</form>
<br><br>
<a href="GetServ">Home</a>
<a style='float:right;' href="LogoutServ">Logout</a>

</body>
</html>