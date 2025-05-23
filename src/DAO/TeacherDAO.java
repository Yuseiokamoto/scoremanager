package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;
//a

public class TeacherDAO extends DAO {

	public Teacher teacherSearch(String id, String password) throws Exception {
		Teacher teacher=null;

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from teacher where id=? and password=? ");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			teacher=new Teacher();
			teacher.setId(rs.getString("id"));
			teacher.setPassword(rs.getString("password"));
			teacher.setName(rs.getString("name"));
		}
		st.close();
		con.close();

		return teacher;
	}
}
