-- Inserindo Tipos de Usuario (se não existirem)
INSERT IGNORE INTO tb_tipo_usuario (id_tipo_usuario, nome_tipo_usuario) VALUES
(1, 'Admin'),
(2, 'Cliente'),
(3, 'Vendedor'),
(4, 'Gerente');

-- Inserindo Categorias (se não existirem)
INSERT IGNORE INTO tb_categoria_produto (id_categoria_produto, nome_categoria_produto, descricao_categoria_produto) VALUES
(1, 'Anéis', 'Acesório para os dedos'),
(2, 'Colares', 'Acesório para o pescoço'),
(3, 'Brincos', 'Acesório para as orelhas'),
(4, 'Pulseiras', 'Acessorio para os braços'),
(5, 'Relógios', 'Acesório para não atrasar no SENAI');

-- Inserindo Tipos (se não existirem)
INSERT IGNORE INTO tb_tipo_produto (id_tipo_produto, nome_tipo_produto, descricao_tipo_produto) VALUES
(1, 'Ouro', '18k'),
(2, 'Prata', '750'),
(3, 'Bijuteria', 'É biju mas é de rico');

INSERT IGNORE INTO tb_produto (nome_produto, descricao_produto, preco_produto, categoria_produto, tipo_produto, img_produto) VALUES
('Colar Love By', 'Colar em Ouro Amarelo com Diamante', 13260, 2, 1, 'https://montecarlo.vtexassets.com/arquivos/ids/699363-1500-1500/NIM027981_1.jpg?v=638593465528630000'),
('Brinco Love By', 'Brinco em Ouro Amarelo com Diamante', 4290, 3, 1, 'https://montecarlo.vtexassets.com/arquivos/ids/699724-1500-1500/NIM027982_1.jpg?v=638598646628400000'),
('Anel Love By', 'Anel em Ouro Amarelo com Diamante', 4450, 1, 1, 'https://montecarlo.vtexassets.com/arquivos/ids/699701-1500-1500/NIM027987_1.jpg?v=638598643255800000'),
('Pulseira Love By', 'Pulseira em Ouro Amarelo com Diamante', 38860, 4, 1, 'https://montecarlo.vtexassets.com/arquivos/ids/724034-1500-1500/NIM027985_1.jpg?v=638781675695070000'),
('Relógio Tag Heuer Carrera', 'Relógio Tag Heuer Carrera Masculino Couro Azul', 61570, 5, 1, 'https://lojavivara.vtexassets.com/arquivos/ids/931183-1600-1600/Relogio-Tag-Heuer-Carrera-Masculino-Couro-Azul-CBS2213FN6002-105901_1_set.jpg?v=638747970372730000');