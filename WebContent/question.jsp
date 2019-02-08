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
		<p>Question: <% out.print(question.getQuestion()); %></p>
		<p>Answers: <% out.print(question.getChildren().size()); %></p>
		<p>Label: <% out.print(question.getLabel()); %></p>
		<select name="answer" required>
			<% 
				Iterator<Pregunta> answers = question.getChildren().iterator();
				int i = 0;
				while(answers.hasNext()) {
					String label = answers.next().getLabel();
					out.print("<option value='"+i+"'>"+label+"</option>");
					i++;
				}
			%>
		</select>
		<br>
		<%
			session.setAttribute("pregunta", question);
      		Pregunta p = (Pregunta)session.getAttribute("pregunta");
      		out.print(session.getId());
      	%>
      	<br>
      	<%
      		out.print(p.getQuestion()); 
      	%>
      	<br>
		<input type="submit" value="Answer">
	</form>
</body>
</html>