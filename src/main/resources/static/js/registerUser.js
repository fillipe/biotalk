function validateAndSubmitForm() {

		$.ajax(
				{
					url : window.origin + '/api/user/verifyByCpf/'
							+ $('#cpf').val()
				}).then(function(ifExists) {
			if (ifExists) {
				window.location.href = window.origin + '/registerUser?error=true';
			} else {
				document.getElementById("form").submit();
			}
		});
}