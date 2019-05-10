<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>邮件服务器管理后台</title>
   <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
   <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
   <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="span10">
     <div class="page-header">
         <h3 align="center">邮件服务后台登陆</h3>
     </div>
    <div class="col-md-10" align="center">
    <form class="form-horizontal" method="POST" action="login">
       <div class="form-group">
          <label for="username" class="col-sm-2 control-label">用户名</label>
          <div class="col-sm-10">
             <input type="text" class="form-control" id="username" name="username"
                placeholder="请输入用户名">
          </div>
       </div>
       <div class="form-group">
          <label for="password" class="col-sm-2 control-label">密码</label>
          <div class="col-sm-10">
             <input type="password" class="form-control" id="password" name="password"
                placeholder="请输入密码">
          </div>
       </div>

       <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
             <button type="submit" class="btn btn-default">登录</button>
          </div>
       </div>
    </form>
  </div>
  </div>
</body>
</html>