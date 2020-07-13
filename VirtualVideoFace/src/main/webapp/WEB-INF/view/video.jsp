<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<body style='background-color: silver;'>

<div class = "container">
<div class="wrapper">
<spring:form action="srch" modelAttribute="employee" method="POST">
<h3 class="form-signin-heading">Make video call here</h3>
<hr class="colorgraph"><br>
     <div class="form-group">
      <label for="userName">UserName:</label>
      <spring:input type="text" class="form-control" id="userName" placeholder="Enter Username" path="userName"/>
      </div>
 
    
    <button type="submit" class="btn btn-primary">Search Users for video call</button>
     </spring:form>
</div>
</div>
</body>
</html>