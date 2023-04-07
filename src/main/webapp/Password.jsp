<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - change password form</title>
  <link rel="stylesheet" href="./css/password.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="mainDiv">
  <div class="cardStyle">
    <form action="svlPassword" method="post" name="signupForm" id="signupForm">
      
      <img src="https://cdn-icons-png.flaticon.com/512/223/223122.png" id="signupLogo"/>
      
      <h2 class="formTitle">
        CAMBIA TU CONTRASEÑA
      </h2>
      
    <div class="inputDiv">
      <label class="inputLabel" for="email">Enter E-mail</label>
      <input type="email" id="email" name="email" required>
    </div>  
      
    <div class="inputDiv">
      <label class="inputLabel" for="passwordActual">Enter Password</label>
      <input type="password" id="passwordActual" name="passwordActual" required>
    </div>
      
    <div class="inputDiv">
      <label class="inputLabel" for="newPass">New Password</label>
      <input type="password" id="newPass" name="newPass">
    </div>
    
  <div class="buttonWrapper">
    <button type="submit" id="submitButton" class="submitButton pure-button pure-button-primary">
      <span>Regresa al inicio</span>
    </button>
  </div>
      
  </form>
  </div>
</div>
<!-- partial -->
  <script  src="./js/main_rl.js"></script>

</body>
</html>
