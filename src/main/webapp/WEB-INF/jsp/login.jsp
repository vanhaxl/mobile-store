<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>

    <link href="js/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="css/shop-homepage.css" rel="stylesheet">
    <link href="css/login_signup.css" rel="stylesheet">
    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/app/login.js"></script>
</head>

<body>
<jsp:include page="component/header.jsp"></jsp:include>
<div class="container py-5">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <span class="anchor"></span>

                    <div class="card rounded-0">
                        <div class="card-header">
                            Login Form
                        </div>
                        <div class="card-body">
                            <form class="form" id="loginForm" method="post">
                                <div class="form-group">
                                    <label for="email">Username</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" name="email"
                                           id="email" placeholder="Enter Username" required value="${username}">
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control form-control-lg rounded-0" id="password"
                                           name="password" placeholder="Enter Password" required value="${password}">
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" id="rememberme" name="rememberme" ${jspremember}>
                                    <label for="rememberme">Remember me?</label>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn form-control btn-success btn-lg">Login</button>
                                </div>
                                <hr/>
                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        Don't have an account!
                                        <a href="signup">Sign Up Here</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>
