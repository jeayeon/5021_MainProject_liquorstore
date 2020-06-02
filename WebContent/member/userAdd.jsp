<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script type="text/javascript" src="./js/chk.js"></script>
<style>
#wrap {
	width: 530px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
	border: 3px solid skyblue
}

td {
	border: 1px solid skyblue
}

#title {
	background-color: skyblue
}
</style>

<link
	href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="hero-wrap"
		style="background-image: url('images/bg_2.jpg');"
		data-stellar-background-ratio="0.5">



		<!-- 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
		<div id="wrap">
			<br> <br> <b><font size="6" color="gray">회원가입</font></b> <br>
			<br> <br>

			<form action="MemberServlet.do" name="frm" method="post">
				<input type="hidden" name="command" value="insert_user">
				<table>
					<tr>
						<td id="title">아이디</td>
						<td><input type="text" name="id" maxlength="20"> <input
							type="button" value="중복확인" onclick="idchk()"> <!-- 윈도우오프너 사용 -->
							<input type="hidden" name="reid" size="20"></td>
					</tr>

					<tr>
						<td id="title">비밀번호</td>
						<td><input type="password" name="password" maxlength="15">
						</td>
					</tr>

					<tr>
						<td id="title">이름</td>
						<td><input type="text" name="username" maxlength="40"></td>
					</tr>
					<tr>
						<td id="title">휴대전화</td>
						<td><input type="text" name="tel" /></td>
					</tr>
					<tr>
						<td id="title">주소</td>
						<td><input type="text" size="50" name="addr" /></td>
					</tr>
				</table>
				<br> <input type="submit" value="가입" onclick="return useradd()" />
				<input type="button" value="취소" onclick="location.href='MemberServlet.do?command=Logout'">
			</form>
		</div>
	</div>
</body>
</html>


