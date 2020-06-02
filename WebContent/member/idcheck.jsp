<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 중복체크</title>
<script type="text/javascript" src="./js/chk.js"></script>
</head>
<body>
	<h2>아이디 중복 확인</h2>
	<form action="MemberServlet.do" method="get" name="frm">
		아이디 : <input type="text" name="userid" value="${userid}"> 
			<input type="hidden" name="command" value="userchk">
		<input type="submit" value="중복 체크">
		<br>
		<c:if test="${result==1}"> <!-- 리퀘스트영역에서받아온값이 1이면 사용중 -1이면 가능으로 짰다 -->
		<script type="text/javascript">
		opener.document.frm.id.value=""; //날 열어준 부모창에 현재문서에 벨류값을 지우라는뜻
		</script>
		${userid} 는 이미 사용중인 아이디입니다.
		</c:if>
		<c:if test="${result==-1}"> 
		${userid} 는 사용 가능한 아이디입니다.
		<input type="button" value="사용" class="cancel" onclick="idok()">
		</c:if>
		
	
	</form>

</body>
</html>