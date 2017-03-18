<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Your screen has been taken at
	<c:out value="${timeStampScreen}" />
	and is ready to view.
	

	
	<form action="${pageContext.request.contextPath}/getscreen"
		method="get" id="form_get_screenshot">
		<c:set var="last" scope="session" value="${timeStampScreen}" />
		<button type="submit">CLick</button>
	</form>

</body>
</html>