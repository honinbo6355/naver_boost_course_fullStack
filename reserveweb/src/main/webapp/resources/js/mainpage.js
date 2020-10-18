var mainPage = {
	totalProductCount : 0,
	selectedCategoryId : '',

	init : function() {
		this.getCategories();
		this.getPromotions();
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

	getPromotions : function() {
		$.ajax({
			url: "/api/promotions",
			type: "GET",
			dataType: "json"
		}).done(function(response, textStatus, jqXHR) {
			console.log("response : " + response);
			mainPage.drawPromotions(response);
		}).fail(function(jqXHR, textStatus, errorThrown) {
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
		$.each(response.items, function(index, item) {
			var parentNodeIdx = index%2;
			$('#itemList').tmpl(item).appendTo($('.lst_event_box:eq(' + parentNodeIdx + ')'));
		});
	},

	drawCategories : function(response) {
		$.each(response.items, function(index, item) {
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
	},

	drawPromotions : function(response) {
		$.each(response.items, function(index, item) {
			var li = document.createElement("li");
			var img = document.createElement("img");

			li.className = "item";

			img.src = CONTEXT_PATH + "/resources/" + item.productImageUrl;
			img.className = "img_promotion";

			li.append(img);
			$("#promotionArea").append(li);
		});

		var promotionUl = document.querySelector("#promotionArea");
		var firstItemClone = promotionUl.firstElementChild.cloneNode(true);
		promotionUl.append(firstItemClone);

		var promotionCnt = 3;
		var curIndex = 0;
		setInterval(function() {
			promotionUl.style.transition = "transform 2s ease-out";
			promotionUl.style.transform = "translate3d(-" + 414 * (curIndex+1) + "px, 0px, 0px)";
			curIndex++;

			if (curIndex === promotionCnt - 1) {
				setTimeout(function() {
					promotionUl.style.transition = "0s";
					promotionUl.style.transform = "translate3d(0px, 0px, 0px)";
				}, 2001);
				curIndex = 0;
			}
		}, 2000);
		// setInterval(() => {
		// 	imageUl.
		// }, 200);
	}
};

$(document).ready(function() {
	mainPage.init();
	mainPage.eventListener();
});
