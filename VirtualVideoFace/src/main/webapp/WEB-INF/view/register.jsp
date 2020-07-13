<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>${title}</title></head>
<body style='background-color: silver;'> 
<div class = "container">
	<div class="wrapper">
  <spring:form action="Sucess" modelAttribute="employee" method="POST">
  <h3 class="form-signin-heading">Registration Form</h3>
    <hr class="colorgraph"><br>
    <div class="form-group">
      <label for="userName">UserName:</label>
      <spring:input  class="form-control" id="userName" placeholder="Enter Username" path="userName"/>
      </div>
 
    
    <div class="form-group">
      <label for="userEmail">Email:</label>
      <spring:input  class="form-control" id="userEmail" placeholder="Enter EmailId" path="userEmail"/>
    
    </div>
    
       <div class="form-group">
      <label for="password">Password:</label>
      <spring:input type="password"  class="form-control" id="password" placeholder="Enter password" path="password"/>
     
    </div>
    <div class="form-group">
      <label for="confrimPassword">Confirm Password:</label>
      <spring:input type="password"  class="form-control" id="confrimPassword" placeholder="Enter Confirm password" path="confrimPassword"/>
     
    </div>
    
       <div class="form-group">
      <label for="phone">Phone:</label>
      <spring:input  class="form-control" id="phone" placeholder="Enter phone number" path="phone"/>
    
    </div>
    
    
     <button class="btn btn-lg btn-primary btn-block">Register</button>  
    
  </spring:form>
  </div>
</div>
</body>
</html>





