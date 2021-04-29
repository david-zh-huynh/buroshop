<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="css/style.css"%></style>
</head>
<body>


 <div class="login">
  <div class="heading">
    <h2>Anmelden</h2>
    <form method="post" action="LoginServlet" >

      <div class="input-group input-group-lg">
        <span class="input-group-addon"><i class="fa fa-user"></i></span>
        <input type="text" name="Benutzername" class="form-control" placeholder="Benutzername">
          </div>

        <div class="input-group input-group-lg">
          <span class="input-group-addon"><i class="fa fa-lock"></i></span>
          <input type="password" name="passwort" class="form-control" placeholder="Passwort">
        </div>

        <button type="submit" class="float">Login</button>
       </form>
 		</div>
 </div>
</body>
</html>