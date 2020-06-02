package shop.jy.controller.shopaction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.jy.DAO.basketDAO;
import shop.jy.DAO.guestBuyDAO;
import shop.jy.DAO.liquorBuyDAO;
import shop.jy.DTO.basketDTO;
import shop.jy.DTO.liquorBuyDTO;

public class liquor_buyok implements shopAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "./shop/liquor_buyok.jsp";
		int lasttotal = 0;
		if (request.getParameter("lasttotal") != null) {
			lasttotal = Integer.valueOf(request.getParameter("lasttotal"));
		}

		HttpSession session = request.getSession();
		String nowuser = (String) session.getAttribute("nowuser");
		String[] chkno = (String[]) session.getAttribute("basketno"); // 장바구니 물품 번호
		
		basketDAO dao = basketDAO.getInstance();
		liquorBuyDAO Ldao = liquorBuyDAO.getInstance();
		guestBuyDAO gdao = guestBuyDAO.getInstance();
		if(chkno!=null) {
			ArrayList<basketDTO> bList = dao.userbuyList(chkno); // 유저가 구매한 물건 리스트 비회원도
			
			// System.out.println("주문번호 인덱스크기:" + bList.size());
			Ldao.insertbuy(bList, lasttotal);// 구매완료내역 주문테이블에 저장
			
			dao.basketDel(chkno); // 장바구니에서 주문한 내용 삭제
		}
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		ArrayList<liquorBuyDTO> buylist=null;
		if(nowuser!=null) {
			
			 buylist = Ldao.userbuyList(nowuser); // 구매자 최종 구매 내역
		}else {//비회원 최종구매내역
			 buylist = Ldao.userbuyListnull(name, addr, tel);
			 gdao.guestbuy(name, addr, tel,buylist); //게스트 주문내역 인설트
			 Ldao.gestbuylistDel();//주문내역중 게스트가 주문한 내역은 삭제(게스트전용테이블에 내용 저장되어있어서)
			 
		}

		session.setAttribute("buyList", buylist);

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
