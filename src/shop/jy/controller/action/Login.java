package shop.jy.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.jy.DAO.userListDAO;
import shop.jy.DTO.userListDTO;

public class Login implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view=null;
		
		String userid =request.getParameter("userid"); //로그인창에서 받아온아이디
		
		userListDAO dao = userListDAO.getInstance();
		userListDTO dto =dao.loginChk(userid);
		
		String nowuser=dto.getId(); //db확인후 가져온아이디 null이면 비회원이다
		//System.out.println("여기까지 들어옴:"+nowuser);
		
		HttpSession session = request.getSession();
		
		if(nowuser!=null) {//로그인사람의 아이디가 있으면
			session.setAttribute("nowuser", nowuser);
			view = "./index.jsp";
			
		}else {//
			view = "./member/Login_view.jsp";
		}
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
		
	}

}
