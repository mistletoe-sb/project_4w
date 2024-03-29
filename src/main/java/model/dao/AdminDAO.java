package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.vo.AdminVO;
import utilmanager.DBCPManager;

// 작성자 : 손영석
public class AdminDAO implements DAOInterface<AdminVO>{
	// 싱글톤 패턴 구현
	private AdminDAO() {	} 
	private static AdminDAO daoInstance = new AdminDAO();
	public static AdminDAO getDAO() {
		return daoInstance;
	}

	public int adminCheck(String userid, String userpw) {
		String sql = "select admin_pw from admin where admin_id=?";
		int result = -1; 	
		Connection conn = null;		
		PreparedStatement pstmt = null;		
		ResultSet rs = null;		
		
		try {
			conn = DBCPManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) { 
				result = 0; 
				String dbPwd = rs.getString(1); 
				
				if (dbPwd.equals(userpw)) {
					result = 1; 
				}
			}
		} catch (Exception e) {
			System.out.println("adminCheck 실패");
		}
		return result;
	}
	
	@Override
	public void insertData(AdminVO vo) {
	}

	@Override
	public void updateData(AdminVO vo) {
	}

	@Override
	public void deleteData(int num) {
	}

	@Override
	public AdminVO selectByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AdminVO> selectAllData() {
		return null;
	}
}