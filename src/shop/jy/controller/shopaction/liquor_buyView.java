package shop.jy.controller.shopaction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.jy.DAO.basketDAO;
import shop.jy.DAO.userListDAO;
import shop.jy.DTO.userListDTO;

public class liquor_buyView implements shopAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "./shop/liquor_buyView.jsp";

		HttpSession session = request.getSession();
		String nowuser = (String) session.getAttribute("nowuser");
		
		userListDAO dao =userListDAO.getInstance();
		userListDTO userInfo =dao.loginChk(nowuser);
		
		String[] chkno = request.getParameterValues("check");// 장바구니에서 구매할꺼만 선택한 리스트 번호
		
		basketDAO bdao = basketDAO.getInstance();
	
		if(chkno!=null) {
			for(int i=0; i<chkno.length;i++) {
				int money= bdao.totalmoney(chkno[i]);
				request.setAttribute("totalmoney"+i, money );
			}
		}
		
		int total = 0;
		
		for(int i=0;;i++) {
			if(request.getAttribute("totalmoney"+i)!=null) {
				total = total +(int)request.getAttribute("totalmoney"+i);
			}else {
				break;
				
			}
		}
		//System.out.println(total);
				
		
		request.setAttribute("total", total);
		session.setAttribute("basketno", chkno); //리스트번호 
		request.setAttribute("userInfo", userInfo);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
