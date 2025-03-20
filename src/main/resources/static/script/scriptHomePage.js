// Aguarda o carregamento completo do documento HTML antes de executar o código JavaScript.
// Isso garante que os elementos da página já estejam disponíveis para manipulação.
document.addEventListener("DOMContentLoaded", function () {
    
    // Faz uma requisição para o servidor para buscar os produtos cadastrados no banco de dados.
    // "fetch" é uma função do JavaScript que faz chamadas HTTP para APIs (como um navegador acessando um site).
    fetch("http://localhost:8080/cadastroproduto")
        .then(response => {
            // Verifica se a resposta da requisição foi bem-sucedida (códigos HTTP entre 200 e 299).
            if (!response.ok) {
                // Se o servidor retornou um erro (por exemplo, 404 - Não encontrado), um erro será lançado.
                throw new Error(`Erro ao buscar produtos: ${response.status} ${response.statusText}`);
            }
            // Converte a resposta do servidor para formato JSON (JavaScript Object Notation).
            // JSON é um formato de dados estruturado, parecido com um dicionário, que é fácil de manipular em código.
            return response.json();
        })
        .then(produtos => {
            // Seleciona a div onde os produtos serão inseridos no HTML.
            // querySelector(".produtos") busca um elemento com a classe "produtos" na página.
            const destaquesContainer = document.querySelector(".produtos");

            // Antes de adicionar novos produtos, limpamos qualquer conteúdo que possa estar dentro do contêiner.
            destaquesContainer.innerHTML = "";

            // Verifica se a lista de produtos retornada pelo servidor está vazia.
            if (produtos.length === 0) {
                // Se não houver produtos cadastrados, exibe uma mensagem informando isso.
                destaquesContainer.innerHTML = "<p>Nenhum produto encontrado.</p>";
                return; // Sai da função para evitar que o código continue rodando desnecessariamente.
            }

            // Se há produtos na lista, percorremos cada um deles com o método "forEach".
            produtos.forEach(produto => {
                // O JavaScript pega cada produto e extrai suas informações:
                
                // "produto.nomeProduto" pega o nome do produto do JSON. Se estiver vazio ou não existir, usamos "Produto sem nome".
                const nomeProduto = produto.nomeProduto || "Produto sem nome";

                // "produto.preco" pega o preço. Se existir, formatamos o valor para "R$ 0.00" usando ".toFixed(2)".
                // Se o preço não existir (for undefined ou null), mostramos "Preço indisponível".
                const preco = produto.preco ? `R$ ${produto.preco.toFixed(2)}` : "Preço indisponível";

                // "produto.imgUrl" contém o endereço da imagem do produto. Se não houver imagem, usamos uma imagem genérica.
                const imgUrl = produto.imgUrl || "https://via.placeholder.com/150";

                // Criamos um novo elemento "div" no HTML, que representará um produto na página.
                const produtoElement = document.createElement("div");

                // Adicionamos a classe CSS "produto" para que esse elemento receba estilos apropriados.
                produtoElement.classList.add("produto");

                // Definimos o conteúdo HTML dessa div usando `innerHTML`.
                // Aqui inserimos a imagem do produto, o nome e o preço dentro da div.
                produtoElement.innerHTML = `
                    <img src="${imgUrl}" alt="${nomeProduto}">
                    <h3>${nomeProduto}</h3>
                    <p>${preco}</p>
                `;

                // Adicionamos a div recém-criada dentro da div "produtos" no HTML, exibindo o produto na tela.
                destaquesContainer.appendChild(produtoElement);
            });
        })
        .catch(error => {
            // Se acontecer qualquer erro durante a requisição (problema de rede, servidor fora do ar, etc.), 
            // ele será capturado e mostrado no console do navegador.
            console.error("Erro ao carregar produtos:", error);

            // Além de mostrar o erro no console, exibimos uma mensagem na página informando o problema.
            document.querySelector(".produtos").innerHTML = "<p>Erro ao carregar os produtos. Tente novamente mais tarde.</p>";
        });
});
