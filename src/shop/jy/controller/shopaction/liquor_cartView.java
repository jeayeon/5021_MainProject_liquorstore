package shop.jy.controller.shopaction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.jy.DAO.basketDAO;
import shop.jy.DTO.basketDTO;

public class liquor_cartView implements shopAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "./shop/liquor_cart.jsp";
		
		HttpSession session = request.getSession();
		
		String nowuser = (String)session.getAttribute("nowuser");
		
		basketDAO dao = basketDAO.getInstance();
		ArrayList<basketDTO> bList =null;
		if(nowuser!=null) {
			bList = dao.basketList(nowuser);
			
		}else {
			bList = dao.basketListnull();
		}
		
		request.setAttribute("bList", bList);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
		
	}

}
