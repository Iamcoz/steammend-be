<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1> ${res.id}</h1> <h3>님 로그 아웃 성공</h3>
		
		<form action="http://localhost:8080/steammend-test/login.html" method="get">
			<input type="submit" value="초기화면으로">
		</form>
</body>
</html>