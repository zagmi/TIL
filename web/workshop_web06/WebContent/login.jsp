<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
	@charset "UTF-8";

	div{
		border: 5px solid gray;
		border-style: ridge;
		width:550px;
		padding:30px;
		margin: 10px;
	}
	
	img{
		width:150px;
		height:150px;
		margin-right: 30px;
	}
	form{
	float:right;
	text-align:right;
	}
	form p{
	text-align:center;
	}
	
	hr{
	border: 0;
	border-top: 1px gray;
	border-style:dotted;
	margin: 15px 0;
	width: 182.4px;
    float: right;
	}
	
	label{
	font-weight: 0;
	margin-right: 5px;
	}
	
	form [type=submit]{
	position: absolute;
    margin-top: 26px;
    }
</style>
</head>
<body>
	<div>
		<img src='img/book.png'>
		
		<form action='front.do' method='post' id='loginFrm')>
			<input type='hidden' name='command' value='login'>
			<p>로그인하여 주세요</p>
			<label>ID</label><input type='text' name='id' class='login'><br>
			<label>PASSWORD</label> <input type="password" name='pass' class='login'><br>
			<hr>
			<input type="submit" value ='LOGIN' class="btn btn-success">
		</form>
	</div>
</body>
</html>