package sec01.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	//private Statement stmt;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<>();
		try {
			connDB();
			String query = "select * from t_member";
			pstmt = conn.prepareStatement(query);
			System.out.println("query : " + query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("ID"));
				vo.setPwd(rs.getString("PWD"));
				vo.setName(rs.getString("NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setJoinDate(rs.getDate("JOINDATE"));
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			//stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	private void connDB() {
		try {
			
			Class.forName(driver);
			System.out.println("����Ŭ ����̹� �ε� ����");
			conn = DriverManager.getConnection(url,user,pwd);
			System.out.println("connection ���� ����");
			//stmt = conn.createStatement();
			//System.out.println("Statement ���� ����");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
