<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Services.Service"%>
<%@page import="java.util.*"%>
<%@page import="Entity.Student"%>
<%@page import="java.util.List"%>

<div class="container mtb">
<div class="row">
<div class="col-lg-6">

<h1>Student List</h1>
<%
	List<Student>list=Service.listUser();
	int sno=1;
%>
<c:set var="stud" value="<%=list %>"></c:set>
<hr>

<table class="table table-striped">
<thead>
<tr>
<th scope="col">Student ID</th>
<th scope="col">Name</th>
<th scope="col">Surname</th>
<th scope="col">DOB</th>
<th scope="col">DOJ</th>
<th scope="col">Update</th>
<th scope="col">Delete</th>
</tr>
</thead>
<tbody>
 
 <c:forEach var="s" items="${stud}">
 <tr>
  <th scope="row">${s.id}</th>
      <td>${s.name}</td>
      <td>${s.surname}</td>
      <td>${s.dob}</td>
      <td>${s.doj}</td>
      <th scope="row"><a href="edit.jsp?id=${s.id}">Update</a></th>
      <th scope="row"><a href="Controller?page=delete&id=${s.id}">Delete</a></th>    
  </tr>
  </c:forEach>  
  
</tbody>
</table>
</div>
</div>
</div>