<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Connection.DAO"%>
<%@page import="java.sql.*"%>
<%@page import="Entity.Student"%>
<%@page import="Services.Service" %>
<div class="container mtb">
<div class="row">
<div class="col-lg-6">
	<h1>Edit</h1>
	<hr>
<% 
int id=Integer.parseInt(request.getParameter("id"));
String sql="select * from student where id=?";

try{
	Connection con=DAO.getcon();
	PreparedStatement pst=con.prepareStatement(sql);
	ResultSet rs=null;
	pst.setInt(1, id);
	rs=pst.executeQuery();
	if(rs.next()){

%>
<form action="Controller?page=edit" method="post">
<div class="form-group">
	<label for="id">ID:</label>
	<input type="text" name="id" id="id" readonly="readonly" class="form-control"  value="<%=rs.getInt("id")%>">
</div>
   <div class="form-group">
    <label for="name">Name:</label>
    <input type="text" name="name" required="required" class="form-control" id="name"  value="<%=rs.getString("name")%>">
  </div>
   
  <div class="form-group">
    <label for="surname">Surname:</label>
    <input type="text" name="surname" required="required" class="form-control" id="surname"  value="<%=rs.getString("surname")%>">
  </div>

  <div class="form-group">
    <label for="dob">Date Of Birth</label>
    <input type="date" required="required" class="form-control" id="dob" name="dob" value="<%=rs.getString("dob")%>">
   </div>
 
   <div class="form-group">
    <label for="dob">Date Of Joining </label>
    <input type="date" required="required" class="form-control" id="doj" name="doj" value="<%=rs.getString("doj")%>">
   </div>
  
 <button type="submit" class="btn btn-primary">Update</button>
</form>
<% 
}						
		}catch(Exception e){
			System.out.println(e);
		}%>
</div>
</div>
</div>