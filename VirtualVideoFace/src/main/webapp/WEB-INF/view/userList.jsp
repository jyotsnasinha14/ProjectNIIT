<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
</head>
<body>


<div class="container">
<div class="wrapper">
 <center><h3 class="form-signin-heading">Welcome to AdminUserList</h3></center>
<hr class="colorgraph"><br>            
  <table class="table table-hover">
    <thead>
      <tr>
          <th>UserId</th>
        <th>Name</th>
        <th>Emailid</th>
        <th>Update</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
   
      <c:forEach items="${userList}" var="employee">
      <tr>
      <td>${employee.userId}</td>
        <td>${employee.userName}</td>
        <td>${employee.userEmail}</td>
        <td><a href="<c:url value='/update/${employee.userId}'/>">Update</a></td>
        <td><a href="<c:url value='/Delete/${employee.userId}'/>">Delete</a></td>
        
      </tr>
      </c:forEach>
      </table>
      </div>
      </div>

</body>
</html>