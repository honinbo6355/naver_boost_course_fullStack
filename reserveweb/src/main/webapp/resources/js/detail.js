(function() {

    "use strict";

    const detail = {
        displayInfoId : $('#displayInfoId').val(),
        productImages : [],
        curImgIdx : 0
    };

    const detailController = {
        init : function() {
            $('.header').addClass('fade');

            this.getProductDetail();
            productImageView.init();
        },
        getProductDetail : function() {
            $.ajax({
                url : "/api/products/" + detail.displayInfoId,
                type : "GET",
                dataType : "json",
                async : false
            }).done(function(response, textStatus, jqXHR) {
                console.log("response : " + response);
                detail.productImages = response.productImages;
            }).fail(function(jqXHR, textStatus, errorThrown) {
                console.log("textStatus : " + textStatus);
            });
        },
    };

    const productImageView = {
        init : function() {
            this.cacheDom();
            this.render();
        },
        cacheDom : function() {
            this.$ul = $("#productImageList");
            this.$currentPage = $("#currentPage");
            this.$totalPage = $("#totalPage");
            this.$prevNav = $("#prevNav");
            this.$nextNav = $("#nextNav");
        },
        render : function() {
            $.each(detail.productImages, function(index, item) {
                $("#productImageItem").tmpl(item).appendTo(this.$ul);
            }.bind(this));

            if (detail.productImages.length > 1) {
                this.$prevNav.on("click", this.prevSlide.bind(this)).show();
                this.$nextNav.on("click", this.nextSlide.bind(this)).show();
                this.$totalPage.text(detail.productImages.length);
            }
        },
        prevSlide : function() {
            this.$ul.css("transition", "transform 0.5s ease-out");
            this.$ul.css("transform", "translate3d(-" + 414 * (detail.curImgIdx-1) + "px, 0px, 0px)");
            detail.curImgIdx--;
        },
        nextSlide : function() {
            this.$ul.css("transition", "transform 0.5s ease-out");
            this.$ul.css("transform", "translate3d(-" + 414 * (detail.curImgIdx+1) + "px, 0px, 0px)");
            detail.curImgIdx++;
        }
    };

    detailController.init();
})();

