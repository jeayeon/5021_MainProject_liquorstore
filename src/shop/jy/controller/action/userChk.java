package shop.jy.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.jy.DAO.userListDAO;
import shop.jy.DTO.userListDTO;

public class userChk implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "./member/idcheck.jsp";
		
		String userid = request.getParameter("userid");


		userListDAO dao = userListDAO.getInstance();
		int result = dao.idchk(userid);
		
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
