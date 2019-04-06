<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/register.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    <title>Spring MVC User Management</title>
</head>
<body>
    <form action="handleLogin.do" method="POST">
        <div class="input_form">
            <div class="form_title">
                <h3>用戶登入</h3>
            </div>
            
            <div class="username">
                <p>用戶名: </p>
                <input type="text" name="username" />
            </div>
            
            <div class="password">
                <p>密碼: </p>
                <input type="password" name="password" />
            </div>

            <div class="submit_btn">
                <input type="submit" value="登入" />
            </div>
            
            <div class="link">
                <p>還沒註冊嗎? <a href="register.do">前往註冊</a></p>
            </div>
        </div>
    </form>
</body>
</html>