<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">


  html, body {
    height: 100%;
  }
  #tableContainer-1 {
    height: 100%;
    width: 100%;
    display: table;
  }
  #tableContainer-2 {
    vertical-align: middle;
    display: table-cell;
    height: 100%;
  }
  #myTable {
    margin: 0 auto;
  }

</style>
</head>
<body>
<div id="tableContainer-1">
  	  <div id="tableContainer-2">
		<form method="post" action="registeruser">
            <center>
            <table id="myTable" border="1" width="30%" cellpadding="3" style="background-color: #8B8989;">
                <thead>
                    <tr>
                        <th colspan="2">Register</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="user_name" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="user_password" value="" /></td>
                    </tr>
                    <tr>
                        
                       
                        <td><input type="submit" value="Sign Up" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><marquee>Only For Admin</marquee></td>
                    </tr>
                </tbody>
            </table>
            </center>
         </form>
        </div> 
     </div>
     
     <form id="button" action="login" method="post">
     <input type="submit" value="LOGIN">
</form>

<form action="orderhistory" method="post">
   <button name="yourButton" value="">Order History</button>
   </form>
</body>
</html>