document.getElementById("produtoForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const nomeProduto = document.getElementById("nomeProduto").value;
    const descricao = document.getElementById("descricao").value;
    const preco = parseFloat(document.getElementById("preco").value);
    const imgUrl = document.getElementById("imgUrl").value;
    const categoriaProduto = parseInt(document.getElementById("categoriaProduto").value);
    const tipoProduto = parseInt(document.getElementById("tipoProduto").value);

    try {
        const response = await fetch("http://localhost:8080/cadastroproduto", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                nomeProduto,
                descricao,
                preco,
                imgUrl,
                categoriaProduto: { id: categoriaProduto }, // Envia um objeto com o ID
                tipoProduto: { id: tipoProduto } // Envia um objeto com o ID
            }),
        });

        if (!response.ok) {
            throw new Error("Erro ao cadastrar produto");
        } else {
            alert("Produto cadastrado com sucesso!");
            window.location.href = "index.html";
        }

    } catch (error) {
        alert(error.message);
    }
});
