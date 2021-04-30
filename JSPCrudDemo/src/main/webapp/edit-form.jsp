
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<body>
<form action="updateuser" method="get" class="container">
		<br />
		<h2>Edit Existing User</h2>
		<br />
			<div class="form-group">
				<label for="name">User Name</label>
				<input type="text" class="form-control" name="name" value='<c:out value="${user.name }"></c:out>'/>
				
			</div>
			<div class="form-group">
				<label for="name">User Email</label>
				<input type="text" class="form-control" email="email" value='<c:out value="${user.email }"></c:out>'/>
				
			</div>
			<div class="form-group">
				<label for="name">User Country</label>
				<input type="text" class="form-control" country="country" value='<c:out value="${user.country }"></c:out>'/>
				
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>