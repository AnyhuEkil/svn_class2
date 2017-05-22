package testt_Project;
import java.sql.*;

public class jdbc_test {
	
	public static void main(String[] args){
		/*
		 * 1. ����̹� �ε�
		 * 2. �����ͺ��̽� ����
		 * 3. sql�� ������ ���� ������ ����
		 * 4. DB�� sql�� ����
		 * 5. data�� �����ͼ� ���
		 * 6. DB�� ����� �ڿ��� �ݳ�
		 * */
		
		// 1. ����̹� �ε�
		// Class.forName("Ŭ���� �̸�");		=> ���� �ε�. �������ε� method
		// 										(���α׷� ����� ����̹� �ε�)
		// java.lang ��Ű���� �����ִ� Ŭ�����̴�.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Find!");

		// 2. DB�� ����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";
			Connection con = DriverManager.getConnection(url,user,pw);
			System.out.println("Sucess!");
		
		// 3. ������(statement ��ü�� �����ؾ���)
			String sql = "select ename from emp";
			Statement st = con.createStatement();
		
		// 4. DB�� sql�� ����
			ResultSet rs = st.executeQuery(sql);
		
		// 5. data�� �����ͼ� ���
			while(rs.next()){
				String col1 = rs.getString(1);
				System.out.println(col1);
			}
			
		// 6. DB�� ����� �ڿ� �ݳ� (�ݳ��� �ؾ��Ѵܴ�..)
			if(con!=null) con.close();
			if(st!=null) st.close();
			if(rs!=null) rs.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
