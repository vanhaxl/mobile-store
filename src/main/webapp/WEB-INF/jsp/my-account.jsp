<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Mobile store</title>
    <!-- Bootstrap core CSS -->
    <link href="js/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="css/shop-homepage.css" rel="stylesheet">
    <link href="css/my-account.css" rel="stylesheet">
    <script src="js/jquery/jquery.min.js"></script>
<body>
<jsp:include page="component/header.jsp"></jsp:include>
<div class="container">
    <ul class="breadcrumb">
        <li>
            <a href="product">Home</a>
            <span class="divider">/</span>
        </li>
        <li>
            <a href="#">My Account</a>
        </li>
    </ul>

    <div class="card">
        <div class="card-header user-info-header">
            User information
        </div>
        <div class="card-block user-info">
            <div class="row">
                <div class="col-sm-2">Fullname: </div>
                <div class="col-sm-9">${user.fullname}</div>
            </div>
            <div class="row">
                <div class="col-sm-2">Email: </div>
                <div class="col-sm-9">${user.email}</div>
            </div>
            <div class="row">
                <div class="col-sm-2">Phone Number: </div>
                <div class="col-sm-9">${user.telephone}</div>
            </div>
            <div class="row">
                <div class="col-sm-2">Address: </div>
                <div class="col-sm-9">${user.address}</div>
            </div>
        </div>
    </div>

    <c:forEach items="${orders}" var="order">
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col-sm-3 col-3">
                        ORDER PLACED
                    </div>
                    <div class="col-sm-3 col-3">
                        TOTAL
                    </div>
                    <div class="col-sm-3 col-3">
                        ORDER STATUS
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3 col-3">
                        ${order.orderDate}
                    </div>
                    <div class="col-sm-3 col-3">
                        $ ${order.total}
                    </div>
                    <div class="col-sm-3 col-3">
                            ${order.status}
                    </div>
                </div>
            </div>
            <c:forEach items="${order.orderItems}" var="orderItem" varStatus="loop">
                <div class="row">
                    <div>
                        <img class="image-preview" src="${orderItem.product.image}" />
                    </div>
                    <div class="col-sm-8">
                        <div class="card-block">
                            <h4 class="card-title"><a href="product-detail?productId=${orderItem.product.id}">${orderItem.product.name}</a></h4>
                            <div class="card-text">${orderItem.product.description}</div>
                            <div class="card-text">Price: $ ${orderItem.productPrice}</div>
                            <div class="card-text">Quantity: ${orderItem.productQty}</div>
                        </div>
                    </div>
                </div>
                <c:if test="${loop.index % 2 == 0 && !loop.last}">
                    <hr/>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>
