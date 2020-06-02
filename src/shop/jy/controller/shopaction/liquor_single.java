package shop.jy.controller.shopaction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.jy.DAO.liquorListDAO;
import shop.jy.DTO.liquorListDTO;

public class liquor_single implements shopAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="./shop/liquor_Single.jsp";
		String title=request.getParameter("title");
		
		System.out.println("title: "+title);
		
		liquorListDAO dao = liquorListDAO.getInstance();
		liquorListDTO dto = dao.SingleView(title);
		
		request.setAttribute("Single", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
		
		 
	}

}
