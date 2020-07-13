<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
</head>
<body>

<div class="container">
<div class="wrapper">
  <center><h3 class="form-signin-heading">UserList</h3></center>
            <hr class="colorgraph">  
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Emailid</th>
        
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${userList}" var="employee">
      <tr>
        <td>${employee.userName}</td>
        <td>${employee.userEmail}</td>
        <td><a href="">Request to chat</a></td>
        <td><a href="">Send Invitation to Join the Videochat</a></td>
        </tr>
      </c:forEach>
      </table>
      </div>
      </div>

</body>
</html>