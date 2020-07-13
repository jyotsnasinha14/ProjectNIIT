<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <security:authorize access="hasRole('ROLE_ADMIN')">
 <jsp:forward page="/admin/Home"></jsp:forward>
 </security:authorize> 
 
 <security:authorize access="hasRole('ROLE_USER')">
 <jsp:forward page="/user/Home"></jsp:forward>
 </security:authorize> 
 
 
 


 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title }</title>
</head>
<body style='background-color: silver;'>
 

<div>
<h1> <center>welcome to  VitualVideoFace</center></h1>
<br>
<div class="card" style="width: 400px">
			<img class="card-img-top" src="resources/signin.jpg" 
					alt="Card image">
 


  
 </div>
</div>

</body>
</html>


