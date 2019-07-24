"use strict";

$(function(){
    console.log("Shopping cart!!!");
    let sum = 0;
    
    // initialize display for the raw data from server
    formatMoney();
    calPrice();
    // format money
    function formatMoney() {
	    $(".format-money").each( (i, val) => {
	    		console.log("format-money", $(val).text());
	    		let price = parseFloat($(val).text().replace("$","")).toFixed(2);
	    		$(val).text("$" + price);
	    });
    }
    // calculate the unit price for each items in the current cart
    function calPrice() {
	    	sum = 0;
	    	console.log("calPrice");
		$(".item").each((i, val) => {
	        let qty = $(val).find(".qty").val();
	        console.log($(val).find(".price").text());
	        let price = parseFloat($(val).find(".price").text().replace("$",""));
	        let total = parseFloat(qty * price).toFixed(2);
	        sum += (qty * price);
	        $(val).find(".total").text("$" + total);
	    });
		console.log("sum", sum);
		$("#sum").text("$" + parseFloat(sum).toFixed(2));
    }
    
    $(".qty").change(qtyChange);
    function qtyChange() {
    		let productId = $(this).attr("productId");
    		console.log("product id", productId, "changed the value");
    		let qty = $(this).val();
    		let item = {id: productId, qty: qty};
    		
    		$.post("shopping-cart/update", {
			product: JSON.stringify(item)
		}).done(updatedItemSuccess).fail(error);
    }
    
    function updatedItemSuccess(items) {
    		console.log("Updated Item successfully!!!!");
    		formatMoney();
    		calPrice();
    }
    
    $("#btnRemove").click(() => {
    		let removedTtems = [];
    		$(".check:checked").each((i, val) => {
    			console.log("checked", $(val).val(), $(val).is(":checked"));
    			 	let id = parseInt($(val).val());
				let product = {};
				product.id = id;
				product.qty = 0;
				removedTtems.push(product);
    		});
    		console.log("removedTtems", removedTtems);
    		if (removedTtems.length > 0) {
    			$.post("shopping-cart/remove", {
    				products: JSON.stringify(removedTtems)
    			}).done(displayMycart).fail(error);
    		}
    		
    });

    function displayMycart(items) {
        console.log("displayMycart", items);
        JSON.parse(items).forEach( p => {
        		$("#item_"+p.id).remove();
        });
        formatMoney();
        calPrice();
    }

    function error(err) {
        console.error(err);
    }
    
    // continue shopping
    $("#btnContinueShopping").click(()=>{
    		$(location).attr("href", "product");
    });
    
    // navigate to checkout
    $("#btnCheckout").click(()=>{
    		console.log("checkout click");	
    		if ($(".item").length > 0) {
    			$(location).attr("href", "checkout");
    		} else {
    			$("#alertBody").html("Please add item in your cart before doing checkout.")
    			$("#myModal").modal("show");
    		}
    });
    
});