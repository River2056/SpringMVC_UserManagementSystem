<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/error.css" />
    <title>Login Error</title>
</head>
<body>
    <h3>操作錯誤</h3>
    <p>${errorMessage }</p>
    <div class="bgimg"></div>
    <div class="link">
    	<p><a href="login.do">返回登入</a></p>
    </div>
</body>
</html>