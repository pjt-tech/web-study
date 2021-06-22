<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sec01.ex01.*"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
			
		</tr>
		<tr align="center">
			<td>${memberLists[0].id}</td>
			<td>${memberLists[0].pwd}</td>
			<td>${memberLists[0].name}</td>
			<td>${memberLists[0].email}</td>
			
		</tr>
		
		<tr align="center">
			<td>${memberLists[1].id}</td>
			<td>${memberLists[1].pwd}</td>
			<td>${memberLists[1].name}</td>
			<td>${memberLists[1].email}</td>
			
		</tr>
	</table>
</body>
</html>