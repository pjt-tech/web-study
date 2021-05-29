package sec04.ex03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection conn;
	private DataSource dataFactory;
	private PreparedStatement pstmt;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMember() {
		
		List<MemberVO> list = null;
		
		try {			
			conn = dataFactory.getConnection();
			String query = "select * from t_member";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joinDate"));
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;	
	}
	
	public void addMember(MemberVO vo) {
		try {
			String query = "insert into t_member(id,pwd,name,email) values(?,?,?,?)";
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(MemberVO vo) {
		try {
			String query = "delete from t_member where id = ?";
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
