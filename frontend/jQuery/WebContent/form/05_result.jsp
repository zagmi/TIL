<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>결과값</title>

</head>
<body>
	<b>${param.userName}님의 정보를 출력합니다.</b>
	<ul>
		<li>아이디: ${param.userId}</li>
		<li>주소: ${param.userAddr}</li>
	</ul>
</body>
</html>