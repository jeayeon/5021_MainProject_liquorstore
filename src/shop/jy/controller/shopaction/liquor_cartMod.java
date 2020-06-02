package shop.jy.controller.shopaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.crypto.provider.RSACipher;

import shop.jy.DAO.basketDAO;

public class liquor_cartMod implements shopAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] bListno = request.getParameterValues("bListno");
		String[] quantityList = request.getParameterValues("quantity");
		String[] bListPrice = request.getParameterValues("price");
		
		for(int i=0; i<bListno.length;i++) {
			System.out.println("장바구니번호: " + bListno[i]);
			System.out.println(i+"번 수량: " + quantityList[i]);
		}
		
		basketDAO dao = basketDAO.getInstance();
		dao.basketListMod( bListno,quantityList, bListPrice);
		
		new liquor_cartView().execute(request, response);
		
		
		
	}

}
