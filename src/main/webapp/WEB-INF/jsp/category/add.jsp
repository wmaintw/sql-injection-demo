<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<h1>Add category</h1>
    <form:form method="POST" commandName="category">
        <form:input path="title" />
        <form:input path="description" />
        <input type="submit" />
    </form:form>
</body>
</html>