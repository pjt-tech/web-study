package sec01.brd08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	
	public List<ArticleVO> selectAllArticles(Map<String,Integer> pagingMap) {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		int section = (Integer) pagingMap.get("section");
		int pageNum = (Integer) pagingMap.get("pageNum");
		
		try {
			//connDB();
			con = dataFactory.getConnection();
			String query = "select * from ( " + "select rownum as recNum,"					
					+ "LVL," + "articleNO,"
					+ "parentNO," + "title,"
					+ "id," + "writeDate "
					+ " from (select LEVEL as LVL, "
					+ "articleNO," + "parentNO," + "title," + "id,"
					+ "writeDate" + " from t_board"
					+ " START WITH parentNO=0"
					+ " CONNECT BY PRIOR articleNO=parentNO"
					+ "  ORDER SIBLINGS BY articleNO DESC)" + ")"
					+ " where recNum between(?-1)*100+(?-1)*10+1 and (?-1)*100+?*10";
			pstmt = con.prepareStatement(query);			
			pstmt.setInt(1, section);
			pstmt.setInt(2, pageNum);
			pstmt.setInt(3, section);
			pstmt.setInt(4, pageNum);
			System.out.println(query);			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int level = rs.getInt("LVL");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				
				ArticleVO article= new ArticleVO();
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				article.setTitle(title);
				article.setId(id);
				article.setWriteDate(writeDate);				
				list.add(article);
			}
			rs.close();
			//stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArticleVO selectArticle(int articleNO) {
		ArticleVO article = new ArticleVO();		
		try {
			
			con = dataFactory.getConnection();
			String query = "select articleNO, parentNO, title, content,imageFileName, id,writeDate"
					+ " from t_board"
					+ " where articleNO=?";
					
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			System.out.println(query);			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();			
			int _articleNO = rs.getInt("articleNO");
			int parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = rs.getString("imageFileName");
			String id = rs.getString("id");
			Date writeDate = rs.getDate("writeDate");
			
			article = new ArticleVO(_articleNO,parentNO,title,content,imageFileName,id,writeDate);
			
			rs.close();
			//stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return article;
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
	
	public int insertNewArticle(ArticleVO article) {
		int articleNO = getNewArticleNo();
		try {
			con = dataFactory.getConnection();
			//int articleNO = getNewArticleNo();
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
		return articleNO;
	}
	
	public void updateArticle(ArticleVO article) {
		int articleNO = article.getArticleNO();
		String title = article.getTitle();
		String content = article.getContent();
		String imageFileName = article.getImageFileName();
		try {
			con = dataFactory.getConnection();
			String query  = "update t_board set title=?,content=?";
			if(imageFileName != null && imageFileName.length() != 0) {
				query+=",imageFileName=?";
			}else {
				query+=" where articleNO = ?";
			}
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			if(imageFileName != null && imageFileName.length() != 0) {
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, articleNO);
			}else {
				pstmt.setInt(3, articleNO);
			}
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteArticle(int articleNO) {
		
		try {
			con = dataFactory.getConnection();
			String query  = "delete from t_board";
			query+=" where articleNO in (";
			query+=" select articleNO from t_board ";
			query+=" start with articleNO = ?";
			query+=" connect by prior articleNO = parentNO)";
					
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Integer> selectRemovedArticles(int articleNO) {
		List<Integer> list = new ArrayList<Integer>();
		
		try {
			//connDB();
			con = dataFactory.getConnection();
			String query = "select articleNO From t_board "
					+ " start with articleNO = ?"
					+ " connect by prior articleNO = parentNO";
					
			pstmt = con.prepareStatement(query);			
			System.out.println(query);			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				articleNO = rs.getInt("articleNO");
				list.add(articleNO);
			}
			rs.close();
			//stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int selectTotArticles() {
		
		try {
			con = dataFactory.getConnection();		
						
			String query = "select count(articleNO) from t_board ";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) return (rs.getInt(1));			
			
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
