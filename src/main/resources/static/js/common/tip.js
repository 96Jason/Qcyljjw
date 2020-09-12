define(["jquery"],function(){
	$("body").append('<div sign="tip"></div>');
	$('div[sign="tip"]').css({
		"position": "fixed",
		"top": "20px",
		"width": "400px",
		"height": "40px",
		"border-radius": "10px",
		"text-align": "center",
		"line-height": "40px",
		"display": "none",
		"color": "white",
		"font-weight": "600",
		"font-size": "1.5rem",
	});
	var animation = function(text,color){
		var tip = $('div[sign="tip"]'),
			windowWidth = $(window).width(),
			left = (windowWidth - 400)/2;
		tip.css({
			"background": color,
			"left": left + "px",
		});
		tip.html(text);
		tip.slideDown(1000);
		tip.fadeOut(5000);
	};
	return {
		success: function(text){			
			animation(text,"#1cba63");
		},
		error: function(text){
			animation(text,"#E34910");
		},
		info: function(text){
			animation(text,"#007cb7");
		},
		warn: function(text){
			animation(text,"#ffaa48");
		}
	}
})