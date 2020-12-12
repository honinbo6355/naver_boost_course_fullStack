(function() {

    "use strict";

    const productImageObj = {
        productImages : [],
        curImgIdx : 0,
        slideWidth : 414,
        slideSpeed : 300
    }

    const detailController = {
        init : function() {
            $('.header').addClass('fade');

            this.getProductDetail();
            productImageView.init();
        },
        getProductDetail : function() {
            $.ajax({
                url : "/api/products/" + $('#displayInfoId').val(),
                type : "GET",
                dataType : "json",
                async : false
            }).done(function(response, textStatus, jqXHR) {
                console.log("response : " + response);
                productImageObj.productImages = response.productImages;
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
            $.each(productImageObj.productImages, function(index, item) {
                $("#productImageItemTmpl").tmpl(item).appendTo(this.$ul);
            }.bind(this));

            if (productImageObj.productImages.length > 1) {
                let $firstNodeClone = this.$ul.children().first().clone();
                let $lastNodeClone = this.$ul.children().last().clone();

                this.$ul.prepend($lastNodeClone); // 맨 앞에 복사한 마지막 노드 붙이기
                this.$ul.append($firstNodeClone); // 맨 뒤에 복사한 첫번째 노드 붙이기

                this.$ul.css("transform", "translate3d(-" + productImageObj.slideWidth * (productImageObj.curImgIdx+1) + "px, 0px, 0px)"); // 최초에는 translate3d(-414px, 0px, 0px)
                this.$prevNav.on("click", this.prevSlide.bind(this)).show();
                this.$nextNav.on("click", this.nextSlide.bind(this)).show();
                this.$totalPage.text(productImageObj.productImages.length);
            }
        },
        prevSlide : function() {
            if (productImageObj.curImgIdx >= 0) {
                this.$ul.css("transition", "transform 0.3ms ease-out");
                this.$ul.css("transform", "translate3d(-" + (productImageObj.slideWidth * productImageObj.curImgIdx) + "px, 0px, 0px)");
            }
            if (productImageObj.curImgIdx === 0) { // 첫번째 노드에서 이전 버튼 클릭했을 경우
                setTimeout(function() {
                    this.$ul.css("transition", "0ms");
                    this.$ul.css("transform", "translate3d(-" + (productImageObj.slideWidth * productImageObj.productImages.length) + "px, 0px, 0px)"); // 마지막 노드 위치로 이동
                }.bind(this), productImageObj.slideSpeed);
                productImageObj.curImgIdx = productImageObj.productImages.length;
            }
            productImageObj.curImgIdx--;
            this.$currentPage.text(productImageObj.curImgIdx+1);
        },
        nextSlide : function() {
            if (productImageObj.curImgIdx <= productImageObj.productImages.length - 1) {
                this.$ul.css("transition", "transform 0.3ms ease-out");
                this.$ul.css("transform", "translate3d(-" + (productImageObj.slideWidth * (productImageObj.curImgIdx+2)) + "px, 0px, 0px)");
            }
            if (productImageObj.curImgIdx === productImageObj.productImages.length - 1) { // 마지막 노드에서 다음 버튼 클릭했을 경우
                setTimeout(function() {
                    this.$ul.css("transition", "0ms");
                    this.$ul.css("transform", "translate3d(-" + productImageObj.slideWidth + "px, 0px, 0px)"); // 첫번째 노드 위치로 이동
                }.bind(this), productImageObj.slideSpeed);
                productImageObj.curImgIdx = -1;
            }
            productImageObj.curImgIdx++;
            this.$currentPage.text(productImageObj.curImgIdx+1);
        }
    };

    detailController.init();
})();

