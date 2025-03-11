// Captura o campo de CEP e adiciona um evento para quando ele for preenchido
document.getElementById("cep").addEventListener("input", async function() {
	const cep = this.value.replace(/\D/g, ""); // Remove caracteres não numéricos

	// Verifica se o CEP tem 8 dígitos antes de fazer a requisição
	if (cep.length === 8) {
		try {
			const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
			if (!response.ok) throw new Error("Erro ao buscar CEP");

			const data = await response.json();

			if (data.erro) {
				alert("CEP não encontrado.");
				return;
			}

			// Preenche os campos e bloqueia edição
			document.getElementById("rua").value = data.logradouro;
			document.getElementById("bairro").value = data.bairro;
			document.getElementById("cidade").value = data.localidade;
			document.getElementById("estado").value = data.uf;

		} catch (error) {
			alert("Erro ao buscar o endereço: " + error.message);
		}
	}
});

// Captura o evento de submissão do formulário
document.getElementById("enderecoForm").addEventListener("submit", async function(event) {
	event.preventDefault(); // Evita que a página recarregue

	// Obtém os valores dos campos do formulário
	const cep = document.getElementById("cep").value;
	const rua = document.getElementById("rua").value;
	const numero = document.getElementById("numero").value;
	const bairro = document.getElementById("bairro").value;
	const cidade = document.getElementById("cidade").value;
	const estado = document.getElementById("estado").value;

	try {
		// Envia os dados para a API interna da joalheria
		const response = await fetch("http://localhost:8080/cadastroendereco", {
			method: "POST",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify(
				{
					cep,
					nomeRua: rua,
					numeroCasa: numero,
					bairro,
					cidade,
					estado
				}),
		});

		if (!response.ok) {
			throw new Error("Erro ao cadastrar endereço");
		}
		else {
			window.location.href = "sucessocadastro.html"; // Redirecionamento após cadastro
		}
	} catch (error) {
		alert(error.message);
	}
});
