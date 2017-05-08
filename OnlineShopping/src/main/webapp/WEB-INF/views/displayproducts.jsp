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
 
 
  #button {
     position:absolute;
   top:0;
   right:0;
   }
   
    #button1 {
     position:absolute;
   top:0;
   right:60px;
   }
   
    #button2 {
     position:absolute;
   top:0;
   right:0px;
   }
   
    #button3 {
     position:absolute;
   top:0;
   right:80px;
   }
   
</style>

<script>
 window.onload=function(){
	var name = <%= request.getAttribute("visibility") %>;
	console.log(typeof name);
    console.log(name);
    if (name == null) {
	    //document.getElementById("but").style.display='block';
	    console.log("in if");
	    document.getElementById("button").style.display='block';
	    document.getElementById("button1").style.display='block';
	    document.getElementById("button2").style.display='none';
	    document.getElementById("button3").style.display='none';
        } else {
	    //document.getElementById("but").style.display='none';
	    console.log("in else");
	    document.getElementById("button").style.display='none';
	    document.getElementById("button1").style.display='none';
	    document.getElementById("button2").style.display='block';
	    document.getElementById("button3").style.display='block';
     }
 }

</script>
</head>
<body style="background-color: #EEE9BF">


	
   <c:forEach var="allProducts" items="${allProducts}">
   <div id="tableContainer-2">
  
   
   
      <img height="50" width="90" src="<c:url value="/img/${allProducts.product_img }"/>"/>
      ${allProducts.product_img }
     ${allProducts.product_name}</br>
     ${allProducts.product_description}</br>
     <form action="buy" method="post">
   <button name="yourButton" value=" ${allProducts.product_id}">BUY</button>
      </form>
     
     </div>
   </c:forEach>
   
   
  <form id="button" action="login" method="post">
     <input type="submit" value="LOGIN">
</form>

<form id="button1" action="signup" method="post">
     <input type="submit" value="SIGN UP">
</form>

 <form id="button2" method="get" action="logout">
    <button id="button" type="submit">LOGOUT</button>
</form>

<form id="button3" action="orderhistory" method="post">
   <button name="yourButton" value="">Order History</button>
   </form>

</body>
</html>