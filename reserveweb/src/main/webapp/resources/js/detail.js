(function() {

    "use strict";

    const detailController = {
        init : function() {
            $('.header').addClass('fade');

            productImageView.init();
        },
        getProductDetail : function() {

        },
    };

    const productImageView = {
        init : function() {

        }
    }

    detailController.init();
})();

/*
var detail = {
    productImages : {},

	init : function() {
	    $('.header').addClass('fade');
	    this.getProductDetail();
    },

	eventListener : function() {

	},

	getProductDetail : function() {
	    $.ajax({
	        url : "/api/products/" + $('#displayInfoId').val(),
	        type : "GET",
	        dataType : "json"
	    }).done(function(response, textStatus, jqXHR) {
	        console.log("response : " + response);
	        detail.drawProductImages(response.productImages);
	    }).fail(function(jqXHR, textStatus, errorThrown) {
	        console.log("textStatus : " + textStatus);
	    });
	},

	drawProductImages : function(productImages) {
	    $.each(productImages, function(index, item) {
            $("#productImageItem").tmpl(item).appendTo(".visual_img.detail_swipe");
	    });
	}
};

$(document).ready(function() {
	detail.init();
	detail.eventListener();
});
*/
