document.getElementById("cep").addEventListener("input", async function(){
	const cep = this.value.replace(/\D/g, "");
	
	if (cep.length === 8){
		try{
			const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
			
			if(!response.ok) throw new Error("Erro ao buscar CEP");
			
			const dados = await response.json();
			
			if (dados.erro){
				alert("CEP não encontrado.")
				return;
			}
			
			document.getElementById("rua").value = dados.logradouro;
			document.getElementById("bairro").value = dados.bairro;
			document.getElementById("cidade").value = dados.localidade;
			document.getElementById("estado").value = dados.estado;
				
		} catch (error) {
			alert("Erro ao buscar o endereço: " + error.message);
		}
		
	}
})

document.getElementById("enderecoForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const cep = document.getElementById("cep").value;
    const nomeRua = document.getElementById("rua").value;
    const numeroCasa = document.getElementById("numero").value;
    const bairro = document.getElementById("bairro").value;
    const cidade = document.getElementById("cidade").value;
    const estado = document.getElementById("estado").value;

    try {
        const response = await fetch("http://localhost:8080/cadastroendereco", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(
				{ 
					cep,
					nomeRua,
					numeroCasa,
					bairro,
					cidade,
					estado
				}),
        });

        if (!response.ok) {
            throw new Error("Erro ao cadastrar endereço");
        }
		else{
			window.location.href = "sucessocadastro.html";  // Altere para a próxima página desejada
		}
    } catch (error) {
        alert(error.message);
    }
});
