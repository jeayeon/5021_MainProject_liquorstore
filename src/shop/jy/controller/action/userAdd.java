package shop.jy.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.jy.DAO.userListDAO;
import shop.jy.DTO.userListDTO;

public class userAdd implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="./index.jsp";
		
		userListDTO dto = new userListDTO();
		dto.setId(request.getParameter("id"));
		dto.setPwd(request.getParameter("password"));
		dto.setName(request.getParameter("username"));
		dto.setTel(request.getParameter("tel"));
		dto.setAddr(request.getParameter("addr"));
		
		
		
		
		
		userListDAO dao = userListDAO.getInstance();
		dao.insertuser(dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
		
	}

}
