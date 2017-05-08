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
   .ImageHolder{
text-align:center;
}

.Image{
display:inline-block;
}
  
  .user
  {
  top:0;
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
<body>



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

 
<div class="Image">

<h1 class="user">${username}</h1>
    <a href="his">
    <img height="800" width="643" src="<c:url value="/img/44.jpg"/>"/>
</div>



<div class="Image">
<h2>${message}</h2>
    <a href="her">
    <img height="800" width="600" src="<c:url value="/img/70.jpg"/>"/>
</div>
</body>
</html>