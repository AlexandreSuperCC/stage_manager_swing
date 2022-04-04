package com.ycaocc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ycaocc.model.Stage;
import com.ycaocc.model.User;
import com.ycaocc.util.StringUtil;

public class StageDao {
	public static ResultSet list(Connection con, Stage stage) throws Exception{

		StringBuffer sb = new StringBuffer("select * from stage_2021");
		if(StringUtil.isNotEmpty(stage.getEntreprise())) {
			sb.append(" and entreprise like '%"+stage.getEntreprise()+"%'");
		}
		if(StringUtil.isNotEmpty(stage.getEmploi())) {
			sb.append(" and emploi like '%"+stage.getEmploi()+"%'");
		}
		if(stage.getVille()!="please select..." && StringUtil.isNotEmpty(stage.getVille())) {
			sb.append(" and ville like '%"+stage.getVille()+"%'");
		}
		sb.append(" order by id");
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public static ResultSet getVille(Connection con) throws Exception{
		String strSql = "select distinct ville from stage_2021";
		PreparedStatement pstmt = con.prepareStatement(strSql);
		
		return pstmt.executeQuery();

	}
	
	public static int update(Connection con, Stage stage)throws Exception{
		String strSql = "update stage_2021 set date=str_to_date(?,'%Y-%m-%d'),status=? where id=?;";
		PreparedStatement pstmt = con.prepareStatement(strSql);
		pstmt.setString(1, stage.getDate());
		pstmt.setString(2, stage.getStatus());
		pstmt.setInt(3, stage.getId());
		
		return pstmt.executeUpdate();
	}
	
	public static int delete(Connection con, String id)throws Exception{
		String strSql = "delete from stage_2021 where id=?;";
		PreparedStatement pstmt = con.prepareStatement(strSql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
				
	}
	
	public static int add(Connection con, Stage stage)throws Exception{
		String strSql = "insert into stage_2021 values(null,?,?,?,?,?,sysdate(),?,'sent');";
		PreparedStatement pstmt = con.prepareStatement(strSql);
		pstmt.setString(1, stage.getEntreprise());
		pstmt.setString(2, stage.getEmploi());
		pstmt.setString(3, stage.getCompetence());
		pstmt.setString(4, stage.getInformation());
		pstmt.setString(5, stage.getVille());
		pstmt.setString(6, stage.getLien());
		return pstmt.executeUpdate();
	}
	
}
