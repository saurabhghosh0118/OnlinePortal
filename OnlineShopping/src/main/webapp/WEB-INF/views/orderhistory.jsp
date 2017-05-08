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

 html, body {
    height: 100%;
  }
  
  #tableContainer-2 {
    
  
    border:2px solid black;
    margin: 50px;
    padding: 10px;
    width: 120px;
    height: 130px;
    border-radius: 10px;
     display: inline-block;
     text-align: justify;
  }
 #row{
 	background-color: #C1C1C1;
 }
 
  #button2 {
     position:absolute;
   top:0;
   right:0px;
   }
</style>
</head>
<body style="background-color: #EEE9BF">


	
   <c:forEach var="allProducts" items="${allProducts}">
   <div id="tableContainer-2">
  
   
   
      <img height="50" width="90" src="<c:url value="/img/${allProducts.product_img }"/>"/>
      ${allProducts.product_img }
     ${allProducts.product_name}</br>
     ${allProducts.product_description}</br>
     
     
     </div>
   </c:forEach>
  
<form action="homepage" method="post">
   <button name="yourButton" value="">Continue Shopping>></button>
      </form>
      
      <form id="button2" method="get" action="logout">
    <button id="button" type="submit">LOGOUT</button>
</form>
</body>
</html>