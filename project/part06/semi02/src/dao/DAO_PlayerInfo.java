package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.PlayerInfo;

public class DAO_PlayerInfo {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void regPlayer(PlayerInfo ins){
		String sql = "INSERT INTO PLAYER_INFO VALUES(?,?,?,?,?,0,0,0,0,10000,0,0,0)";
		// pid, pass, pname, email, tel, mchoice, totbet, totbenefit, totlose, curmoney, first, second, third
		try {
			con = AA_Con.conn();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ins.getPid());
			pstmt.setString(2, ins.getPass());
			pstmt.setString(3, ins.getPname());
			pstmt.setString(4, ins.getEmail());
			pstmt.setString(5, ins.getTel());
			pstmt.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	// pid, pname, pass, email, tel, mchoice totbet, totbenefit, totlose, curmoney, first, second, third
	public void updatePlayer(PlayerInfo upt){
		
		String sql = "UPDATE PLAYER_INFO SET\n"
				+ "PASS = ? \n"
				+ "PNAME = ? \n"
				+ "EMAIL = ? \n"
				+ "TEL = ? \n";
		try {
			con = AA_Con.conn();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upt.getPass());
			pstmt.setString(2, upt.getPname());
			pstmt.setString(3, upt.getEmail());
			pstmt.setString(4, upt.getTel());
			pstmt.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<PlayerInfo> searchPlayer(PlayerInfo sch){
		ArrayList<PlayerInfo> plist = new ArrayList<PlayerInfo>();
		String sql = "SELECT * FROM PLAYER_INFO \n"
				+ "WHERE PID LIKE '%'||?||'%' \n"
/*				+ "AND PNAME LIKE '%'||?||'%' \n"
				+ "AND CURMONEY = ? \n"*/
				+ "ORDER BY CURMONEY DESC";
		PlayerInfo pi = null;
		
		try {
			con = AA_Con.conn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getPid());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				pi = new PlayerInfo();
				pi.setPid(rs.getString("pid"));
				pi.setPass(rs.getString("pass"));
				pi.setPname(rs.getString("pname"));
				pi.setEmail(rs.getString("email"));
				pi.setTel(rs.getString("tel"));
				pi.setMchoice(rs.getInt("mchoice"));
				pi.setTotbet(rs.getDouble("totbet"));
				pi.setTotbenefit(rs.getDouble("totbenefit"));
				pi.setTotlose(rs.getDouble("totlose"));
				pi.setCurmoney(rs.getDouble("curmoney"));
				pi.setFirst(rs.getInt("first"));
				pi.setSecond(rs.getInt("second"));
				pi.setThird(rs.getInt("third"));
				plist.add(pi);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return plist;
	}
	
	public void delPlayer(PlayerInfo del){
		String sql = "DELETE FROM PLAYER_INFO WHERE PID = ?";
		
		try {
			con = AA_Con.conn();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, del.getPid());
			pstmt.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public PlayerInfo loginPlayer(PlayerInfo login){
		PlayerInfo pi = null;
		String sql = "SELECT * FROM PLAYER_INFO WHERE PID = ? AND PASS = ?";
		try {
			con = AA_Con.conn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getPid());
			pstmt.setString(2, login.getPass());
			rs = pstmt.executeQuery();
			if(rs.next()){
				pi = new PlayerInfo();
				pi.setPid(rs.getString("pid"));
				pi.setPass(rs.getString("pass"));
				pi.setPname(rs.getString("pname"));
				pi.setEmail(rs.getString("email"));
				pi.setTel(rs.getString("tel"));
				pi.setMchoice(rs.getInt("mchoice"));
				pi.setTotbet(rs.getDouble("totbet"));
				pi.setTotbenefit(rs.getDouble("totbenefit"));
				pi.setTotlose(rs.getDouble("totlose"));
				pi.setCurmoney(rs.getDouble("curmoney"));
				pi.setFirst(rs.getInt("first"));
				pi.setSecond(rs.getInt("second"));
				pi.setThird(rs.getInt("third"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pi;
	}
	
	/*public static void main(String[] args) {
		
		DAO_PlayerInfo dao = new DAO_PlayerInfo();
		PlayerInfo pp = new PlayerInfo();
		pp.setPid("");
		System.out.println("id\tpass\tname\temail\ttel\tmcho\tbet\tbenefit\tlose\tmoney\tfirst\tsecond\tthird");
		for(PlayerInfo c:dao.searchPlayer(pp)){
			System.out.print(c.getPid()+"\t");
			System.out.print(c.getPass()+"\t");
			System.out.print(c.getPname()+"\t");
			System.out.print(c.getEmail()+"\t");
			System.out.print(c.getTel()+"\t");
			System.out.print(c.getMchoice()+"\t");
			System.out.print(c.getTotbet()+"\t");
			System.out.print(c.getTotbenefit()+"\t");
			System.out.print(c.getTotlose()+"\t");
			System.out.print(c.getCurmoney()+"\t");
			System.out.print(c.getFirst()+"\t");
			System.out.print(c.getSecond()+"\t");
			System.out.println(c.getThird());
		}
						pi = new PlayerInfo();
				pi.setPid(rs.getString("pid"));
//				pi.setPass(rs.getString("P"));
				pi.setPname(rs.getString("pname"));
//				pi.setEmail(rs.getString("email"));
//				pi.setTel(rs.getString("tel"));
				pi.setMchoice(rs.getInt("mchoice"));
				pi.setTotbet(rs.getDouble("totbet"));
				pi.setTotbenefit(rs.getDouble("totbenefit"));
				pi.setTotlose(rs.getDouble("totlose"));
				pi.setCurmoney(rs.getDouble("curmoney"));
				pi.setFirst(rs.getInt("first"));
				pi.setSecond(rs.getInt("second"));
				pi.setThird(rs.getInt("third"));
	}*/
}
