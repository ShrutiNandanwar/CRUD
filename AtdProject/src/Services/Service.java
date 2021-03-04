package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.DAO;
import Entity.Student;

public class Service {
	
	static Connection con =null;
	static PreparedStatement pst=null;
	static Statement st=null;
	static ResultSet rs=null;
	
//save
	public static boolean saveStudent(Student st) {
		String sql="insert into student(name,surname,dob,doj)value(?,?,?,?)";		
		try {
			con=DAO.getcon();
			pst=con.prepareStatement(sql);
			pst.setString(1, st.getName());
			pst.setString(2, st.getSurname());
			pst.setString(3, st.getDob());
			pst.setString(4, st.getDoj());			
			int result = pst.executeUpdate();
			if(result==1)
			{
				return true;
			}
			else {
				return false;
			}			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return true;
	}	
	
//edit.jsp list	
	public static Student getUser(int id) {
		String sql="select * from student";
		Student u=new Student();
		try {
			con=DAO.getcon();
			pst=con.prepareStatement(sql);
	
			rs=pst.executeQuery();
			if (rs.next()) {
				u.setId(id);
				u.setName(rs.getString("name"));
				u.setName(rs.getString("surname"));
				u.setDob(rs.getString("dob"));
				u.setDoj(rs.getString("doj"));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}
//update
	public static boolean update(Student st) {
		{
			String sql="update student set name=?,surname=?,dob=?,doj=? where id=?";
			try {
			
				con=DAO.getcon();
				pst=con.prepareStatement(sql);
				pst.setInt(1, st.getId());
				pst.setString(2, st.getName());
				pst.setString(3, st.getSurname());
				pst.setString(4, st.getDob());
				pst.setString(5, st.getDoj());
				
				int result=pst.executeUpdate();
				if (result==1) {
					System.out.println("Record Updated Sucessfully!");
				}
				else {
					System.out.println("Record Update Failed!");
				}
				con.close();
				} 
				catch (Exception e) {
				System.out.println(e);
				}
				return false;
			} 
	}
	//delete
	public static boolean delete(int id) {
			String sql="delete from student where id=?";
			try {
				con=DAO.getcon();
				pst=con.prepareStatement(sql);
				pst.setInt(1, id);
				int result=pst.executeUpdate();
				if(result==1)
				{
					System.out.println("item deleted");
					return true;
				}
				else {
					return false;
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return false;
	}	
	
	//list
		public static List<Student> listUser() {
			String sql="select * from student";
			 List<Student> list=new ArrayList<Student>();
			 try {
				con=DAO.getcon();
				pst=con.prepareStatement(sql);
				rs=pst.executeQuery();
				
				while(rs.next()) {
					Student stud = new Student();
					stud.setId(rs.getInt("id"));
					stud.setName(rs.getString("name"));
					stud.setSurname(rs.getString("surname"));
					stud.setDob(rs.getString("dob"));
					stud.setDoj(rs.getString("doj"));
					
					list.add(stud);
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			 finally{
			 try {
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			 }
			return list;
		}
	
}
