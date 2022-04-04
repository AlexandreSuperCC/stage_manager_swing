package com.ycaocc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/stage";
	private String dbUsername = "root";
	private String dbPassword= "0423";
	private String jdbcName = "com.mysql.cj.jdbc.Driver";
	
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		return con;
	}
	
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("connecting to database succeeds");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("connecting to database fails");
		}
	}
}
