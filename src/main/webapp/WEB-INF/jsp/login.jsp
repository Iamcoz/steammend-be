<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 로그인 </h1>
	<form action="userlogin.do" method="post">
		<input type="hidden" value="login">
		<table border="1">
			<col width="100"><col width="100">
			<tr>
				<th> ID </th>
				<td><input type="text" name="bm_id"></td>
			</tr>
			<tr>
				<th> PW </th>
				<td><input type="text" name="bm_pw"></td>
			</tr>
			<tr>
				<td clspan="2" align="center">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>