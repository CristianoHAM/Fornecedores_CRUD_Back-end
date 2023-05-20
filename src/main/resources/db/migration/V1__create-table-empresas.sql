-- Tabela Empresa
CREATE TABLE empresa (
  CNPJ VARCHAR(14) PRIMARY KEY,
  NomeFantasia VARCHAR(100),
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
  Empresa_CNPJ VARCHAR(14) REFERENCES Empresa(CNPJ),
  Fornecedor_CNPJCPF VARCHAR(14) REFERENCES Fornecedor(CNPJCPF),
  PRIMARY KEY (Empresa_CNPJ, Fornecedor_CNPJCPF)
);