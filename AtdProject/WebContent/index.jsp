

<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<a href="list.jsp">LIST</a>

	<h1>Registration Form</h1>
	<hr>
	
<form action="Controller?page=register" method="post">
  <div class="form-group">
    <label for="name">Enter Name:</label>
    <input type="text" name="name" required="required" class="form-control" id="name" aria-describedby="nameHelp">
  </div>
  
  <div class="form-group">
    <label for="surname">Enter Surname:</label>
    <input type="text" name="surname" required="required" class="form-control" id="surname" aria-describedby="surnameHelp">
  </div>

  <div class="form-group">
    <label for="dob">Enter DOB</label>
    <input type="date" required="required" class="form-control" id="dob" name="dob">
   </div>
 
   <div class="form-group">
    <label for="dob">Enter DOJ</label>
    <input type="date" required="required" class="form-control" id="doj" name="doj">
   </div>
  
 <button type="submit" class="btn btn-primary">Submit</button> | <button type="reset" class="btn btn-primary">Reset</button>
</form>
</div>
</div>
</div>