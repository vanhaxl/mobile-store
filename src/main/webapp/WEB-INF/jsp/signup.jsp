<%--
  Created by IntelliJ IDEA.
  User: nvha
  Date: 2/5/18
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Sign Up</title>

    <link href="js/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="css/shop-homepage.css" rel="stylesheet">
    <link href="css/login_signup.css" rel="stylesheet">
    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/app/signup.js"></script>
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
                            Sign Up Form
                        </div>
                        <div class="card-body">
                            <form class="form" method="post" id="signupForm">
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" name="email"
                                           id="email" placeholder="email address"
                                           pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control form-control-lg rounded-0" id="password"
                                           name="password" placeholder="password" required pattern=".{6,}">
                                </div>
                                <div class="form-group">
                                    <label for="fullname">Full Name</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" id="fullname"
                                           name="fullname" placeholder="full name" required>
                                </div>
                                <div class="form-group">
                                    <label for="telephone">Telephone</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" id="telephone"
                                           name="telephone" placeholder="telephone" required pattern="\d{9,11}">
                                </div>
                                <div class="form-group">
                                    <label for="address">Address</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" id="address"
                                           name="address" placeholder="address" required>
                                </div>
                                <div class="form-group">
                                    <input type="submit" class="btn form-control btn-success btn-lg" value="Sign Up" >
                                </div>
                                <hr/>
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