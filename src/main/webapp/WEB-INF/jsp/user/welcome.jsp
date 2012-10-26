<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<h1>Welcome ${currentUser.name}</h1>
	<p><a href="logout">Logout</a></p>

</body>
</html>