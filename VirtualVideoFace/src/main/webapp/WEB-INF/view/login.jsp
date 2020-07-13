<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
</head>
<body style='background-color: silver;'> 
<div class = "container">
	<div class="wrapper">
		<form action="login" method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading"> Please Sign In</h3>
			  <hr class="colorgraph"><br>
			  
			  <div class="card" style="width: 300px">
				<img class="card-img-top" src="resources/logo2.jpg"
					alt="Card image"> 
				</div> 
				<br>	
			  <div> Email: <input type="text" class="form-control" name="Email" placeholder="Email" required=""  /></div><br>
			  <div> Password: <input type="password" class="form-control" name="password" placeholder="Password" required=""/></div>  <br>   		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
		</form>
		<br>
		<br>
		 			
		
		forgot your account?<a href="forget">forgetAccount </a>
		
	</div>
</div>

</body>
</html>