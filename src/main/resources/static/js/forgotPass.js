function validateAndSubmitForgPass() {

	if (checkEmail() && checkCpf()) {
		$.ajax(
				{
					url : window.origin + '/api/user/verifyByCpfAndEmail/'
							+ $('#cpf').val() + '/' + $('#email').val() 
				}).then(function(ifExists) {
			if (ifExists) {
				alert("Dados não correspondem!");
			} else {
				alert("Nova senha enviada para o email correspondente!");
				document.getElementById("form").submit();
			}
		});
	}
}