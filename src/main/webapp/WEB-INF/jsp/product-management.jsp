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
    <link href="css/product-management.css" rel="stylesheet">
    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/app/product-management.js"></script>
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<body>
    <jsp:include page="component/header.jsp"></jsp:include>
    <div class="container">
        <ul class="breadcrumb">
            <li>
                <a href="product">Home</a>
                <span class="divider">/</span>
            </li>
            <li>
                <a href="#">Product Management</a>
            </li>
        </ul>
        <form id="productForm" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${product.id}" />
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="name">Product name</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="name" id="name" value="${product.name}" required/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="description">Product description</label>
                <div class="col-sm-10">
                    <textarea class="form-control" cols="20" rows="10" name="description" id="description" required>${product.description}</textarea>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="price">Price</label>
                <div class="col-sm-10">
                    <input class="form-control" type="number" name="price" value="${product.price}" id="price" required/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="categoryId">Category</label>
                <div class="col-sm-10">
                    <select class="custom-select" name="categoryId" id="categoryId" required>
                        <option selected>Select the category</option>
                        <c:forEach items="${categories}" var="category">
                        <option <c:if test="${category.id == product.categoryId}">selected</c:if> value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="active">Active</label>
                <div class="col-sm-10">
                    <div class="checkbox">
                        <input type="checkbox" name="active" data-toggle="toggle" id="active" <c:if test="${product.active == 1}">checked</c:if> >
                    </div>
                </div>
            </div>
            <c:if test="${product.id != null && product.image != null}" var="isImageAvailable"></c:if>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Image</label>
                <div class="col-sm-10">
                    <input type="file" name="data" class="form-control-file" id="photo" <c:if test="${!isImageAvailable}">required</c:if> >
                </div>
            </div>
            <c:if test="${isImageAvailable}">
                <div class="form-group row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10">
                        <img src="${product.image}" class="image-preview">
                    </div>
                </div>
            </c:if>
            <input type="submit" id="saveProductBtn" class="btn btn-primary"/>
        </form>
    </div>
    <jsp:include page="component/footer.jsp"></jsp:include>
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
</body>
</html>
