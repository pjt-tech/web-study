package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener{
	String user_id;
	String user_pw;
	static int total_user = 0;
	
	public LoginImpl() {
		
	}
	
	public LoginImpl(String id , String pw) {
		this.user_id = id;
		this.user_pw = pw;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("����� ����");
		++total_user;
	}
	
	
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("����� ���� ����");
		--total_user;
	}
}
