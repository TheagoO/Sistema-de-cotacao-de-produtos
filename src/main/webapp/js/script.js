$(document).ready(function() {
	$("#gestor").validate({
		rules: {
			cpf: {
				cpfBR: true
			}
		}
	})
});
