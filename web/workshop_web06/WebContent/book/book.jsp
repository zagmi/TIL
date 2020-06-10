<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/book.js"></script>
	
<style>
	header {
	background-color: #CDD4D2;
    padding: 10px 0;
    text-align: center;
    margin-bottom: 15px;
	}
	
	table{
	width: 100%;
	border: 1px solid #CDD4D2;
	border-collapse: collapse;
	}
	tr,td{
	border: 1px solid #CDD4D2;
	}
	#notice{
	text-align: right;
	}
	#color{
	background-color: #CDD4D2;
	height: 40px;
	}
	.bookinfo{
	width: 127px;
	}
	.input{
	padding: 5px 15px;
	}
	.input_desc{
	background-color: #CDD4D2;
	padding: 5px 15px;
	}
	
	#button{
		background-color: #CDD4D2;
		text-align: center;
		padding: 5px 15px;
		margin-top: 15px;
	}
	
	footer{
	text-align: center;
	}
	
	footer p{
	margin-block-start: 0px;
	}
</style>

<body>
	<c:choose>
		<c:when test="${vo != null}">
			<header>
				<h2>도서 등록 화면</h2>
			</header>
			
			<form action='../front.do' method='post' name='Frm' onsubmit="return check()">
			<input type='hidden' name='command' value='book'>
			<table>
				<thead>
					<tr>
						<td colspan='2' id='notice'>*표시가 된 항목은 필수 입력 항목입니다.</td>
					</tr>
					<tr>
						<td colspan='2' id='color'></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class='bookinfo'>* 도서번호</td> 
						<td class= 'input'>
							<input type="number" name='isbn1'> - <input type='number' name='isbn2'> - <input type='number'name='isbn3'>
						</td>
					</tr>
					<tr>
						<td class='bookinfo'>* 도서제목</td> 
						<td class= 'input'>
							<input type='text'name='title'>
						</td>
					</tr>
					<tr>
						<td  class='bookinfo'>* 도서종류</td>
						<td class='input'>
		     				<select name='kinds'>
		     					<option value='종류'>종류</option>
		         				<option value='자바'>자바</option>
		         				<option value='운영체제'>운영체제</option>
		        				<option value='웹'>웹</option>
		       				  	<option value='안드로이드'>안드로이드</option>
		      				</select>
						</td>
					</tr>
					<tr>
						<td class='bookinfo'>출판국가</td>
						<td class='input'>
		     				<input type="radio" name='country' value='domestic'>국내도서
		      				<input type="radio" name='country' value='overseas'>외국도서
		      			</td>
					</tr>
					<tr>
						<td class='bookinfo'>출판일</td>
						<td class='input'>
		     				 <input type="date" name='release' placeholder="yyyy-MM-dd">
		     			</td>
					</tr>
					<tr>
						<td class='bookinfo'>출판사</td>
						<td class='input'>
						      <select name='publisher'>
						         <option value='엔코아'>엔코아</option>
						         <option value='한빛'>한빛</option>
						         <option value='두잇'>두잇</option>
						         <option value='길벗'>길벗</option>
						      </select>
						</td>
					</tr>
					<tr>
						<td class='bookinfo'>* 저자</td>
						<td class='input'>
		     				<input type='text' name='writer'>
						</td>
					</tr>
					<tr>
						<td class='bookinfo'>도서가격</td>
						<td class='input'>
							<input type="number" name='price'>
						    <select name='unit'>
					        	<option value='원'>원</option>
					        	<option value='달러'>달러</option>
					        	<option value='엔'>엔</option>
					        	<option value='위안'>위안</option>
						      </select>
						</td>
					</tr>
					<tr>
						<td class='bookinfo'>요약내용</td>
						<td class='input_desc'>
		     				<textarea rows="3" cols="20" name='desc'></textarea>
		     			</td>
					</tr>
				</tbody>
			</table>
			
			<div id='button'>
				<input type="submit" value='도서등록'> 
				<input type="reset" value='취소'>
			</div>
			</form>
			<footer>
				<a href='#'>사전 도움말</a> - 
				<a href='#'>이용약관</a> - 
				<a href='#'>개인정보취급방침</a> - 
				<a href='#'>책임의 한계와 법적고지</a> - 
				<a href='#'>고객센터</a>
				<p>Copyright (C) 2020. HaBaRee. all rights reserved.</p> 
			</footer>
		</c:when>
		<c:otherwise>
			<h2>로그인 하십시오</h2>
			<a href='login.jsp'>로그인 페이지로</a>
		</c:otherwise>
	</c:choose>
	
</body>
</html>