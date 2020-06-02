
function directnow(){
	var submit = document.frm;
	if(submit!=null){
		submit.submit();
	}
	
}

function cartMod(){
	
}

function useradd() {
	if (document.frm.id.value.length == 0) {
		alert("아이디를 입력하세요.");
		document.frm.id.focus();
		return false;
	}
	if (document.frm.password.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		document.frm.password.focus();
		return false;
	}
	if (document.frm.username.value.length == 0) {
		alert("이름을 입력하세요.");
		document.frm.username.focus();
		return false;
	}
	if (document.frm.tel.value.length == 0) {
		alert("전화번호를 입력하세요.");
		document.frm.tel.focus();
		return false;
	}
	if (document.frm.addr.value.length == 0) {
		alert("주소를 입력하세요.");
		document.frm.addr.focus();
		return false;
	}
	return true;
}
function idchk() {
	if(document.frm.id.value ==""){
		alert('아이디를 입력해 주십시오');
		document.frm.id.focus();
		return;
	}
	var url="MemberServlet.do?userid="+document.frm.id.value+"&command=userchk";
	//새로운 창에서 띄우겠다
	window.open(url, "_blank_1", 
			"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function loginCheck() {
	if (document.frm.id.value.length == 0) {
		alert("아이디를 입력하세요.");
		return false;
	}
	return true;
	}
function idok(){
	alert("완료");
	opener.frm.id.value=document.frm.userid.value;
	opener.frm.reid.value= document.frm.userid.value;
	self.close();
}