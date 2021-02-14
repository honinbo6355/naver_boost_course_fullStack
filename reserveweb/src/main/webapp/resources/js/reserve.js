(function() {
    "use strict";

    const displayInfoId = $("#displayInfoId").val();

    const reserveController = {
        init : function() {
            this.getReservePageInfo();
        },

        getReservePageInfo : function() {
            $.ajax({
                url : "/api/reserve/" + displayInfoId,
                type : "GET",
                dataType : "json",
                async : false
            }).done(function(response, textStatus, jqXHR) {
                console.log("response : " + response);
            }).fail(function(jqXHR, textStatus, errorThrown) {
                console.log("textStatus : " + textStatus);
            });
        }
    };

    reserveController.init();
})();