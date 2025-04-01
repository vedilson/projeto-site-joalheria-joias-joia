document.addEventListener("DOMContentLoaded", async () => {
    const produtosContainer = document.querySelector(".produtos");

    try {
        // Substitua a URL abaixo pela URL real do seu backend
        const response = await fetch("http://localhost:8080/cadastroproduto");
        if (!response.ok) {
            throw new Error("Erro ao carregar os produtos");
        }

        const produtos = await response.json();

        produtos.forEach(produto => {
            const produtoCard = document.createElement("div");
            produtoCard.classList.add("produto");

            produtoCard.innerHTML = `
                <a href="http://localhost:8080/produto.html?id=${produto.id}">
                    <img src="${produto.imgUrl}" alt="${produto.nomeProduto}">
                    <h3>${produto.nomeProduto}</h3>
                    <span>R$ ${produto.preco.toFixed(2)}</span>
                </a>
            `;

            produtosContainer.appendChild(produtoCard);
        });
    } catch (error) {
        console.error("Erro:", error);
        produtosContainer.innerHTML = "<p>Erro ao carregar os produtos.</p>";
    }
});
