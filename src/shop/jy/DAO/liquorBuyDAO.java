package shop.jy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.jy.DTO.basketDTO;
import shop.jy.DTO.liquorBuyDTO;
import util.DBManager;

public class liquorBuyDAO {

	public static liquorBuyDAO dao = null;

	private liquorBuyDAO() {

	}

	public static liquorBuyDAO getInstance() {
		if (dao == null) {
			dao = new liquorBuyDAO();
		}
		return dao;

	}

	public ArrayList<liquorBuyDTO> userbuyListnull(String name, String addr, String tel) {
		ArrayList<liquorBuyDTO> bList = new ArrayList<>();
		String sql = "select * from liquorbuy where id is null";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("title"));
				liquorBuyDTO dto = new liquorBuyDTO();
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setPrice(rs.getInt("price"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setTotal(rs.getInt("total"));
				dto.setNo(rs.getString("no"));
				dto.setName(name);
				dto.setAddr(addr);
				dto.setTel(tel);
				dto.setLasttotal(rs.getInt("lasttotal"));
				bList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bList;
	}

	public void gestbuylistDel() {
		String sql = "delete from liquorbuy where id is null";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

	}

	public ArrayList<liquorBuyDTO> userbuyList(String nowuser) {
		ArrayList<liquorBuyDTO> bList = new ArrayList<>();
		String sql = "select * from userbuy where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nowuser);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("title"));
				liquorBuyDTO dto = new liquorBuyDTO();
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setPrice(rs.getInt("price"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setTotal(rs.getInt("total"));
				dto.setNo(rs.getString("no"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getString("tel"));
				dto.setLasttotal(rs.getInt("lasttotal"));
				bList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bList;
	}

	public void insertbuy(ArrayList<basketDTO> bList, int lasttotal) {
		String sql = "insert into liquorbuy values(?,?,?,?,?,?,?)";
		String nextval = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < bList.size(); i++) {
				nextval = getnextval();
				System.out.println(nextval);
				pstmt.setString(1, nextval);
				pstmt.setString(2, bList.get(i).getId());
				pstmt.setString(3, bList.get(i).getTitle());
				pstmt.setInt(4, bList.get(i).getQuantity());
				pstmt.setInt(5, bList.get(i).getPrice());
				pstmt.setInt(6, bList.get(i).getTotal());
				pstmt.setInt(7, lasttotal);

				pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	

	public String getnextval() {
		String sql = "select buy_no.nextval from dual";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String no = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				no = rs.getString("nextval");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return no;
	}

}
