<%@page import="model.Pregunta"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<style type="text/css">
		body{
			margin-left: 5em;
			margin-right: 5em;
		}
	</style>
</head>
<body>
	<h1 align="center">Shop expert system</h1>
	<form method="POST" action="SelectShop" accept-charset=utf-8>
	<% Pregunta question = (Pregunta) request.getAttribute("pregunta"); %>
		<p><% out.print(question.getQuestion()); %></p>
		<p><% out.print(question.getChildren().size()); %></p>
		<p><% out.print(question.getLabel()); %></p>
		<select name="answer" required>
			<% 
				Iterator<Pregunta> answers = question.getChildren().iterator();
				while(answers.hasNext()) {
					String label = answers.next().getLabel();
					out.print("<option value='"+label+"'>"+label+"</option>");
				}
			%>
		</select>
		<br><br>
		<input type="submit" value="Answer">
	</form>
</body>
</html>