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
		var jsonInfo = '{"name":"박지성","age":34,"gender":"남","nickname":"축구왕"}';
		$.ajax({
			type:"post",
			async:false,
			url:"${contextPath}/pro16/json",
			data:{jsonInfo:jsonInfo},
			success:function (data,textStatus){
				
			},
			error:function(data,textStatus) {
				alert("에러발생");
			},
			complite:function(data,textStatus) {
				
			}
		});
	 });
 });
</script>
<body>
<div id = "output"></div>
<input type = "button" id ="checkJson" value="출력" />
</body>
</html>