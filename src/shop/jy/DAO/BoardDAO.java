package shop.jy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.jy.DTO.BoardDTO;
import util.DBManager;

public class BoardDAO {
	
	public static BoardDAO dao = null;

	private BoardDAO() {

	}

	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;

	}
	public int allCount() { //내가 작성한 글이 몇개인지 가져오는 메서드
		String sql = "select count(*) from blog";
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
	
	public BoardDTO blogSingle(String no) {
		BoardDTO dto = new BoardDTO();
		String sql = "select * from blog where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				dto.setNo(rs.getString("no"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPicture(rs.getString("picture"));
				dto.setWritedate(rs.getTimestamp("writedate"));
				System.out.println("사진이름: "+rs.getString("picture"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}


	public ArrayList<BoardDTO> blogList(int startNum, int endNum) {
		ArrayList<BoardDTO> lList = new ArrayList<>();
		//String sql = "select * from blog order by no desc";
		String sql = "select t.* from (select sub.*, rownum as rnum from (select * from blog order by no desc) sub) t where rnum between ? and ?";
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
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getString("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPicture(rs.getString("picture"));
				dto.setWritedate(rs.getTimestamp("writedate"));
				lList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return lList;
	}

	
	public void insertblog(BoardDTO dto) {
		String sql = "insert into blog(no,id,title,content,picture) values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNo());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getPicture());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public String getnextval() {
		String sql = "select blog_no.nextval from dual";
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
