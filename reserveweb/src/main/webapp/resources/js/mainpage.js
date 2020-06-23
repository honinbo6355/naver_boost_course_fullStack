var mainPage = {
	init : function() {
		this.getCategories();
	},

	getCategories : function() {
		$.ajax({
			url: "/api/categories",
			type: "GET",
			dataType: "json",
			success : function(data) {
				console.log("data : " + data);

			},
			error : function(xhr, textStatus, errorThrown) {

			}
		});
	}
};

$(document).ready(function() {
	mainPage.init();
});