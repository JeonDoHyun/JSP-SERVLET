package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DatabaseUtil;

public class UserDAO {

	public int login(String userID, String userPassword) {
		String sql = "SELECT userPassword FROM USER WHERE userID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID); // SQL문의 물음표에 해당되는것, 즉 1번째 물음표
			rs = pstmt.executeQuery(); // 검색할때 query 씀

			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1; // 성공
				} else {
					return 0;
				}
			}
			return -1;// 아이디없음

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return -2; // 데이터 베이스 오류
	}

	public int join(UserDTO user) {
		String sql = "INSERT INTO USER (userID, userPassword, userEmail, userEmailHash, userEmailChecked ) VALUES (?, ?, ?, ?, false)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID()); // SQL문의 물음표에 해당되는것, 즉 1번째 물음표
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserEmailHash());
			return pstmt.executeUpdate(); //// 검색할때 query 쓰고 업데이트는 이거~~      //오류 발생
			// 회원가입 성공하면 1 이니깐 액션페이지에서 그걸 사용해서 개발
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return -1; // 회원가입 실패
	}

	public boolean getUserEmailChecked(String userID) {
		String sql = "SELECT userEmailChecked FROM USER WHERE userID =? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID); // SQL문의 물음표에 해당되는것, 즉 1번째 물음표
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getBoolean(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return false; // 데이터베이스 오류
	}

	public boolean setUserEmailChecked(String userID) { // 특정한 사용자가 이메일 검증을 통해 인증완료를 처리해주느것
		String sql = "UPDATE USER SET userEmailChecked = true where userID =? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID); // SQL문의 물음표에 해당되는것, 즉 1번째 물음표
			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return false; // 데이터베이스 오류
	}

	public String getUserEmail(String userID) { // 특정회원의 이메일 자체를 반환해 주는 함수
		String sql = "SELECT userEmail FROM USER WHERE userID =? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID); // SQL문의 물음표에 해당되는것, 즉 1번째 물음표
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return null; // 데이터베이스 오류
	}

}