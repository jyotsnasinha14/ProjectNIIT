<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
</head>
<body style='background-color: silver;'>
<div class = "container">
	<div class="wrapper">
	<c:url var="edit" value="/edit"></c:url>
<spring:form action="${ edit}" modelAttribute="employee" method="POST">
<h3 class="form-signin-heading">Update Profile</h3>
<hr class="colorgraph"><br>
    <div class="form-group">
      <label for="userId">UserId:</label>
      <spring:input type="text" class="form-control" id="userId" placeholder="Enter Username" path="userId"/>
    </div>
    
    <div class="form-group">
      <label for="userName">UserName:</label>
      <spring:input type="text" class="form-control" id="userName" placeholder="Enter Username" path="userName"/>
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <spring:input type="password" class="form-control" id="password" placeholder="Enter password" path="password"/>
    </div>
    <div class="form-group">
      <label for="confrimPassword">Confirm Password:</label>
      <spring:input type="password"  class="form-control" id="confrimPassword" placeholder="Enter Confirm password" path="confrimPassword"/>
     
    </div>
    
     <div class="form-group">
      <label for="userEmail">EmailId:</label>
      <spring:input type="userEmail" class="form-control" id="userEmail" placeholder="Enter EmailId" path="userEmail"/>
    </div>
    
    
    <button type="submit" class="btn btn-primary">Update Profile</button>
  </spring:form><br>
  Delete Your Account Permanently from below Link<a class="nav-link" href="tok">Delete Account Permanently</a>
</div>
</div>
</body>
</html>