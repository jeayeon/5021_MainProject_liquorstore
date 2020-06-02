package shop.jy.controller.boardaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import shop.jy.DAO.BoardDAO;
import shop.jy.DTO.BoardDTO;

public class blog_Add implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "./board/blog_list.jsp";
		BoardDAO dao = BoardDAO.getInstance();
		// SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd
		// HH:mm:ss", Locale.KOREA );
		// Date currentTime = new Date ();
		// String mTime = mSimpleDateFormat.format ( currentTime );

		// 파일 업로드
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();// 서블릿에서 html에 화면을띄울때 쓰는 객체
		// 여기를 바꿔주면 다운받는 경로가 바뀜
		// String savePath = "./board/upload";
		// 최대 업로드 파일 크기 5MB로 제한
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		// 용량단위:비트,바이트,키로바이트,메가,기가,테라바이트
		String encType = "UTF-8";
		// ServletContext context = getServletContext();
		// String uploadFilePath = context.getRealPath(savePath);
		String uploadFilePath = (String) request.getAttribute("uploadFilePath"); // 서블릿에서 생성후받아옴(위치)
		System.out.println("서버상의 실제 디렉토리 :" + uploadFilePath);
		try {
			MultipartRequest multi = new MultipartRequest(request, // request 객체
					uploadFilePath, // 서버상의 실제 디렉토리
					uploadFileSizeLimit, // 최대 업로드 파일 크기
					encType, // 인코딩 방법

					// 동일한 이름이 존재하면 새로운 이름이 부여됨
					new DefaultFileRenamePolicy());

			// 업로드된 파일의 이름 얻기
			String fileName = multi.getFilesystemName("picture"); // 인풋타입 파일은 이 메소드로 얻어야한다.
			if (fileName == null) { // 파일이 업로드 되지 않았을때
				System.out.print("파일 업로드 되지 않았음");
			} else { // 파일이 업로드 되었을때
				System.out.println("업로드 성공!! 사진이름" + fileName);
				// request.setAttribute("fname", fileName);
			} // else
//			String title =multi.getParameter("title");
//			String type =multi.getParameter("typeof");
//			String content =multi.getParameter("content");
//			String file =fileName;
//			int quan = Integer.valueOf(multi.getParameter("quantity"));
//			int count = Integer.valueOf(multi.getParameter("count"));
//			int price = Integer.valueOf(multi.getParameter("price"));
//			
//			
//			System.out.println(title+"/"+type+"/"+content+"/"+file+"/"+quan+"/"+count+"/"+price);
			BoardDTO dto = new BoardDTO();
			dto.setTitle(multi.getParameter("title"));
			dto.setId(multi.getParameter("id"));
			dto.setContent(multi.getParameter("content"));
			dto.setPicture(fileName);
			String no = dao.getnextval();
			dto.setNo(no);
			dao.insertblog(dto);

		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}

		new blog_List().execute(request, response);

	}

}
