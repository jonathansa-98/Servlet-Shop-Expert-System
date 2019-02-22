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
		*{font-size: 30px;}
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
		<p>Question: 	<%=question.getQuestion()		%></p>
		<p>Answers: 	<%=question.getChildren().size()%></p>
		<% if(question.getLabel()!=null) {
			out.print("<p>Label: "+question.getLabel()+"</p>");
		}
		%>
		<select name="answer" required>
			<% 
				Iterator<Pregunta> answers = question.getChildren().iterator();
				int i = 0;
				while(answers.hasNext()) {
					String label = answers.next().getLabel();
					out.print("<option value='"+i+"'>"+label+"</option>");
					i++;
				}
				session = request.getSession(true);
				session.setAttribute("pregunta", question);
			%>
		</select>
		<input type="submit" value="Answer">
	</form>
</body>
</html>