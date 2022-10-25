<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 가입 </h2>
	<form action="join.do" method="post">
		<input type="hidden" value="insert">
		<table border="1">
			<col width="100"><col width="100">
			<tr>
				<th> ID </th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th> PW </th>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<th> NAME </th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th> NICKNAME </th>
				<td><input type="text" name="nickname"></td>
			</tr>
			<tr>
				<th> BIRTH </th>
				<td><input type="text" name="birth"></td>
			</tr>
			<tr>
				<th> STEAM ID </th>
				<td><input type="text" name="steam_id"></td>
			</tr>
			<tr>
				<td clspan="2" align="center">
					<input type="submit" value="회원가입">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>