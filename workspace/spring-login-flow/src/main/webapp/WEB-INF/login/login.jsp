<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="user" method="POST" action="${flowExecutionURL}">
		<table>
			<tr>
				<td>User Name:</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="proceed" name="_eventId_proceed" ></td>
			</tr>
		</table>
	</form:form>

</body>
</html>