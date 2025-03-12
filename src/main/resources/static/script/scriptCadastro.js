document.getElementById("clienteForm").addEventListener("submit", async function(event) {
	event.preventDefault();

	const nomeCliente = document.getElementById("nome").value;
	const cpf = document.getElementById("cpf").value;
	const email = document.getElementById("email").value;
	const telefone = document.getElementById("telefone").value;
	const dataNascimento = document.getElementById("dataNascimento").value;

	try {
		const response = await fetch("http://localhost:8080/cadastrocliente", {
			method: "POST",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({ nomeCliente, cpf, email, telefone, dt_Nascimento: dataNascimento }),
		});

		if (!response.ok) {
			throw new Error("Erro ao cadastrar cliente");
		}
		else {
			window.location.href = "cadastroendereco.html";
		}

	} catch (error) {
		alert(error.message);
	}
});





