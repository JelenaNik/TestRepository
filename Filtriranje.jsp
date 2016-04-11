<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
<title>Insert title here</title>

</head>

<body>
<form action = "FiltriranjeServlet"  method = "POST" >
     <select name = "slika">
          <option value = "namePicture">Naziv slike </option>
          <option value = "age"> Godina izdanja slike</option>
          <option value = "direction">Pravac</option>
          <option value = "author">Autor</option>


		<c:forEach var="list" items="slika">
			<c:out value="${slika.namePicture}" /> 
			<c:out value="${slika.age}" /> 
			<c:out value="${slika.direction}"/>
			<c:out value="${slika.author}"/>
		</c:forEach>
</select> 		
<input type="submit" value = "Filtriraj"></input>



</form>
</body>

</html>