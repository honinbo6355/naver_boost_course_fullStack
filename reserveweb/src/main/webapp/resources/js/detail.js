var detail = {
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
	    }).fail(function(jqXHR, textStatus, errorThrown) {
	        console.log("textStatus : " + textStatus);
	    });
	}
};

$(document).ready(function() {
	detail.init();
	detail.eventListener();
});
