function validateAndSubmitForm() {

	if (checkFields()) {
		document.getElementById("form").submit();
	}
}

function checkFields() {
	
	scientificName = document.form.inputNameScien.value;
	popularName =  document.form.inputPopName.value;
	specie = document.form.inputSpecie.value;
	group = document.form.inputGroup.value;
	state = document.form.inputState.value;
	region = document.form.inputRegion.value;
	
	if (scientificName.trim() !== "") {
		if (scientificName.length < 3) {
			$('#lblNameScientific').text("Nome científico inválido!");
			return false;
		}
	} else {
		$('#lblNameScientific').text("Campo obrigatório!");
		// $('#inputName').css("border","1px solid #F00");
		return false;
	}

	if (popularName.trim() !== "") {
		if (popularName.length < 3) {
			$('#lblNamePopular').text("Nome popular inválido!");
			return false;
		}
	} else {
		$('#lblNamePopular').text("Campo obrigatório!");
		// $('#inputCPF').css("border","1px solid #F00");
		return false;
	}

	if (specie.trim() == "") {
		$('#lblSpecie').text("Campo obrigatório!");
		// $('#inputDate').css("border","1px solid #F00");
		return false;
	}

	if (group.trim() == "") {
		$('#lblGroup').text("Campo obrigatório!");
		// $('#inputGender').css("border","1px solid #F00");
		return false;
	}

	if (state.trim() == "") {
		$('#lblState').text("Campo obrigatório!");
		// $('#inputEmail').css("border","1px solid #F00");
		return false;
	}

	if (region.trim() == "") {
		$('#lblRegion').text("Campo obrigatório!");
		// $('#inputProfile').css("border","1px solid #F00");
		return false;
	}

//	if (document.form.inputIdication.value.trim() == "") {
//		$('#lblIndication').text("Escolha pelo menos uma indicação!");
//		return false;
//	}

//	if (document.form.inputContraindication.value.trim() == "") {
//		$('#lblContraindication').text("Escolha pelo menos uma contraindicação!");
//		return false;
//	}

	if (document.form.inputTextAreaDescription.value.trim() !== "") {
		if (document.form.inputTextAreaDescription.value.length < 10) {
			$('#lblDescription').text("Mínimo de 10 caracteres!");
			return false;
		} 
	} else {
		$('#lblDescription').text("Campo obrigatório!");
		return false;
	}

	return true;

}

$(document).ready(function(){
	// jQuery
	function replaceItems (html) {
	    // Replace the <fieldset id="indications"> with a new one returned by server.
	    $('#indications').replaceWith($(html));
	    $('button[name="addItem"]').click(function (event) {
		    event.preventDefault();
		    var data = $('form').serialize();
		    // Add parameter "addItem" to POSTed form data. Button's name and value is
		    // POSTed only when clicked. Since "event.preventDefault();" prevents from
		    // actual clicking the button, following line will add parameter to form
		    // data.
		    data += '&addItem=addItem';
		    $.post('/espec/plantsPublish', data, replaceItems);
		});

		$('button[name="removeItem"]').click(function (event) {
		    event.preventDefault();
		    var data = $('form').serialize();
		    // Add parameter and index of item that is going to be removed.
		    data += '&removeItem=' + $(this).val();
		    $.post('/espec/plantsPublish', data, replaceItems);
		});
	}

	$('button[name="addItem"]').click(function (event) {
	    event.preventDefault();
	    var data = $('form').serialize();
	    // Add parameter "addItem" to POSTed form data. Button's name and value is
	    // POSTed only when clicked. Since "event.preventDefault();" prevents from
	    // actual clicking the button, following line will add parameter to form
	    // data.
	    data += '&addItem=addItem';
	    $.post('/espec/plantsPublish', data, replaceItems);
	});

	$('button[name="removeItem"]').click(function (event) {
	    event.preventDefault();
	    var data = $('form').serialize();
	    // Add parameter and index of item that is going to be removed.
	    data += 'removeItem=' + $(this).val();
	    $.post('/espec/plantsPublish', data, replaceItems);
	});
});
