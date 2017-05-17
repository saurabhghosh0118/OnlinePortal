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
 } */
 
/* Dropdown Button */
.dropbtn {
    background-color: #4CAF50; 
    color: black;
    padding: 10px;
    font-size: 18px;
    border: none;
    cursor: pointer;
} 

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
   /*   background-color: #3e8e41;  */
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {display:block;}
</style>
<script type="text/javascript">
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
</head>
<body style="background-color: #00C5CD">
<ul>
  <li><div class="dropdown">
      <button onclick="myFunction()" class="dropbtn">Show Book</button>
      <div id="myDropdown" class="dropdown-content">
         <a href="allbooksXML">From XML File</a>
         <a href="allbooksTXT">From Text File</a>
         
  </div>
  </div></li>
  <li><div class="dropdown">
      <button onclick="myFunction()" class="dropbtn">Add Book</button>
      <div id="myDropdown" class="dropdown-content">
         <a href="#">From XML File</a>
         <a href="#">From Text File</a>
  </div>
  </div></li>
  <li><a href = "sortById">Sort Book By ID</a></li>
  <li><a href = "sortByName">Sort Book By Name</a></li>
</ul>




</br><br></br><br></br><br>
<form method="get" action="logout">
    <button id="button" type="submit">LOGOUT</button>
</form>

</body>
</html>