-- Tabela Empresa
CREATE TABLE empresa (
    id SERIAL PRIMARY KEY,
    cnpj VARCHAR(14) UNIQUE NOT NULL,
    nome_fantasia VARCHAR(255) NOT NULL,
    cep VARCHAR(8) NOT NULL
);

-- Tabela Fornecedor
CREATE TABLE fornecedor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    tipo CHAR(1) NOT NULL,
    cnpj VARCHAR(14),
    cpf VARCHAR(11),
    rg VARCHAR(20),
    data_nascimento DATE
);

-- Tabela de junção
CREATE TABLE empresa_fornecedor (
    id SERIAL PRIMARY KEY,
    id_empresa INT REFERENCES empresa(id),
    id_fornecedor INT REFERENCES fornecedor(id)
);
