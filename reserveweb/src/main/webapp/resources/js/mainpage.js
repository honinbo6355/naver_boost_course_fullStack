var mainPage = {
	init : function() {
		this.getCategories();
	},

	eventListener : function() {

	},

	getProducts : function(id) {

		$.ajax({
			url : "/api/products",
			data : {
				categoryId: id
			},
			type: "GET",
			dataType: "json",
			success : function (data) {
				console.log("data : " + data);
			},
			error : function(xhr, textStatus, errorThrown) {

			}
		});
	},

	getCategories : function() {
		$.ajax({
			url: "/api/categories",
			type: "GET",
			dataType: "json",
			success : function(data) {
				console.log("data : " + data);

				$.each(data, function(index, item) {
					$(".event_tab_lst.tab_lst_min").append(
						$('<li>',
							{
								class: "item",
								"data-category": item.id,
								onclick: "mainPage.getProducts(" + item.id + ")"
							}
						).append(
							$('<a>',
								{
									class: "anchor"
								}
							).append(
								$('<span>',
									{
										text: item.name
									}
								)
							)
						)
					);
				});
			},
			error : function(xhr, textStatus, errorThrown) {

			}
		});
	}
};

$(document).ready(function() {
	mainPage.init();
});
