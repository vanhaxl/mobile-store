"use strict";

$(function(){
    
	let selectedCategoryId = "";
	// List all categories
    $.get("category").done(displayCategory).fail(error);
    
    function displayCategory(catogories) {
        console.log("catogories", JSON.parse(catogories));
        JSON.parse(catogories).forEach(c => {
            console.log(c.name);
            let categoryItem = $("<a>", {
                class: "list-group-item",
                href: "#",
                text: c.name
            });
            $(categoryItem).click(categoryClick(c.id));
            $("#categories").append(categoryItem);
        });
        // Display the default category
        $(".list-group-item").first().click();
    }

    function error(error) {
        console.error(error);
    }
    
    function categoryClick(categoryId) {
        return function() {
        		selectedCategoryId = categoryId;
        		$("#search").val("");
        		$(".list-group-item").removeClass("category-active");
        		$(this).addClass("category-active");
            console.log("categoryId", categoryId);
            $.get("product", {
                "categoryId": categoryId,
                "search": $("#search").val()
            }).done(displayProduct).fail(error);
        }
    }

    // Display all products of the specified category id.
    function displayProduct(products) {
        console.log("products", products);
        let i = 0;
        $("#products").empty();
        $("#categoryCover").empty();
        JSON.parse(products).forEach( p => {
            let active = "";
            let productHtml = `<div class="col-lg-4 col-md-6 mb-4">
                                <div class="card h-100">
                                <a href="product-detail?productId=${p.id}"><img class="card-img-top" src="${p.image}" alt="${p.name}"></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                    <a href="product-detail?productId=${p.id}">${p.name}</a>
                                    </h4>
                                    <h5>$${p.price}</h5>
                                    <p class="card-text">${p.description}</p>
                                </div>
                                <div class="card-footer">
                                    <form action="shopping-cart" method="post">
	                                    	<button type="submit" class="btn btn-outline-primary">
							    				<span class="fa fa-briefcase"></span> Add To Cart
							  			</button>
							  			<input type="hidden" name="productId" value="${p.id}" /> 
                                    </form>
                                </div>
                                </div>
                            </div>`;
            $("#products").append(productHtml);
            if (i == 0) {
                active = "active";
            } else {
                active = "";
            }
            i++;
            let cover = `<div class="carousel-item ${active}">
                            <img class="d-block img-fluid cover" src="${p.image}" alt="${p.name}">
                        </div>`;
            $("#categoryCover").append(cover);
        });
        
        // Default the cover image
        let defaultCover = "";
        if ($(".carousel-item").length == 0) {
	        	defaultCover = `<div class="carousel-item active">
					<img class="d-block img-fluid cover" src="images/cover.jpg" alt="Mobile Store">
				</div>`;
        }
        else {
        		defaultCover = `<div class="carousel-item">
            				<img class="d-block img-fluid cover" src="images/cover.jpg" alt="Mobile Store">
        				</div>`;
        }
        $("#categoryCover").append(defaultCover);
    }
    
    // When searching the products by the specified text 
    $("#searchForm").submit((e) => {
    		e.preventDefault();
    	 	$.get("product", {
             "categoryId": selectedCategoryId,
             "search": $("#search").val()
         }).done(displayProduct).fail(error);
    });
    
});