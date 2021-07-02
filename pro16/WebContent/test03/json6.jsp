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
		
		$.ajax({
			type:"post",
			async:false,
			url:"${contextPath}/pro16/json2",
			success:function (data,textStatus){
				var jsonInfo = JSON.parse(data);
				var memberInfo = "회원 정보<br>";
				memberInfo+= "========<br>"
				for(var i in jsonInfo.members) {
					memberInfo+="이름: " + jsonInfo.members[i].name + "<br>";
					memberInfo+="나이: " + jsonInfo.members[i].age + "<br>";
					memberInfo+="성별: " + jsonInfo.members[i].gender + "<br>";
					memberInfo+="별명: " + jsonInfo.members[i].nickname + "<br><br><br>";
				}
				$("#output").html(memberInfo);
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