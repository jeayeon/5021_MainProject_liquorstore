package shop.jy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.jy.DTO.liquorListDTO;
import util.DBManager;

public class liquorListDAO {

	public static liquorListDAO dao = null;

	private liquorListDAO() {

	}

	public static liquorListDAO getInstance() {
		if (dao == null) {
			dao = new liquorListDAO();
		}
		return dao;

	}
	
	public String pictureName(String title) {
		String sql = "select picture from liquorlist where title=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String picture = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				picture =rs.getString("picture");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return picture;

	}
	public int allCount() { //내가 작성한 글이 몇개인지 가져오는 메서드
		String sql = "select count(*) from liquorlist";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return 0;

	}

	public liquorListDTO SingleView(String title) {
		liquorListDTO dto = new liquorListDTO();
		String sql = "select * from liquorlist where title=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setTitle(rs.getString("title"));
				dto.setPrice(rs.getInt("price"));
				dto.setTypeof(rs.getString("type"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setContent(rs.getString("content"));
				dto.setCount(rs.getInt("count"));
				dto.setPicture(rs.getString("picture"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return dto;

	}

	public ArrayList<liquorListDTO> liquorList(int startNum, int endNum) {
		ArrayList<liquorListDTO> lList = new ArrayList<>();
		//String sql = "select * from liquorlist order by count desc";
		String sql = "select t.* from (select sub.*, rownum as rnum from (select * from liquorlist order by count desc) sub) t where rnum between ? and ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				liquorListDTO dto = new liquorListDTO();
				dto.setTitle(rs.getString("title"));
				dto.setPrice(rs.getInt("price"));
				dto.setTypeof(rs.getString("type"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setContent(rs.getString("content"));
				dto.setCount(rs.getInt("count"));
				dto.setPicture(rs.getString("picture"));
				lList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return lList;
	}

	public void insertliquor(liquorListDTO dto) {
		String sql = "insert into liquorlist values(?,?,?,?,?,0,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getTypeof());
			pstmt.setInt(3, dto.getQuantity());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getPicture());
			pstmt.setInt(6, dto.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
