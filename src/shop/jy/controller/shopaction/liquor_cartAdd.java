package shop.jy.controller.shopaction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.jy.DAO.basketDAO;
import shop.jy.DAO.liquorListDAO;
import shop.jy.DTO.basketDTO;

public class liquor_cartAdd implements shopAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nowuser = request.getParameter("nowuser");
		String title = request.getParameter("title");
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		int price = Integer.valueOf(request.getParameter("price"));
		
		int total = quantity*price;
		
		liquorListDAO liquordao = liquorListDAO.getInstance();
		String picture = liquordao.pictureName(title);
		
//		System.out.println(nowuser+"님: "+ title+"구매완료 가격: "+ total);
		basketDAO dao = basketDAO.getInstance();
		basketDTO dto = new basketDTO();
		dto.setId(nowuser);
		dto.setTitle(title);
		dto.setQuantity(quantity);
		dto.setPrice(price);
		dto.setTotal(total);
		String no = dao.getnextval();
		dto.setNo(no);
		dto.setPicture(picture);
		
		dao.insertcart(dto);
		
		new liquor_cartView().execute(request, response);
		
		
		
		
		
	}

}
