-- Tabela Empresa
CREATE TABLE empresa (
  CNPJ VARCHAR(14) PRIMARY KEY,
  nomeFantasia VARCHAR(100),
  CEP VARCHAR(8)
);

-- Tabela Fornecedor
CREATE TABLE fornecedor (
  CNPJCPF VARCHAR(14) PRIMARY KEY,
  Nome VARCHAR(100),
  Email VARCHAR(100),
  CEP VARCHAR(8)
);

-- Tabela de junção
CREATE TABLE empresa_fornecedor (
  empresa_fk VARCHAR(14) REFERENCES empresa(CNPJ),
  fornecedor_fk VARCHAR(14) REFERENCES fornecedor(CNPJCPF),
  PRIMARY KEY (empresa_fk, fornecedor_fk)
);