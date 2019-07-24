<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="product">Mobile Store</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

                <c:if test="${user != null}">
                    <li class="nav-item" id="liMyAccount">
                        <a class="nav-link welcome">Hello, ${user.getFullname()}</a>
                    </li>
                </c:if>

                <li class="nav-item active product">
                    <a class="nav-link" href="product">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <c:if test="${user != null}">
                    <li class="nav-item myaccount" id="liMyAccount">
                        <a class="nav-link" href="myaccount">My Account</a>
                    </li>
                </c:if>

                <li class="nav-item shopping-cart">
                    <a class="nav-link" href="shopping-cart">Shopping Cart</a>
                </li>
                <c:if test="${user == null}">
                    <li class="nav-item login" id="liLogin">
                        <a class="nav-link" href="login">Login</a>
                    </li>
                </c:if>
                <c:if test="${user.getIsAdmin() == 1}">
                    <li class="nav-item dropdown product-list product-management">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Management
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="product-management">Create New Product</a>
                            <a class="dropdown-item" href="product-list">Product List</a>
                        </div>
                    </li>
                </c:if>
                <c:if test="${user != null}">
                    <li class="nav-item logout" id="liLogout">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>