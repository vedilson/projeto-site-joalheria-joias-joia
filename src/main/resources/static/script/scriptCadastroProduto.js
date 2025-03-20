document.getElementById("produtoForm").addEventListener("submit", async function(event) {
	event.preventDefault();

	const nomeProduto = document.getElementById("nomeProduto").value;
	const descricao = document.getElementById("descricao").value;
	const preco = parseFloat(document.getElementById("preco").value);
	const imgUrl = document.getElementById("imgUrl").value;

	try {
		const response = await fetch("http://localhost:8080/cadastroproduto", {
			method: "POST",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({
				nomeProduto,
				descricao,
				preco,
				imgUrl
			}),
		});

		if (!response.ok) {
			throw new Error("Erro ao cadastrar cliente");
		}
		else {
			alert("Produto cadastrado com sucesso!");
			window.location.href = "index.html";
		}

	} catch (error) {
		alert(error.message);
	}
});
