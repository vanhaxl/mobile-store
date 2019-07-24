$(function () {
    "use strict";
    $("form#filterForm").submit(function (e) {
        e.preventDefault();
        var formData = new FormData($(this)[0]);

        $.ajax({
            url: "product-list",
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
    
    $("#clearBtn").click(function (e) {
        e.preventDefault();
        $("#categoryId").val("");
        $("#keyword").val("");
        $("#active").prop("checked", true);
        $("form#filterForm").submit();
    });
});