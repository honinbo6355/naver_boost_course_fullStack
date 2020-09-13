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
			dataType: "json"
		}).done(function( response, textStatus, jqXHR ) {
			console.log("response : " + response);
			mainPage.drawProducts(response);
		}).fail(function( jqXHR, textStatus, errorThrown ) {
			console.log("textStatus : " + textStatus);
		});
	},

	getCategories : function() {
		$.ajax({
			url: "/api/categories",
			type: "GET",
			dataType: "json"
		}).done(function( response, textStatus, jqXHR ) {
			console.log("response : " + response);
			mainPage.drawCategories(response);
		}).fail(function( jqXHR, textStatus, errorThrown ) {
			console.log("textStatus : " + textStatus);
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

		var div = document.createElement("div");
		var button = document.createElement("button");
		var span = document.createElement("span");

		div.className = "more";
		button.className = "btn";
		button.dataset.view = 1;
		button.addEventListener("click", function() {
			mainPage.moreView(button);
		});
		span.textContent = "더보기";

		button.append(span);
		div.append(button);

		$('#wrap_event_list').append(div);

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
				mainPage.selectCate(this);
			});

			a.className = "anchor category";
			span.textContent = item.name;

			a.append(span);
			li.append(a);

			$("#category_tab").append(li);
		});
	},

	selectCate : function(selectedCate) {
		$('.anchor.category').removeClass('active');

		$(selectedCate).children().addClass('active');

		mainPage.getProducts(selectedCate.dataset.category);
	},

	moreView : function(button) {
		debugger;
	}
};

$(document).ready(function() {
	mainPage.init();
});
