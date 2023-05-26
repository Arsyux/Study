let loginObject = {

	init: function() {
		$("#btn-login").on("click", () => {
			this.login();
		});
	},

	login: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		}
		$.ajax({
			type: "POST",
			url: "/auth/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			let message = response["data"];
			alert(message);
			if (response["status"] == 200) {
				location = "/";
			}
		}).fail(function(error) {
			let message = error["data"];
			alert("문제 발생 : " + message);
		});
	},
}

loginObject.init();