[#ftl]
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title> Weather - Login Form</title>
    <link rel="shortcut icon" href="resources/images/icon.jpg">
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="resources/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/plugins/font-awesome/css/font-awesome.css">
    <link id="theme-style" rel="stylesheet" href="resources/css/styles.css">
</head>

<body>
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="text-center">Login</h1>
            [#if msg??]${msg}[/#if]
            [#if error??]${error}[/#if]
            </div>
            <div class="modal-body">
                <form class="form col-md-12 center-block" id="loginForm" name="loginForm"
                      action="j_spring_security_check"
                      method="POST" autocomplete="on" onsubmit="return validateLoginForm()">
                    <div class="form-group">
                        <input id="email" name="email" type="text" class="form-control input-lg" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input id="password" name="password" type="password" class="form-control input-lg"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-lg btn-block">Sign In</button>
                        <span class="pull-right"><a href="register">Register</a></span>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<!-- script references -->
<script type="text/javascript" src="resources/plugins/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/plugins/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/plugins/jquery-rss/dist/jquery.rss.min.js"></script>
<script type="text/javascript" src="resources/js/validate.js"></script>

</body>
</html>