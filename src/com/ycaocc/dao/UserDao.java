package com.ycaocc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ycaocc.model.User;

public class UserDao {
	public User login(Connection con, User user)throws Exception{
		User resultUser = null;
		String strSql = "select * from user where username=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(strSql);
		
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
	}
}
