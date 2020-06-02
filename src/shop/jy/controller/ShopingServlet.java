package shop.jy.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.jy.controller.shopaction.shopAction;

/**
 * Servlet implementation class ShopingServlet
 */
@WebServlet("/ShopingServlet.do")
public class ShopingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String command = request.getParameter("command");
		System.out.println("ShopingServlet에서 요청을 받음을 확인 : " + command);
		if(command.equals("liquor_add")) {//클라이언트가 업로드한파일을 실제서버에 저장할 디렉토리위치를 지정
			// 여기를 바꿔주면 다운받는 경로가 바뀜
			String savePath = "./images";//폴더는 미리 생성해야함
			ServletContext context = getServletContext(); //웹상의 현재위치(물리적인디렉토리)를 가져오는 메소드(컨택스트패스까지)
			//
			
			String uploadFilePath = context.getRealPath(savePath);
			request.setAttribute("uploadFilePath", uploadFilePath);
			System.out.println(uploadFilePath + "컨트롤러");
		}
		
		String command2 = request.getParameter("command2"); //장바구니에서 수량 변경할때 사용할 변수\
		
		String test = request.getParameter("test");
		if(test!=null) {
			System.out.println("버튼의 벨류:"+test);
		}
		
		ActionFactoryShop af = ActionFactoryShop.getInstance();
		shopAction ac = af.Command(command,command2);

		ac.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
