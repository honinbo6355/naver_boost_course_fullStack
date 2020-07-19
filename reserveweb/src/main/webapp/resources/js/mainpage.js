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
			success : function (response) {
				console.log("response : " + response);
				mainPage.drawProducts(response);
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
			success : function(response) {
				console.log("response : " + response);
				mainPage.drawCategories(response);
			},
			error : function(xhr, textStatus, errorThrown) {

			}
		});
	},

	drawProducts : function(response) {
		$('.wrap_event_box').empty();

		if (response.data.productList.length === 1)
			$('.wrap_event_box').append($('<ul>'), { class : 'lst_event_box'});
		else if (response.data.productList.length >= 2) {
			$('.wrap_event_box').append($('<ul>', {class: 'lst_event_box'}));
			$('.wrap_event_box').append($('<ul>', {class: 'lst_event_box'}));
		}

		$.each(response.data.productList, function(index, item) {
			var parentNodeIdx = index%2;
			$('#itemList').tmpl(item).appendTo($('.lst_event_box:eq(' + parentNodeIdx + ')'));
		});
	},

	drawCategories : function(response) {
		$.each(response.data, function(index, item) {
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
	}
};

$(document).ready(function() {
	mainPage.init();
});
