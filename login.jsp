<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Bank Login Form</title>
  <link rel="stylesheet" href="css/style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<html>
<head>
<title>Bank Login Form</title>

</head>
 
<body>
<h3>BANK LOGIN</h3>
<br>
<h3>Login Authentication Failed.....Please try after sometimes</h3>
<form id="loginAction" action="registerCutomers.jsp" method="POST">
<table align="center" cellpadding = "10">
 
<!----- First Name ---------------------------------------------------------->
<tr>
<td>USER ID</td>
<td><input type="text" name="userId" maxlength="30"/>
</td>
</tr>
 
<!----- Last Name ---------------------------------------------------------->
<tr>
<td>Password</td>
<td><input type="password" name="password" maxlength="30"/>
</td>
</tr>
 
<!----- Account Type -------------------------------------------------------->
<tr>
<td>ACCOUNT TYPE</td>
 
<td>
<select name="account_type" id="account_type">
<option value="1">ADMIN</option>
<option value="2">CUSTOMER</option>
</select>
</td>
</tr>
 
<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="2" align="center">
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</td>
</tr>
</table>
 
</form>
 
</body>
</html>
<!-- partial -->
  
</body>
</html>
