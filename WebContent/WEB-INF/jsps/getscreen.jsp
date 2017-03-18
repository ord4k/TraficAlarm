<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Your last screenshot was taken at ${last}
<%
byte[] screenBytes = (byte[])session.getAttribute("screen");
String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(screenBytes); 
%>
 <img src="data:image/jpg;base64, <%=b64%>" alt="Visruth.jpg not found" />


</body>
</html>