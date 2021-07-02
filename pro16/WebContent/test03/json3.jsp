<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
 $(function() {
	 $("#checkJson").click(function () {
		var jsonStr = '{"name":"박지성","age":34,"gender":"남","nickname":"축구왕"}';
		var jsonInfo = JSON.parse(jsonStr);
		var output = "회원<br>";
		output += "======<br>";
		output += "이름: " + jsonInfo.name + "<br>";
		output += "나이: " + jsonInfo.age + "<br>";
		output += "성별: " + jsonInfo.gender + "<br>";
		output += "별칭: " + jsonInfo.nickname + "<br>";
		$("#output").html(output);
	 });
 });
</script>
<body>
<div id = "output"></div>
<input type = "button" id ="checkJson" value="출력" />
</body>
</html>