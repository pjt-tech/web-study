package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam1 {

	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		
		List<Role> list = dao.getRoles();
		System.out.println(role);
		System.out.println(list);
	}	
}
