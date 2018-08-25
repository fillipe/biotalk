function validateAndSubmitForm() {

		$.ajax(
				{
					url : window.origin + '/api/user/verifyByCpf/'
							+ $('#cpf').val()
				}).then(function(ifExists) {
			if (ifExists) {
				alert("Usuário já cadastrado!");
			} else {
				alert("Usuário cadastrado com sucesso!");
				document.getElementById("form").submit();
			}
		});
}