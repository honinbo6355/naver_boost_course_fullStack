(function() {
    "use strict";

    const displayInfoId = $("#displayInfoId").val();
    let prices = [];

    const reserveController = {
        init : function() {
            this.getReservePageInfo();

            common.productImageView.init();
            common.displayInfoView.init();
            priceView.init();
        },

        getReservePageInfo : function() {
            $.ajax({
                url : "/api/reserve/" + displayInfoId,
                type : "GET",
                dataType : "json",
                async : false
            }).done(function(response, textStatus, jqXHR) {
                console.log("response : " + response);
                common.productImageObj.productImages = response.productImages;
                common.displayInfoObj = response.displayInfo;
                prices = response.prices;
            }).fail(function(jqXHR, textStatus, errorThrown) {
                console.log("textStatus : " + textStatus);
            });
        }
    };

    const priceView = {
        init : function() {
            this.cacheDom();
            this.render();
        },
        cacheDom : function() {
            this.$ticketContainer = $("#ticketContainer");
        },
        render : function() {
            prices.forEach(function(item) {
                $("#priceItemTmpl").tmpl(item).appendTo(this.$ticketContainer);
            }.bind(this));

//            $.each(prices, function(index, item) {
//                $("#priceItemTmpl").tmpl(item).appendTo(this.$ticketContainer);
//            }.bind(this));
        }
    }

    $('.header').addClass('fade');
    reserveController.init();
})();