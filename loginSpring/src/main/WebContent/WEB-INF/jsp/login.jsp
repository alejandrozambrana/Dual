<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <?xml version="1.0" encoding="UTF-8"?>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: verdana, sans-serif;			
}

h2 {
	color: black;
}
#contenedor{
	background-color: #e6f2ff;
	width: 300px;
	height: 250px;
	margin-top:100px;
	padding-top:10px;
	border-radius: 15%;
}

input[type="text"], input[type="password"]  {
  width: 250px;
  padding:7px;
  border: none;
  border-radius: 4px;
}

#enviar{
	background-color:#f2f2f2;
	font-weight: bold;
    cursor: pointer;
    padding: 5px;
    margin: 0 10px 20px 0;
    border: 1px solid #f2;
    border-radius: 8px 8px 8px 8px;
}

#enviar{
	outline: none;
}

span.campoConError {
  color: red;
}
		
</style>	
</head>
<body>
	<center>
		<div id="contenedor">
			<h2>Login</h2>
			<form:form id="login" name="login" action="load.html" method="post" commandName="login">
	
				<form:label path="login">Login:</form:label>
				<form:input path="login" />
				<form:errors path="login" cssClass="campoConError" /><br><br>

				<label>Password:</label>
				<form:input path="clave" type="password" />
				<form:errors path="clave" cssClass="campoConError" /><br></br>

				<input id="enviar" type="submit" value="Enviar" />
				
			</form:form>
		</div>
	</center>
</body>
</html>
