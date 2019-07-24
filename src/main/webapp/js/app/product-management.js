"use strict";

$(function () {
    "use strict";
    
    $("form#productForm").submit(function (e) {
        e.preventDefault();
        var formData = new FormData($(this)[0]);

        $.ajax({
            url: "product-management",
            type: "POST",
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: function () {
                window.location.href = "product-list";
            }
        });
    });
});