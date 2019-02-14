<%@page import="model.Pregunta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>You would love the </h1>
		<% Pregunta question = (Pregunta) request.getAttribute("pregunta"); %>
		<p>Label: 		<%=question.getLabel()			%></p>
</body>
</html>