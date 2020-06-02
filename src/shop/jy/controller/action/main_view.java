package shop.jy.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.jy.DAO.liquorListDAO;
import shop.jy.DTO.liquorListDTO;
import util.MainPageNumber;

public class main_view implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = "./main_view.jsp";
		liquorListDAO dao = liquorListDAO.getInstance();
		
		
		
		
		int nowPage = 1;//현재 페이지 정보 변수 첫시작은 1페이지부터 시작하니
		if(request.getParameter("page") != null) {//클라이언트가 페이지 정보를보내줬다면
			//클라이언트가보낸페이지로 정보를바꿔라
			nowPage = Integer.valueOf(request.getParameter("page"));
		}
		
		MainPageNumber pagemaker = new MainPageNumber();//페이지 객체 페이지넘버링을어떤방식으로했는가?
		pagemaker.setPage(nowPage); //현재페이지 정보
		pagemaker.setCount(dao.allCount());//토탈 글을 읽어오는 메서드
		
		System.out.println("현재페이지 시작번호:" +pagemaker.getNowPageStart() );
		System.out.println("현재페이지 끝번호:" +pagemaker.getNowPageEnd() );
ArrayList<liquorListDTO> Llist = dao.liquorList(pagemaker.getNowPageStart(), pagemaker.getNowPageEnd());
		
		if(Llist != null) {
			request.setAttribute("Llist", Llist);
			request.setAttribute("pageMaker", pagemaker);
			System.out.println("글목록 : "+Llist.size());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}

}
