package sec05.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener
public class LoginImpl implements HttpSessionListener {
	
	String user_id;
	String user_pw;
	static int total_user=0;
	
    public LoginImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public LoginImpl(String id , String pw) {
    	this.user_id = id;
    	this.user_pw = pw;
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("���ǻ���");
         ++total_user;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("��������");
    	--total_user;
    }	
}
