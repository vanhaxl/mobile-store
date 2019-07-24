"use strict";

$(function () {

    $('form#signupForm').submit(function (e) {
        e.preventDefault();
        var user = {};
        user.email = $("#email").val();
        user.password = $("#password").val();
        user.fullname = $("#fullname").val();
        user.telephone = $("#telephone").val();
        user.address = $("#address").val();

        $.post("signup", JSON.stringify(user)).done(function (data) {
            console.log("sign up", data);
            if (JSON.parse(data).success) {
                $(location).attr("href", "login");
            } else {
                $("#alertBody").html("Your account is already registered or the info is incorrect, please sign up again");
                $("#myModal").modal("show");
            }

        }).fail(function(err) {
            console.error("sign up", err);
        });
    });
});