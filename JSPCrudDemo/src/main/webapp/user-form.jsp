<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<h3>This is user form</h3>
	
<form class="container" action="<%=request.getContextPath()%>/newuser" method="get">
  <div class="mb-3">
  	<label for="name" class="form-label">Name</label>
    <input type="text" class="form-control" name="name" >
    <label for="email" class="form-label">Email Address</label>
    <input type="email" class="form-control" name="email" >
    <label for="country" class="form-label">Country</label>
    <input type="text" class="form-control" name="country" >
  </div>
  
  <div class="mb-3 form-check">
    <label class="form-check-label" for="exampleCheck1">Submit</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>