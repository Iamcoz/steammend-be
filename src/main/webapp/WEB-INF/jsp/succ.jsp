<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> ${dto.getId()}</h1> <h3>님 로그인!!!!!!!!</h3>
	<h3> steamId : </h3><h1> ${dto.getSteamId()}</h1> 
	
	
	
	<form action="userlogout.do" method="post">
		<input type="submit" value="로그아웃">
	</form>
	
	<br><br><br>
	<form action="userlogincheck.do" method="post">
		<input type="submit" value="login check">
	</form>
	

</body>
</html>