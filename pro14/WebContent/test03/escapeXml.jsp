<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>escapeXml 변환하기</h2>
	<h2>
		<c:out value="&lt;" escapeXml="true"/>
		<c:out value="&lt;" escapeXml="false"/>
		<c:out value="&gt;" escapeXml="true"/>
		<c:out value="&gt;" escapeXml="false"/>
		<c:out value="&amp;" escapeXml="true"/>
		<c:out value="&amp;" escapeXml="false"/>
		<c:out value="&#039;" escapeXml="true"/>
		<c:out value="&#039;" escapeXml="false"/>
		<c:out value="&#034;" escapeXml="true"/>
		<c:out value="&#034;" escapeXml="false"/>			
	</h2>
</body>
</html>