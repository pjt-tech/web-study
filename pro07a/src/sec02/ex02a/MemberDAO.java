package sec02.ex02a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	//private Statement stmt;
	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<>();
		try {
			//connDB();
						
			conn = dataFactory.getConnection();
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
			System.out.println("오라클 드라이버 로딩 성공");
			conn = DriverManager.getConnection(url,user,pwd);
			System.out.println("connection 생성 성공");
			//stmt = conn.createStatement();
			//System.out.println("Statement 생성 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMember(MemberVO vo) {
		
		try {
			conn = dataFactory.getConnection();
			String query = "insert into t_member(id,pwd,name,email) values(?,?,?,?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4,vo.getEmail());
			pstmt.executeUpdate();
						
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMember(MemberVO vo) {
		try {
		conn = dataFactory.getConnection();
		String query = "delete from t_member where id = ?";
		System.out.println(query);
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1,vo.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
