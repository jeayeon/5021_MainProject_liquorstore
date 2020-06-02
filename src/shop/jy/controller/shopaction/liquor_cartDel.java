package shop.jy.controller.shopaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.jy.DAO.basketDAO;

public class liquor_cartDel implements shopAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		basketDAO dao = basketDAO.getInstance();
		dao.delcart(no);
		
		new liquor_cartView().execute(request, response);
	}

}
