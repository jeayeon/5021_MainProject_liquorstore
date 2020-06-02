package shop.jy.controller.boardaction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.jy.DAO.BoardDAO;
import shop.jy.DTO.BoardDTO;

public class blog_singleview implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "./board/blog_singleview.jsp";
		
		String no=request.getParameter("no");
		
		BoardDAO dao =BoardDAO.getInstance();
		BoardDTO dto = dao.blogSingle(no);
		
		request.setAttribute("SingleB", dto);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
