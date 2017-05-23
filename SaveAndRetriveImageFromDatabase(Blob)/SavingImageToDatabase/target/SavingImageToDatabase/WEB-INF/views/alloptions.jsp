<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
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
 

</style>
</head>
<body style="background-color: #00C5CD">
<ul>
  <li><a href = "allbooks">Show Books</a></li>
   <li><a href = "addstudents">Add Students</a></li>
</ul>

<div align="center">
        <h1>Spring MVC - Hibernate File Upload to Database Demo</h1>
        <form method="post" action="addstudents" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Pick file #1:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                </tr>
            </table>
        </form>
    </div>

</br><br></br><br></br><br>
<form method="get" action="logout">
    <button id="button" type="submit">LOGOUT</button>
</form>

</body>
</html>