package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Student;
import Services.Service;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;      

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("page");
		switch (action) {
		case "register":
			studentregisteration(request,response);
			break;
		case "edit":
			edit(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		default:
			break;
		}
		
		
	}
//update
	private void edit(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		
		Student st=new Student();	
		st.setId(Integer.parseInt(request.getParameter("id")));	
		st.setName(request.getParameter("name"));
		st.setSurname(request.getParameter("surname"));
		st.setDob(request.getParameter("dob"));
		st.setDoj(request.getParameter("doj"));
		
		boolean status=Service.update(st);
		if(status) {
			request.setAttribute("mgs", "Record is updated");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			request.setAttribute("mgs", "Record is not updated");
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
}
	///Delete
	private void delete(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {		
			int id=Integer.parseInt(request.getParameter("id"));
			boolean status=Service.delete(id);
				if(status==true)
				{	
					request.setAttribute("msg", "Delete Sucessfull..!");
					RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
					System.out.println("delete");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("msg", "Delete not Sucessfull..!");
					RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
					System.out.println("not delete");
					rd.forward(request, response);
				}
}
	
	//Registration
	private void studentregisteration(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		String dob=request.getParameter("dob");
		String doj=request.getParameter("doj");
		Student st=new Student(name,surname,dob,doj);
		boolean status=Service.saveStudent(st);
		if (status == true) {
			request.setAttribute("msg", "Registration Sucessfull..!");
			request.getRequestDispatcher("list.jsp").include(request, response);
		}
		else {
			request.setAttribute("msg", "Registration Failed..!");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
