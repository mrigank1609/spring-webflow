<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Spring MVC Demo</h1>
	<h1>Login Page</h1>
	<hr>
	<form:form action="" method="post" commandName="user">
	User Name:<form:input path="userName" />
		<form:errors path="userName" cssStyle="color:red"/><br/>
	Password:<form:input path="password" />
		<form:errors path="password" cssStyle="color:red"/>
		<br />
		<input type="submit" value="Login">

	</form:form>
</body>
</html>