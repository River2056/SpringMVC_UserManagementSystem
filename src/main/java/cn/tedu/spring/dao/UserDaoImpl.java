package cn.tedu.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Repository;

import cn.tedu.spring.utils.DBUtils;
import cn.tedu.spring.bean.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	@Resource(name="dataSource")
	private BasicDataSource dataSource;
	
	public Integer insert(User user) {
		// 1. �n�����n�ܶq
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO t_user "
				+ "(username, password, phone, email) "
				+ "VALUES "
				+ "(?, ?, ?, ?)"; 
		Integer id = -1;
		
		try {
			// 2. ����s��
			conn = dataSource.getConnection();
			// 3. �w�sĶSQL
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getEmail());
			// 4. ����SQL, �p�G�i�H�����^��, �h���
			pstmt.executeUpdate();
			// 5. �B�z���G, �q�`�O�]�����檺�Oselect��insert, �N�o��ResultSet
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. TODO ����귽
			DBUtils.close(rs, pstmt, conn);
		}
		
		// 7. ��^
		return id;
		
	}

	public User findUserByUsername(String username) {
		// preparation materials
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT "
				+ "id, username, password, phone, email "
				+ "FROM t_user "
				+ "WHERE username = ?";
		User user = null;
		
		try {
			// get connection and execute query
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			// check if null
			if(rs.next()) {
				// user found
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		
		return user;
	}

}
