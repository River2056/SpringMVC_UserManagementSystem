<%-- http://SERVER:PORT/PROJECT/register.do --%>
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	    <link rel="stylesheet" type="text/css" href="css/common.css">
	    <link rel="stylesheet" type="text/css" href="css/register.css"/>
	    <title>Spring MVC User Management</title>
	</head>
	<body>
	    <form action="handleRegister.do" method="POST">
	        <div class="input_form">
	            <div class="form_title">
	                <h3>用戶註冊</h3>
	            </div>
	            <div class="username">
	                <p>用戶名: </p>
	                <input type="text" name="username"/>
	            </div>
	            <div class="password">
	                <p>密碼: </p>
	                <input type="password" name="password"/>
	            </div>
	            <div class="phone">
	                <p>電話: </p>
	                <input type="number" name="phone"/>
	            </div>
	            <div class="email">
	                <p>電子信箱: </p>
	                <input type="text" name="email"/>
	            </div>
	            <div class="submit_btn">
	                <input type="submit" value="提交"/>
	            </div>
	        </div>
	    </form>
	</body>
</html>