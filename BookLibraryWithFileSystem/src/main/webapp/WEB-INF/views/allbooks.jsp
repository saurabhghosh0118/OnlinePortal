<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <!--   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

#button {
     line-height: 12px;
     padding:5px;
     width: 100px;
     font-size: 8pt;
     font-family: tahoma;
     margin-top: 1px;
     margin-right: 0px;
     position:absolute;
     top:0;
     right:0;
 }
 
 #menu {
     line-height: 12px;
     padding:5px;
     width: 100px;
     font-size: 8pt;
     font-family: tahoma;
     margin-top: 1px;
     margin-right: 120px;
     position:absolute;
     top:0;
     right:0;
 }
 
 #row{
 	background-color: #C1C1C1;
 }
</style>
</head>
<body style="background-color: #EEE9BF">
<table border="1">
	<tr style="background-color: #BDFCC9">
			<th width="120">Book ID</th>
			<th width="120">Book Title</th>
			<th width="120">Author Name</th>
			<th width="60">EDIT</th>
			<th width="60">DELETE</th>
		</tr>
   <c:forEach var="book" items="${allBooks}">
   <tr>
   
      <td id="row">${book.book_id}</td>
      <td id="row">${book.name}</td>
      <td id="row">${book.author}</td>
      <td style="background-color: #5CACEE"><a href="edit/${book.book_id}">edit</a></td>
	  <td style="background-color: #F08080"><a href="delete/${book.book_id}">delete</a></td>
      </tr>
   </c:forEach>
  </table>

	<form method="get" action="logout">
    	<button id="button" type="submit">LOGOUT</button>
    </form>
    
    <form method="get" action="afterlogin">
    	<button id="menu" type="submit">MENU</button>
    </form>

</body>
</html>