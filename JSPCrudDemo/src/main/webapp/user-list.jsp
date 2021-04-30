
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<!-- Nav Bar Started  -->
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <form class="d-flex">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
<!-- Nav Bar ended -->
<h3>User List</h3>
	<div class="container">
	<a href="<%=request.getContextPath()%>/userform" class="btn btn-success">Create New User</a>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Country</th>	
				<th>Actions</th>		
			</tr>
		</thead>
		<tbody>
			<c:forEach var ="user"  items="${listUser }">
			<tr>
				<td><c:out value="${ user.id}"></c:out></td>
				<td><c:out value="${ user.name}"></c:out></td>
				<td><c:out value="${ user.email}"></c:out></td>
				<td><c:out value="${ user.country}"></c:out></td>
				<td>
					<a href="edituser?id=<c:out value="${user.id}"/>" class="btn btn-secondary">Edit</a>
					<a href="deleteuser?id=<c:out value="${user.id}"/>" class="btn btn-danger">Delete</a>
				</td>
				
			</tr>
			</c:forEach>
		
		</tbody>
	
	</table>
	</div>

</body>
</html>