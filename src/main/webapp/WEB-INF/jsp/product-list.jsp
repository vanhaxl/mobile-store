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
    <link href="css/product-list.css" rel="stylesheet">
    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/app/product-list.js"></script>
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
            <a href="#">Product List</a>
        </li>
    </ul>

    <form id="filterForm">
        <div class="card">
            <div class="card-header filter-header">
                Search
            </div>
            <div class="card-block">
                <div class="row form-group">
                    <label class="col-sm-2 col-form-label" for="keyword">Keyword</label>
                    <div class="col-sm-10">
                        <input class="form-control" placeholder="Product name, Product description" value="${sessionScope.keyword}" type="text" name="keyword" id="keyword"/>
                    </div>
                </div>
                <div class="row form-group">
                    <label class="col-sm-2 col-form-label" for="categoryId">Category</label>
                    <div class="col-sm-10">
                        <select class="custom-select" name="categoryId" id="categoryId">
                            <option selected>Select the category</option>
                            <c:forEach items="${categories}" var="category">
                                <option <c:if test="${category.id == sessionScope.categoryId}">selected</c:if> value="${category.id}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="active">Active</label>
                    <div class="col-sm-10">
                        <div class="checkbox">
                            <input type="checkbox" name="active" data-toggle="toggle" id="active" <c:if test="${sessionScope.active == 1}">checked</c:if> >
                        </div>
                    </div>
                </div>
                <input type="submit" value="Search" id="filterBtn" class="btn btn-primary"/>
                <input type="submit" value="Clear" id="clearBtn" class="btn btn-secondary"/>
            </div>
        </div>
    </form>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col"></th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <c:url value="product-management" var="editProductUrl">
                <c:param name="productId" value="${product.id}"/>
            </c:url>
            <tr>
                <th scope="row">
                    <img src="${product.image}" class="product-image"/>
                </th>
                <td>
                    <a href="${editProductUrl}">
                            ${product.name}
                    </a>
                </td>
                <td>${product.description}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
</body>
</html>
