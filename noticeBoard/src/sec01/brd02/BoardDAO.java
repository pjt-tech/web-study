package sec01.brd02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BoardDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ArticleVO> selectAllArticles() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		
		try {
			//connDB();
			con = dataFactory.getConnection();
			String query = "select LEVEL, articleNO, parentNO, title, content, id,writeDate"
					+ " from t_board"
					+ " START WITH parentNO=0"
					+ " CONNECT BY PRIOR articleNO=parentNO"
					+ " ORDER SIBLINGS BY articleNO DESC";
			pstmt = con.prepareStatement(query);			
			System.out.println(query);			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				
				ArticleVO articleVO = new ArticleVO(level,articleNO,parentNO,title,content,id,writeDate);
				list.add(articleVO);
			}
			rs.close();
			//stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private int getNewArticleNo() {
		try {
			con = dataFactory.getConnection();
			String query = "select max(articleNO) from t_board";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return (rs.getInt(1) + 1);				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void insertNewArticle(ArticleVO article) {
		try {
			con = dataFactory.getConnection();
			int articleNO = getNewArticleNo();
			int parentNO = article.getParentNO();
			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();
			String imageFileName = article.getImageFileName();
			
			String query = "insert into t_board";
					query+=" (articleno,parentno,title,content,imagefilename,id)";
					query+=" values(?,?,?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
