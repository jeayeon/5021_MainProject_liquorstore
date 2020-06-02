package shop.jy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.jy.DTO.liquorBuyDTO;
import util.DBManager;

public class guestBuyDAO {
	
	public static guestBuyDAO dao = null;

	private guestBuyDAO() {

	}

	public static guestBuyDAO getInstance() {
		if (dao == null) {
			dao = new guestBuyDAO();
		}
		return dao;

	}
	
	
	public void guestbuy(String name, String addr, String tel, ArrayList<liquorBuyDTO> buylist) {
		String sql = "insert into guestbuy values(guest_no.nextval,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<buylist.size();i++) {
				pstmt.setString(1, name);
				pstmt.setString(2, tel);
				pstmt.setString(3, addr);
				pstmt.setString(4, buylist.get(i).getTitle());
				pstmt.setInt(5, buylist.get(i).getQuantity());
				pstmt.setInt(6, buylist.get(i).getPrice());
				pstmt.setInt(7, buylist.get(i).getTotal());
				pstmt.setInt(8, buylist.get(i).getLasttotal());
				pstmt.executeUpdate();
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
