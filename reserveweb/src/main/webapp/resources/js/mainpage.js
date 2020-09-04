var mainPage = {
	init : function() {
		this.getCategories();
		this.getProducts('');
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
		$('#wrap_event_list').empty();

		if (response.data.productList.length === 1)
			$('#wrap_event_list').append($('<ul>', {class: 'lst_event_box'}));
		else if (response.data.productList.length >= 2) {
			$('#wrap_event_list').append($('<ul>', {class: 'lst_event_box'}));
			$('#wrap_event_list').append($('<ul>', {class: 'lst_event_box'}));
		}

		$("#product_count").html(response.data.productCount + "개");

		$.each(response.data.productList, function(index, item) {
			var parentNodeIdx = index%2;
			$('#itemList').tmpl(item).appendTo($('.lst_event_box:eq(' + parentNodeIdx + ')'));
		});
	},

	drawCategories : function(response) {
		$.each(response.data, function(index, item) {
			var li = document.createElement("li");
			var a = document.createElement("a");
			var span = document.createElement("span");

			li.className = "item";
			li.dataset.category = item.id;
			li.addEventListener("click", function() {
				mainPage.getProducts(item.id);
			});

			a.className = "anchor";
			span.textContent = item.name;

			a.append(span);
			li.append(a);

			$("#category_tab").append(li);
		});
	}
};

$(document).ready(function() {
	mainPage.init();
});
