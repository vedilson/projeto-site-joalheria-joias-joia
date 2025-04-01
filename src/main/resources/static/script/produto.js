// Aguarda o carregamento completo do DOM antes de executar o código
document.addEventListener("DOMContentLoaded", () => {
    
    // Obtém os parâmetros da URL (query string)
    const urlParams = new URLSearchParams(window.location.search);
    
    // Captura o valor do parâmetro "id" da URL (correspondente ao produto selecionado)
    const produtoId = urlParams.get("id");
    
    // Verifica se um ID de produto foi passado na URL
    if (produtoId) {
        
        // Faz uma requisição para o backend buscando os detalhes do produto pelo ID
        fetch(`http://localhost:8080/cadastroproduto/${produtoId}`)
            .then(response => response.json()) // Converte a resposta para JSON
            .then(produto => {
                // Atualiza a imagem do produto
                document.getElementById("produto-img").src = produto.imgUrl;
                document.getElementById("produto-img").alt = produto.nomeProduto;

                // Atualiza o nome do produto
                document.getElementById("produto-nome").textContent = produto.nomeProduto;
                
                // Atualiza a descrição do produto
                document.getElementById("produto-descricao").textContent = produto.descricao;
                
                // Atualiza o preço do produto, formatando para duas casas decimais
                document.getElementById("produto-preco").textContent = `R$ ${produto.preco.toFixed(2)}`;
            })
            .catch(error => console.error("Erro ao carregar produto:", error)); // Exibe erro caso a requisição falhe
    }
});
