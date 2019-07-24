<%--
  Created by IntelliJ IDEA.
  User: nvha
  Date: 2/7/18
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Product Detail</title>
    <link href="css/product-detail.css" rel="stylesheet">
    <link href="js/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="css/shop-homepage.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="js/jquery/jquery.min.js"></script>
</head>
<body>
<jsp:include page="component/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <img class="col-sm-6 image-preview" src="${product.image}" alt="${product.name}" title="${product.name}">
        <div class="col-sm-6">
            <h3 class="product-title">${product.name}</h3>
            <ul class="list-unstyled">
                <li class="product-desc">Price: <span class="product-price">$${product.price}</span> only</li>
                <li> <span class="product-desc">Description</span>
                    <ul>
                        <li>${product.description}</li>
                        <li>${product_detail.cpu}</li>
                        <li>${product_detail.memory}</li>
                        <li>${product_detail.camera}</li>
                        <li>${product_detail.sound}</li>
                        <li>${product_detail.battery}</li>
                        <li>${product_detail.os}</li>
                        <li>${product_detail.display}</li>
                        <li>${product_detail.timeAvailable}</li>
                    </ul>
                </li>
                <br>
            </ul>
            <div>
                <form action="shopping-cart" method="post">
                    <button type="submit" class="btn btn-outline-primary">
                        <span class="fa fa-briefcase"></span> Add To Cart
                    </button>
                    <input type="hidden" name="productId" value="${product.id}"/>
                </form>
            </div>
        </div>
    </div>

</div>
<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>
