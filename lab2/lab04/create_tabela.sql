-- Execute este script no SQL Editor do Supabase antes de rodar os programas
CREATE TABLE IF NOT EXISTS produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    quantidade INTEGER NOT NULL
);

-- Alguns registros de exemplo (opcional)
INSERT INTO produtos (nome, preco, quantidade) VALUES
    ('Teclado', 89.90, 15),
    ('Mouse', 39.90, 30),
    ('Monitor', 799.00, 8);
