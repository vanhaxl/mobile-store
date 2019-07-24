<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My Shopping Cart</title>
	<!-- Bootstrap core CSS -->
	<link href="js/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	
	<link href="css/shopping-cart.css" rel="stylesheet">
	<link href="css/shop-homepage.css" rel="stylesheet">
	
	<script src="js/jquery/jquery.min.js"></script>
	<script src="js/app/shopping-cart.js" type="text/javascript"></script>
	
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
	    		<a href="#">Shopping Cart</a>
	    </li>
    </ul>
	<div class="row shopping-cart">
		<!-- <h5> Shopping Cart</h5> -->
		<table class="table table-bordered table-striped">
		  <thead>
			  <tr>
				<th>Remove</th>
				<th>Image</th>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Unit Price</th>
				<th>Total</th>
			  </tr>
			</thead>
			<tbody id="tblMyCart">
				<c:forEach items="${myCart}" var="item">
					<tr class="item" id="item_${item.product.id}">
						<td><input class="check" type="checkbox" value="${item.product.id}" id="optionsCheckbox"></td>
						<td class="muted center_text"><a href="product.html"><img src="${item.product.image}" class="product-image"></a></td>
						<td>${item.product.name}</td>
						<td><input class="qty" type="number" placeholder="1" class="input-mini" value="${item.qty}" productid="${item.product.id}"></td>
						<td class="price format-money">${item.price}</td>
						<td class="total format-money">${item.price*item.qty}</td>
			  		</tr>		
				</c:forEach>
			  	<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><strong id="sum"></strong></td>
			  	</tr>		  
			</tbody>
		  </table>
	</div>
	<div class="row shopping-cart">
		 <div class="col-sm-5 left">
	         <button type="button" class="btn btn-outline-primary" id="btnRemove">
    				<span class="fa fa-check-circle"></span> Remove
  			</button>
		</div>		  
		<div class="col-sm-2">
	         <button type="button" class="btn btn-outline-primary" id="btnContinueShopping">
    				<span class="fa fa-forward"></span> Continue shopping
  			</button>
		</div>		  
		<div class="col-sm-5">
	         <button type="button" class="btn btn-outline-primary" id="btnCheckout">
    				<span class="fa fa-calendar"></span> Checkout
  			</button>
		</div>
	</div>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>

</body>
</html>