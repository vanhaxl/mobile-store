"use strict";

$(function(){
	let path = location.pathname.split("/");
	let page = path[path.length - 1];

	$(".nav-item").removeClass("active");
	$("." + page).addClass("active");
});