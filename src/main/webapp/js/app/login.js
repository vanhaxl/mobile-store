"use strict";

$(function () {

    $('form#loginForm').submit(function (e) {
        e.preventDefault();
        var user = {};
        user.email = $("#email").val();
        user.password = $("#password").val();
        var rememberme = $('#rememberme')[0].checked === true ? 1 : 0;//jquery 3.3.1

        $.post("login?rememberme=" + rememberme, JSON.stringify(user)).done(function (data) {
        		console.log("login", data);
        		if (JSON.parse(data).success) {
        			$(location).attr("href", "product");
        		} else {
        			$("#alertBody").html("Please re-check user name and password.")
        			$("#myModal").modal("show");
        		}
        		
        }).fail(function(err) {
        		console.error("login", err);
        });
    });
});