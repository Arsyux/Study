let postObject = {
	
	init: function() {
		let _this = this;

		$("#btn-insert").on("click", () => {
			_this.insertPost();
		});
	},

	insertPost: function() {
		let post = {
			title: $("#title").val(),
			content: $("#content").val(),
		}
		console.log(JSON.stringify(post));

		$.ajax({
			type: "POST",
			url: "/post",
			data: JSON.stringify(post),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			let message = response["data"];
			alert(message);			
			location = "/";
		}).fail(function(error) {
			let message = error["data"];
			alert("에러 발생 : " + message);
		});
	},

}

postObject.init();