<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Checkout</title>
	<!-- Bootstrap core CSS -->
	<link href="js/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	
	<link href="css/shop-homepage.css" rel="stylesheet">
	<link href="css/checkout.css" rel="stylesheet">
	
	<script src="js/jquery/jquery.min.js"></script>
	<script src="js/app/checkout.js" type="text/javascript"></script>
	
</head>
<body>
<jsp:include page="component/header.jsp"></jsp:include>
 <!-- Page Content -->
<div class="container">
	<ul class="breadcrumb">
		<li>
	    		<a href="product">Home</a>
	    		<span class="divider">/</span>
	    </li>
	    <li>
	    		<a href="shopping-cart">Shopping Cart</a>
	    		<span class="divider">/</span>
	    </li>
	    <li>
	    		<a href="#">Checkout</a>
	    </li>
    </ul>
	<div class="row shopping-cart">
	  <form class="payment-form">
	    <div class="form-group row">
	      <label for="fullName" class="col-sm-2 col-form-label">Full Name</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Danh Dat Doan" value="${user.fullname}" required>
	      </div>
	    </div>
	    <div class="form-group row">
	      <label for="address" class="col-sm-2 col-form-label">Shipping Address</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="address" name="address" placeholder="Address" value="${user.address}" required>
	      </div>
	    </div>
	    <div class="form-group row">
	      <label for="address" class="col-sm-2 col-form-label">Payment</label>
	      <div class="col-sm-10">
	        <div class="form-check">
	          <label class="form-check-label" for="payInStore">
	            <input class="form-check-input" type="radio" id="payInStore" name="payment" value="Pay In Store" checked>
	            Pay In Store
	          </label>
	        </div>
	        <div class="form-check">
	          <label class="form-check-label" for="card">
	            <input class="form-check-input" type="radio" name="payment" id="card" value="Card">
	            Card
	          </label>
	        </div>
	      </div>
	    </div>
	    <div class="form-group row">
	      <label for="comment" class="col-sm-2 col-form-label">Comment</label>
	      <div class="col-sm-10">
	        <textarea cols="100" rows="10" class="form-control" id="comment" name="comment" placeholder="Comment"></textarea>
	      </div>
	    </div>
	    <div class="form-group row">
	      <div class="offset-sm-2 col-sm-10">
	      	<button type="submit" class="btn btn-outline-primary">
    				<span class="fa fa-calendar"></span> Confirm
  			</button>
	      </div>
	    </div>
	  </form>
	</div>
</div>

<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>