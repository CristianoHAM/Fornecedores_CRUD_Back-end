package com.example.fornecedores.fornecedor;

public record FornecedorResponseDTO(String cpfCnpj, String nome, String email, String cep) {
    public FornecedorResponseDTO(Fornecedor fornecedor){
        this(fornecedor.getCpfCnpj(), fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getCep());
    }
}
