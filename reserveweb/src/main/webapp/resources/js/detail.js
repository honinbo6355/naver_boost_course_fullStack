(function() {

    "use strict";

    const displayInfoId = $('#displayInfoId').val();

    const productImageObj = {
        productImages : [],
        curImgIdx : 0,
        slideWidth : 414,
        slideSpeed : 300
    };

    let displayInfoObj = {};
    let displayInfoImage = {};
    let commentArr = [];
    let averageScore = 0.0;

    const detailController = {
        init : function() {
            this.getProductDetail();

            productImageView.init();
            displayInfoView.init();
            commentView.init();
            detailInfoView.init();
        },
        getProductDetail : function() {
            $.ajax({
                url : "/api/products/" + displayInfoId,
                type : "GET",
                dataType : "json",
                async : false
            }).done(function(response, textStatus, jqXHR) {
                console.log("response : " + response);
                productImageObj.productImages = response.productImages;
                displayInfoObj = response.displayInfo;
                displayInfoImage = response.displayInfoImage;
                commentArr = response.comments;
                averageScore = response.averageScore;
            }).fail(function(jqXHR, textStatus, errorThrown) {
                console.log("textStatus : " + textStatus);
            });
        },
    };

    const productImageView = {
        init : function() {
            this.cacheDom();
            this.bindEvent();
            this.render();
        },
        cacheDom : function() {
            this.$ul = $("#productImageList");
            this.$currentPage = $("#currentPage");
            this.$totalPage = $("#totalPage");
            this.$prevNav = $("#prevNav");
            this.$nextNav = $("#nextNav");
        },
        bindEvent : function() {
            this.$prevNav.on("click", this.prevSlideClick.bind(this));
            this.$nextNav.on("click", this.nextSlideClick.bind(this));
        },
        render : function() {
            $.each(productImageObj.productImages, function(index, item) {
                const resultItem = $.extend(true, {}, item, {"title" : displayInfoObj.productDescription});
                $("#productImageItemTmpl").tmpl(resultItem).appendTo(this.$ul);
            }.bind(this));

            if (productImageObj.productImages.length > 1) {
                let $firstNodeClone = this.$ul.children().first().clone();
                let $lastNodeClone = this.$ul.children().last().clone();

                this.$ul.prepend($lastNodeClone); // 맨 앞에 복사한 마지막 노드 붙이기
                this.$ul.append($firstNodeClone); // 맨 뒤에 복사한 첫번째 노드 붙이기

                this.$ul.css("transform", "translate3d(-" + productImageObj.slideWidth * (productImageObj.curImgIdx+1) + "px, 0px, 0px)"); // 최초에는 translate3d(-414px, 0px, 0px)
                this.$prevNav.show();
                this.$nextNav.show();
                this.$totalPage.text(productImageObj.productImages.length);
            }
        },
        prevSlideClick : function() {
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
        nextSlideClick : function() {
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

    const displayInfoView = {
        init : function() {
            this.cacheDom();
            this.bindEvent();
            this.render();
        },
        cacheDom : function() {
            this.$productDscContainer = $("#productDscContainer");
            this.$productDsc = $("#productDsc");
            this.$dscOpenBtn = $("#dscOpenBtn");
            this.$dscCloseBtn = $("#dscCloseBtn");
        },
        bindEvent : function() {
            this.$dscOpenBtn.on("click", this.dscOpenBtnClick.bind(this));
            this.$dscCloseBtn.on("click", this.dscCloseBtnClick.bind(this));
        },
        render : function() {
            this.$productDsc.html(displayInfoObj.productContent);
        },
        dscOpenBtnClick : function() {
            this.$dscOpenBtn.hide();
            this.$dscCloseBtn.show();
            this.$productDscContainer.removeClass("close3");
        },
        dscCloseBtnClick : function() {
            this.$dscCloseBtn.hide();
            this.$dscOpenBtn.show();
            this.$productDscContainer.addClass("close3");
        }
    };

    const commentView = {
        init : function() {
            this.cacheDom();
            this.render();
        },
        cacheDom : function() {
            this.$scoreGraph = $("#scoreGraph");
            this.$averageScore = $("#averageScore");
            this.$totalCommentCnt = $("#totalCommentCnt");
            this.$reviewContainer = $("#reviewContainer");
        },
        render : function() {
            this.$scoreGraph.css("width", (averageScore/5.0) * 100);
            this.$averageScore.html(averageScore.toFixed(1));
            this.$totalCommentCnt.html(commentArr.length + "건");

            if (commentArr.length <= 0) {
                this.$reviewContainer.css("text-align", "center").html("리뷰가 존재하지 않습니다.");
                return;
            }

            this.$reviewContainer.append($("<ul>").attr("id", "reviewUl").attr("class", "list_short_review"));
            $.each(commentArr, function(index, item) {
                if (index >= 3) { // 3개를 초과할 경우 return
                    return false;
                }

                var resultItem = $.extend(true, {}, item, {
                    "score": item.score.toFixed(1),
                    "reservationDate": getDateStr_yyyymmdd(item.reservationDate)
                });
                $("#commentItemTmpl").tmpl(resultItem).appendTo($("#reviewUl"));
            });

            if (commentArr.length > 3) {
                $("#reviewMore").attr("href", "/review/" + displayInfoId).show();
            }
        }
    };

    const detailInfoView = {
        init : function() {
            this.cacheDom();
            this.bindEvent();
            this.render();
        },
        cacheDom : function() {
            this.$detailInfoLis = $("#detailInfoTab > li");
            this.$productIntro = $("#productIntro");
            this.$detailInfoDiv = $("#detailInfoDiv");
            this.$detailLocationDiv = $("#detailLocationDiv");
            this.$locationMapImg = $("#locationMapImg");
            this.$placeStreet = $("#placeStreet");
            this.$placeLot = $("#placeLot");
            this.$placeName = $("#placeName");
            this.$telephone = $("#telephone");
        },
        bindEvent : function() {
            this.$detailInfoLis.on('click', this.clickDetailInfoLi.bind(this));
        },
        render : function() {
            this.$productIntro.html(displayInfoObj.productContent);
            this.$locationMapImg.attr("src", "/resources/" + displayInfoImage.saveFileName);
            this.$placeStreet.html(displayInfoObj.placeStreet);
            this.$placeLot.html(displayInfoObj.placeLot);
            this.$placeName.html(displayInfoObj.placeName);
            this.$telephone.html(displayInfoObj.telephone);
        },
        clickDetailInfoLi : function() {
            var $clickElement = $(event.currentTarget);

            this.$detailInfoLis.children().removeClass("active");
            $clickElement.children().addClass("active");

            switch ($clickElement.attr("id")) {
                case "detailInfo" :
                    this.$detailInfoDiv.removeClass("hide");
                    this.$detailLocationDiv.addClass("hide");
                    break;
                case "detailLocation" :
                    this.$detailInfoDiv.addClass("hide");
                    this.$detailLocationDiv.removeClass("hide");
                    break;
            }
        }
    };

    $('.header').addClass('fade');
    detailController.init();
})();

