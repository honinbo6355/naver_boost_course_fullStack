(function() {
    "use strict";

    const displayInfoId = $("#displayInfoId").val();
    let prices = [];
    let reservationDate = "";

    const reserveController = {
        init : function() {
            this.getReservePageInfo();

            common.productImageView.init();
            common.displayInfoView.init();
            priceView.init();
            reserveFormView.init();
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
                reservationDate = response.reservationDate;
            }).fail(function(jqXHR, textStatus, errorThrown) {
                console.log("textStatus : " + textStatus);
            });
        }
    };

    const priceView = {
        init : function() {
            this.cacheDom();
            this.bindEvent();
            this.render();
        },
        cacheDom : function() {
            this.$ticketContainer = $("#ticketContainer");
        },
        bindEvent : function() {
            prices.forEach(function(item) {
                this.$ticketContainer.on("click", "#amountMinusBtn_" + item.productPriceId, function() {
                    this.clickAmountMinusBtn(item.productPriceId)
                }.bind(this));

                this.$ticketContainer.on("click", "#amountPlusBtn_" + item.productPriceId, function() {
                    this.clickAmountPlusBtn(item.productPriceId);
                }.bind(this));
            }.bind(this));
        },
        render : function() {
            prices.forEach(function(item) {
                $("#priceItemTmpl").tmpl(item).appendTo(this.$ticketContainer);
            }.bind(this));
        },
        clickAmountMinusBtn : function(productPriceId) {
            var $amount = $("#amount_" + productPriceId);
            var resultAmountVal;

            if (Number($amount.val()) === 0) {
                return;
            }

            resultAmountVal = Number($amount.val())-1;

            $amount.val(resultAmountVal);

            if (resultAmountVal === 0) {
                $(event.target).addClass("disabled");
            }

            this.calculateTotalTypePrice(resultAmountVal, $("#price_" + productPriceId), $("#totalPrice_" + productPriceId));
        },
        clickAmountPlusBtn : function(productPriceId) {
            var $amount = $("#amount_" + productPriceId);
            var resultAmountVal;

            if (Number($amount.val()) === 0) {
                $("#amountMinusBtn_" + productPriceId).removeClass("disabled");
            }

            resultAmountVal = Number($amount.val())+1;
            $amount.val(resultAmountVal);

            this.calculateTotalTypePrice(resultAmountVal, $("#price_" + productPriceId), $("#totalPrice_" + productPriceId));
        },
        calculateTotalTypePrice : function(amountVal, $typePrice, $totalTypePrice) {
            $totalTypePrice.text(amountVal * Number($typePrice.text()));
        },
    };

    const reserveFormView = {
        init : function() {
            this.cacheDom();
            this.render();
        },
        cacheDom : function() {
            this.$reservationDate = $("#reservationDate");
        },
        render : function() {
            this.$reservationDate.text(getDateCommaStr_yyyymmdd(reservationDate));
        }
    };

    $('.header').addClass('fade');
    reserveController.init();
})();