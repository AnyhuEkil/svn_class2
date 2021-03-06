/*
 
	<참고사항>
	
	
	
	<이슈사항>
 
*/
package application.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.model.Data;
import application.util.*;

public class DbController {
	
	public DbConn con = new DbConn();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
			
	 public ResultSet  logincheck(String username,String password){		
		try {
			con.conn();	
			String sql = "SELECT * FROM login where rid = ? and rpass = ?";
			pstmt = con.con.prepareStatement(sql);	
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rs;
	}
	
	public ArrayList<Data> search(Data sch){
		ArrayList<Data> list = new ArrayList<Data>();
		
		try {
			con.conn();
			String sql = "SELECT * FROM HOUSEPRICE \n"
						+ "WHERE OVERALLQUAL LIKE '%' || ? || '%' \n"
						+ "OR OVERALLCOND LIKE '%' || ? || '%' \n"
						+ "OR SALEPRICE LIKE '%' || ? || '%' \n";
			System.out.println(sql);
			pstmt = con.con.prepareStatement(sql);
			pstmt.setInt(1, sch.getOverallQual());
			pstmt.setInt(2, sch.getOverallCond());
			pstmt.setInt(3, sch.getSalePrice());
			rs = pstmt.executeQuery();
			
			Data data = null;
			while(rs.next()){
				data = new Data();
				data.setOverallQual(rs.getInt("overallqual"));
				data.setOverallCond(rs.getInt("overallcond"));
				data.setSalePrice(rs.getInt("saleprice"));
				list.add(data);
			}
			for(Data d : list){
				System.out.println(d.getOverallQual());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(con!=null){
					con.con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		return list;
	}
	 
	public void Main(String[] args){
		Data dt01 = new Data();
		dt01.setOverallQual(5);
		DbController dbc = new DbController();
		dbc.search(dt01);
		ArrayList<Data> ddd = dbc.search(dt01); 
		for(Data d:ddd){
			System.out.println(d.getSalePrice());
		}
	}
}

 
