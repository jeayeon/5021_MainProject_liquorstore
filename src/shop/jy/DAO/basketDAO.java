package shop.jy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.jy.DTO.basketDTO;
import shop.jy.DTO.liquorListDTO;
import util.DBManager;

public class basketDAO {

	public static basketDAO dao = null;

	private basketDAO() {

	}

	public static basketDAO getInstance() {
		if (dao == null) {
			dao = new basketDAO();
		}
		return dao;

	}
	public void basketDel(String[] chkno) {
		String sql = "delete from basket where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < chkno.length; i++) {

				pstmt.setString(1, chkno[i]);
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void basketListMod(String[] chkno, String[] quantityList, String[] bListPrice) {
		String sql = "update basket set quantity =? ,total=? where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < chkno.length; i++) {
				int price = Integer.valueOf(bListPrice[i]);
				int quantity = Integer.valueOf(quantityList[i]);
				int total = price*quantity;
				
				pstmt.setString(1, quantityList[i]);
				pstmt.setInt(2, total);
				pstmt.setString(3, chkno[i]);
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public ArrayList<basketDTO> userbuyList(String[] chkno) {
		ArrayList<basketDTO> bList = new ArrayList<>();
		String sql = "select * from basket where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < chkno.length; i++) {

				pstmt.setString(1, chkno[i]);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					System.out.println(rs.getString("title"));
					basketDTO dto = new basketDTO();
					dto.setId(rs.getString("id"));
					dto.setTitle(rs.getString("title"));
					dto.setPrice(rs.getInt("price"));
					dto.setQuantity(rs.getInt("quantity"));
					dto.setTotal(rs.getInt("total"));
					dto.setNo(rs.getString("no"));
					dto.setPicture(rs.getString("picture"));
					bList.add(dto);

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bList;
	}
	
	public int totalmoney(String no) {
		String sql = "select total from basket where no=? order by no desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int total=0;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				total =rs.getInt("total");
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return total;
	}
	public ArrayList<basketDTO> basketListnull() {
		ArrayList<basketDTO> bList = new ArrayList<>();
		String sql = "select * from basket where id is null order by no desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				basketDTO dto = new basketDTO();
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setPrice(rs.getInt("price"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setTotal(rs.getInt("total"));
				dto.setNo(rs.getString("no"));
				dto.setPicture(rs.getString("picture"));
				bList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bList;
	}

	public ArrayList<basketDTO> basketList(String nowuser) {
		ArrayList<basketDTO> bList = new ArrayList<>();
		String sql = "select * from basket where id=? order by no desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nowuser);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				basketDTO dto = new basketDTO();
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setPrice(rs.getInt("price"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setTotal(rs.getInt("total"));
				dto.setNo(rs.getString("no"));
				dto.setPicture(rs.getString("picture"));
				bList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bList;
	}

	public String getnextval() {
		String sql = "select basket_no.nextval from dual";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String no = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				no = rs.getString("nextval");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return no;
	}

	public void insertcart(basketDTO dto) {
		String sql = "insert into basket values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setInt(3, dto.getQuantity());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setInt(5, dto.getTotal());
			pstmt.setString(6, dto.getNo());
			pstmt.setString(7, dto.getPicture());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void delcart(String no) {
		String sql = "delete from basket where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
