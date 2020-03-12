<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% out.println(session.getAttribute("message")); %>
   <a href="Register.jsp">Register here....</a>
</body>
</html>