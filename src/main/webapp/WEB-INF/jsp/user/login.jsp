<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<h1>Please login</h1>
	<form:form method="POST" commandName="user">
	    <p>${message}</p>
        <p>Username: <form:input path="username" /></p>
        <p>Password: <form:password path="password" /></p>
        <p><input type="submit" /></p>
	</form:form>
</body>
</html>