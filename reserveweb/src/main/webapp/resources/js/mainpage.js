var mainPage = {
	totalProductCount : 0,
	selectedCategoryId : '',

	init : function() {
		this.getCategories();
		this.getProducts(mainPage.selectedCategoryId);
	},

	eventListener : function() {
		$("#moreViewBtn").on("click", mainPage.moreView);
	},

	getProducts : function(id, viewCount) {
		$.ajax({
			url : "/api/products",
			data : {
				categoryId: id,
				start: viewCount
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

	// drawMoreViewBtn : function() {
	// 	var div = document.createElement("div");
	// 	var button = document.createElement("button");
	// 	var span = document.createElement("span");
	//
	// 	div.className = "more";
	// 	button.className = "btn";
	// 	button.dataset.view = 1;
	// 	button.addEventListener("click", function() {
	// 		mainPage.moreView(button);
	// 	});
	// 	span.textContent = "더보기";
	//
	// 	button.append(span);
	// 	div.append(button);
	//
	// 	$('#wrap_event_list').append(div);
	// },

	drawProducts : function(response) {
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
				mainPage.selectCate(this, item.count);
			});

			a.className = "anchor category";
			span.textContent = item.name;

			mainPage.totalProductCount += item.count;

			a.append(span);
			li.append(a);

			$("#category_tab").append(li);
		});

		mainPage.setProductCount(mainPage.totalProductCount);
	},

	selectTotalList : function(selectedCate) {
		mainPage.selectCate(selectedCate, mainPage.totalProductCount);
	},

	setProductCount : function(count) {
		$("#product_count").html(count + "개");
	},

	selectCate : function(selectedCate, count) {
		$('.anchor.category').removeClass('active');
		$(selectedCate).children().addClass('active');
		$('.lst_event_box').empty();

		$("#moreViewBtn").data("view", 1);
		mainPage.setProductCount(count);
		mainPage.getProducts(selectedCate.dataset.category);
	},

	moreView : function() {
		var viewCount = $("#moreViewBtn").data("view");

		mainPage.getProducts(mainPage.selectedCategoryId, viewCount);
		$("#moreViewBtn").data("view", viewCount+1);
	}
};

$(document).ready(function() {
	mainPage.init();
	mainPage.eventListener();
});
