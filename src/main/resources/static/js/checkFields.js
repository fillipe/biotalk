function checkName() {
	var reTipo = /[A-z][ ][A-z]/;
	name = document.form.name.value;
	if (name.trim() !== "" && name.match(reTipo)) {
		if (name.length < 4) {
			$('#name').css("border", "1px solid #F00");
			$('#lblName').text("Nome inválido!");
			return false;
		}
	} else {
		$('#lblName').text("Campo obrigatório inválido!");
		$('#name').css("border", "1px solid #F00");
		return false;
	}

	$('#lblName').text("");
	$('#name').css("border", "1px solid #228B22");
	return true;
}

function checkCpf() {
	var numeros, digitos, soma, i, resultado, digitos_iguais;
	digitos_iguais = 1;
	cpf = document.form.cpf.value;
	if (cpf.length < 11) {
		$('#inputCpf').css("border", "1px solid #F00");
		$('#lblCpf').text("CPF inválido!");
		return false;
	}
	for (i = 0; i < cpf.length - 1; i++)
		if (cpf.charAt(i) != cpf.charAt(i + 1)) {
			digitos_iguais = 0;
			break;
		}
	if (!digitos_iguais) {
		numeros = cpf.substring(0, 9);
		digitos = cpf.substring(9);
		soma = 0;
		for (i = 10; i > 1; i--)
			soma += numeros.charAt(10 - i) * i;
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(0)) {
			$('#cpf').css("border", "1px solid #F00");
			$('#lblCpf').text("CPF inválido!");
			return false;
		}
		numeros = cpf.substring(0, 10);
		soma = 0;
		for (i = 11; i > 1; i--)
			soma += numeros.charAt(11 - i) * i;
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(1)) {
			$('#cpf').css("border", "1px solid #F00");
			$('#lblCpf').text("CPF inválido!");
			return false;
		}

		$('#cpf').css("border", "1px solid #228B22");
		$('#lblCpf').text("");
		return true;
	} else {
		$('#cpf').css("border", "1px solid #F00");
		$('#lblCpf').text("CPF inválido!");
		return false;
	}
}

function checkDate() {

	var date = new Date($("#date").val());

	// date = document.form.date.value;

	var Cnow = new Date();// current Date
	years = Cnow.getFullYear() - date.getFullYear();

	if (document.form.date.value.trim != "") {
		if (years > 98 || years < 12) {
			$('#lblDate').text("Data inválida!");
			$('#date').css("border", "1px solid #F00");
			return false;
		}
	} else {
		$('#lblDate').text("Campo obrigatório!");
		$('#date').css("border", "1px solid #F00");
		return false;
	}
	$('#lblDate').text("");
	$('#date').css("border", "1px solid #228B22");
	return true;

}

function checkGender() {
	gender = document.form.gender.value;
	if (gender.trim() == "") {
		$('#lblGender').text("Campo obrigatório!");
		$('#gender').css("border", "1px solid #F00");
		return false;
	}
	$('#lblGender').text("");
	$('#gender').css("border", "1px solid #228B22");
	return true;
}

function checkEmail() {
	email = document.form.email.value;
	if (email.trim() == "" || email.indexOf('@') == -1
			|| email.indexOf('.') == -1) {
		$('#lblEmail').text("Email inválido!");
		$('#email').css("border", "1px solid #F00");
		return false;
	}
	$('#email').css("border", "1px solid #228B22");
	$('#lblEmail').text("");
	return true;
}

function checkAuthorities() {
	authority = document.form.authority.value;
	if (authority.trim() == "") {
		$('#lblProfile').text("Campo obrigatório!");
		$('#profile').css("border", "1px solid #F00");
		return false;
	} else {
		if (authority != "3") {
			if (document.form.academicDegree.value.trim() == ''
					&& document.form.course.value.trim() == ''
					&& document.form.institution.value.trim() == '') {
				$('#lblAcademicDegree')
						.text(
								"Formação acadêmica necessária para esse tipo de perfil!");
				$('#academicDegree').css("border", "1px solid #F00");
				$('#course').css("border", "1px solid #F00");
				$('#institution').css("border", "1px solid #F00");
				$('#profile').css("border", "1px solid #F00");
				return false;

			}
		}

		$('#lblAcademicDegree').text("");
		$('#academicDegree').css("border", "1px solid");
		$('#course').css("border", "1px solid");
		$('#institution').css("border", "1px solid");
		$('#profile').css("border", "1px solid #228B22");
		return true;

	}
}

function checkPass() {
	if (document.form.password.value.trim() !== "") {
		if (document.form.password.value.length < 8) {
			$('#lblPassword').text("Mínimo 8 caracteres!");
			$('#password').css("border", "1px solid #F00");
			return false;
		}
		$('#lblPassword').text("");
		$('#password').css("border", "1px solid #228B22");
		return true;
	} else {
		$('#lblPassword').text("Campo obrigatório!");
		$('#password').css("border", "1px solid #F00");
		return false;
	}
}

function checkConfirmPass() {
	repitPassword = document.form.repitPassword.value;
	if (repitPassword.trim() !== "") {
		if (repitPassword !== document.form.password.value) {
			$('#repitPassword').css("border", "1px solid #F00");
			$('#lblPasswordRepit').text("Senhas não correspondem!");
			return false;
		}
	} else {
		$('#lblPasswordRepit').text("Campo obrigatório!");
		$('#repitPassword').css("border", "1px solid #F00");
		return false;
	}
	$('#lblPasswordRepit').text("");
	$('#repitPassword').css("border", "1px solid #228B22");
	return true;
}

function checkInstitution() {
	grau = document.form.academicDegree.value;
	curso = document.form.course.value;
	instituicao = document.form.institution.value;
	profile = document.form.profile.value;

	if (profile != 3 && grau.trim() !== '' && curso.trim() !== ''
			&& instituicao.trim() !== '') {
		$('#lblAcademicDegree').text("");
		$('#inputAcademicDegree').css("border", "1px solid #228B22");
		$('#course').css("border", "1px solid #228B22");
		$('#institution').css("border", "1px solid #228B22");
		$('#profile').css("border", "1px solid #228B22");
		return true;
	}
	$('#lblAcademicDegree').text(
			"Formação acadêmica necessária para esse tipo de perfil!");
	$('#academicDegree').css("border", "1px solid #F00");
	$('#course').css("border", "1px solid #F00");
	$('#institution').css("border", "1px solid #F00");
	$('#profile').css("border", "1px solid #F00");
	return false;
}
