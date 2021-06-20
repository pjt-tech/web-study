<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*,sec01.ex02.*"%>
    
    <jsp:useBean id="m1" class="sec01.ex02.MemberBean"></jsp:useBean>
    <jsp:useBean id="addr" class="sec01.ex02.Address"></jsp:useBean>
	<jsp:setProperty property="*" name="m1"/>
	<jsp:setProperty property="city" name="addr" value="인천"/>
	<jsp:setProperty property="zipcode" name="addr" value="07654"/>
	
	
<%
	m1.setAddr(addr);
%>	
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
			<td width="20%"><b>도시</b></td>
			<td width="20%"><b>우편번호</b></td>
			
		</tr>
		<tr align="center">
			<td>${m1.id}</td>
			<td>${m1.pwd}</td>
			<td>${m1.name}</td>
			<td>${m1.email}</td>
			<td>${m1.addr.city}</td>
			<td>${m1.addr.zipcode}</td>
			
		</tr>
		
		<tr align="center">
			<td>${m1.id}</td>
			<td>${m1.pwd}</td>
			<td>${m1.name}</td>
			<td>${m1.email}</td>
			<td><%=m1.getAddr().getCity() %></td>
			<td><%=m1.getAddr().getZipcode() %></td>
			
		</tr>
		
		
	</table>

</body>
</html>